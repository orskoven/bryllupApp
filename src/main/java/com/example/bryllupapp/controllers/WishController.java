package com.example.bryllupapp.controllers;

import com.example.bryllupapp.models.Wish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WishController {

    @GetMapping("/addwish")
            public String showAddWish(Model model){
            model.addAttribute("wish", new Wish());
        return "add-wish";
}


    @PostMapping("/addwish")
    public String registerWish(@ModelAttribute Wish wish,
                                                     Model model,
                                                     RedirectAttributes attributes) {
        String result = "";
        model.addAttribute("wish", wish);
        if (wish.getName().isEmpty()) {
            attributes.addFlashAttribute("errormessage", "Alle felter skal være udfyldt!");
            result = "redirect:/add-wish";
        } else {
            result = "add-wish-result";
        }
        return result;
    }

}
