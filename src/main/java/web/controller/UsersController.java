package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UsersController {

    private UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printAllUser(ModelMap model, HttpServletRequest request) {
        model.addAttribute("cars", userService.getListUsers());
        return "users";
    }
    @GetMapping("/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String showUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "oneUser";
    }
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}
