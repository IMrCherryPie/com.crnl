package com.crnl.service;

import com.crnl.domain.Role;
import com.crnl.domain.User;
import com.crnl.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepos userRepos;
    @Autowired
    private MailSender mailSender;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepos.findByUsername(username);
    }
/*Если пользвоатель найден в базе данных, то мы возвращаем false, пользователь не добавлен*/
    public boolean addUser(User user){
        User userFromDB = userRepos.findByUsername(user.getUsername());

        if (userFromDB != null){
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));/*Данный шот кад в виде Collection.singleton нужен для того что user.role ожидает очередь, а мы собираемся присвоить лишь одно значение*/
        user.setActivationCode(UUID.randomUUID().toString());/*Гененируем уникальный ID для создания уникальной ссылки для подтвержденя пользвоаетля*/

        userRepos.save(user);
        if (!StringUtils.isEmpty(user.getEmail())){
            /*Выполняем отправку сообщения только для не пустой строчки email*/
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Car Rental site. Please, visit next link: http:/localhost:8080/activate/%s ",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);

        }

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepos.findByActivationCode(code);

        if (user == null){
            return false; /*Активация не удалась*/
        }
        user.setActivationCode(null);

        userRepos.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepos.findAll();
    }

    public User findById(Long id){
        if (userRepos.findById(id).isPresent())
            return userRepos.findById(id).get();
        else
            return new User();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear(); /* Чистим роли пользователя пржде чем внести изменения*/

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepos.save(user);
    }

    public void save(User user) {
        userRepos.save(user);
    }
}
