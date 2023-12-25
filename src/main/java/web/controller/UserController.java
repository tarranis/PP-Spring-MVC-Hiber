package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printAllUser(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user/allUsers";
    }

    @GetMapping("/newUser")
    public String addNewUser(@ModelAttribute("newuser") User user) {
        return "user/newUser";
    }

    @PostMapping()
    public String addToDB(@ModelAttribute("newuser") User user) {
        userService.save(user);
        return "redirect:/user";
    }

}
