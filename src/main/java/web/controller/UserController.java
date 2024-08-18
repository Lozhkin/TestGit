package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @GetMapping(value = "/users")
    public String users(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("count", count);
        System.out.println("users");
        return "users";
    }
}
