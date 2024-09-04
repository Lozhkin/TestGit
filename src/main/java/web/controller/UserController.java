package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users(@RequestParam(value = "count", required = false, defaultValue = "20") Integer count, Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("count", count);

        return "users";
    }

    @GetMapping("/users/user")
    public String user(@RequestParam(value = "id", required = false) Long id,
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

    @PostMapping("/users")
    public String saveUser(User user, Model model) {
        model.addAttribute("user", user);
        userService.createUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/users")
    public String updateUser(@RequestParam("id") Long id, User user, Model model) {
        model.addAttribute("user", user);
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
