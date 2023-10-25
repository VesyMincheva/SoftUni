package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {
    private final WordService wordService;
    private final UserService userService;

    public WordController(WordService wordService, UserService userService) {
        this.wordService = wordService;
        this.userService = userService;
    }


    @ModelAttribute("addWordDto")
    public AddWordDTO initAddWord() {
        return new AddWordDTO();
    }

    @GetMapping("/word/add")
    public String words() {
        if (this.userService.getLoggedUserId() == 0) {
            return "redirect:/login";
        }
        return "word-add";
    }

    @PostMapping("/word/add")
    public String words(@Valid AddWordDTO addWordDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.userService.getLoggedUserId() == 0) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors() || !this.wordService.create(addWordDto)){
            redirectAttributes.addFlashAttribute("addWordDto", addWordDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addWordDto", bindingResult);

            return "redirect:/word/add";
        }


        return "redirect:/home";
    }

}
