package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printIndexPage() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "redirect:/admin/users";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @GetMapping("/admin/users")
    public String printUsersPage(@RequestParam(value = "count", required = false, defaultValue = "20") Integer count, Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("count", count);

        return "users";
    }

    @GetMapping("/admin/users/user")
    public String printUserPage(@RequestParam(value = "id", required = false) Long id,
                                @RequestParam(value = "mode", defaultValue = "edit") String mode,
                                Model model) {
        if (id != null) {
            model.addAttribute("user", userService.readUser(id));
        } else {
            model.addAttribute("user", new User());
        }
        model.addAttribute("mode", mode);
        return "user-card";
    }

    @PostMapping("/admin/users")
    public String saveUser(User user, Model model) {
        model.addAttribute("user", user);
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("/admin/users")
    public String updateUser(@RequestParam("id") Long id, User user, Model model) {
        model.addAttribute("user", user);
        userService.updateUser(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
