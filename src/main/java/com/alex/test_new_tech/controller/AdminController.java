package com.alex.test_new_tech.controller;

import com.alex.test_new_tech.model.User;
import com.alex.test_new_tech.service.RoleService;
import com.alex.test_new_tech.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String vievForAll(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAll());
        return "admin_users";
    }

    @GetMapping("/add_user")
    public String addUser(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("roles", roleService.getAll());
        return "admin_add_user";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user){
        log.info("Add user: "+user.toString());
        userService.add(user);
        return "redirect:/admin/add_user";
    }

    @GetMapping("/userId{id}")
    public String userByID(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getById((long) id));
        return "admin_user_by_id";
    }

    @GetMapping("/userId{id}/edit")
    public String editUser(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getById((long) id));
        modelMap.addAttribute("roles", roleService.getAll());
        return "admin_edit_user";
    }

    @PostMapping("/userId{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("user") User updatedUser){
        userService.update(updatedUser);
        return "redirect:/admin/add_user";
    }

    @DeleteMapping("/userId{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete((long) id);
        return "redirect:/admin/add_user";
    }


}
