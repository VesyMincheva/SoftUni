package com.softuin.Battleships.cotroller;

import com.softuin.Battleships.model.dto.CreateShipDTO;
import com.softuin.Battleships.service.ShipServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipServiceImpl shipService;

    public ShipController(ShipServiceImpl shipService) {
        this.shipService = shipService;
    }


    @ModelAttribute
    public CreateShipDTO initCreateShipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String ships(){
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addShip(@Valid CreateShipDTO createShipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !this.shipService.createShip(createShipDTO)){
            redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/ships";
        }


        return "redirect:/home";
    }
}
