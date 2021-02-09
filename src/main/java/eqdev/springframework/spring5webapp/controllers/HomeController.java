package eqdev.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }
    @GetMapping
    String index() {
        return "home/open";
    }

//    @GetMapping("/")
//    String index(Principal principal) {
//        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//    }
}
