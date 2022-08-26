package web.springcourse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.springcourse.models.User;
import web.springcourse.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userDao) {
        this.userService = userDao;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userService.index());
        return "user/index";
    }
    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "user/show";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user){
//                           BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return "user/new";
//        }
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model,@PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "user/edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/user";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
