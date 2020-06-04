package com.crnl.service;

import com.crnl.domain.User;
import com.crnl.domain.UserPersonalData;
import com.crnl.repos.UserPersonalDataRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserPersonalDataService {

    @Autowired
    UserPersonalDataRepos personalDataRepos;

    @Autowired
    private UserService userService;

    @Autowired
    private UserPersonalDataService userPersonalDataService;


    public UserPersonalData findById(Long id) {
        if (personalDataRepos.findById(id).isPresent())
            return personalDataRepos.findById(id).get();
        else
            return new UserPersonalData();
    }

    public void save(UserPersonalData personalData) {
        personalDataRepos.save(personalData);
    }

    public void registrationUserPersonalData(Map<String, String> form) {

        User user = userService.findById(Long.parseLong(form.get("userId")));

        UserPersonalData personalData;

        if (!user.isActivePersonalData()) {
            personalData = new UserPersonalData();
        }else{
            personalData = user.getPersonalData();
        }

        personalData.setDateOfBirth(java.sql.Date.valueOf(form.get("dateOfBirth")));
        personalData.setDateOfIssue(java.sql.Date.valueOf(form.get("dateOfIssue")));
        personalData.setDepartmentCode(form.get("departmentCode"));
        personalData.setPassportNumber(form.get("passportNumber"));
        personalData.setPassportSeries(form.get("passportSeries"));
        personalData.setPlaceOfResidence(form.get("placeOfResidence"));
        personalData.setPlaceOfBirth(form.get("placeOfBirth"));
        personalData.setFio(form.get("fio"));
        personalData.setGender(form.get("gender"));
        personalData.setPhone(form.get("phone"));
        personalData.setIssuedBy(form.get("issuedBy"));

        userPersonalDataService.save(personalData);

        user.setPersonalData(personalData);
        user.setActivPersonalData(true);

        userService.save(user);
    }
}
