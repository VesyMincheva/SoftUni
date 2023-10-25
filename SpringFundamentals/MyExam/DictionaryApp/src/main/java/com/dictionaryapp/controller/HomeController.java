package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.HomeDTO;
import com.dictionaryapp.model.dto.LoginDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final UserService userService;
    private final WordService wordService;

    public HomeController(UserService userService, WordService wordService) {
        this.userService = userService;
        this.wordService = wordService;
    }

    @ModelAttribute("homeDTO")
    public HomeDTO initHomeDto (){
        return new HomeDTO();
    }

    @GetMapping("/index")
    public String loggedOutIndex() {
        if (this.userService.getLoggedUserId() > 0) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String loggedHome (Model model){
        if (this.userService.getLoggedUserId() == 0) {
            return "redirect:/index";
        }

        return "home";
    }
}
