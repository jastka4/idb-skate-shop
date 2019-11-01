package org.jastka4.pwr.idb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "test name");
        return "home";
    }
}
