package com.crnl.controller;

import com.crnl.domain.Message;
import com.crnl.domain.User;
import com.crnl.repos.MessageRepos;
import com.crnl.service.ServiceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepos messageRepos;

    @Autowired
    private ServiceUpload serviceUpload;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model ){
        Iterable<Message> messages =  messageRepos.findAll();

        if(filter != null && !filter.isEmpty()){
            messages = messageRepos.findByTag(filter);
        } else{
            messages = messageRepos.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String,Object> model,
            @RequestParam ("file") MultipartFile file
            ) throws IOException {
        Message message = new Message(text, tag, user);


        message.setFilename(serviceUpload.saveUploadFileAndGetFileName(file)); /*Записываем в БД имя файла*/

        messageRepos.save(message);

        Iterable<Message> messages =  messageRepos.findAll();
        model.put("messages", messages);

        return "redirect:/main";
    }

}