package com.hcmute.oneforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @GetMapping("")
    public String dashBoard() {
        return "layouts/dashBoard";
    }

    @GetMapping("/users")
    public String users() {
        return "layouts/users";
    }

    @GetMapping("/data")
    public String manageData() {
        return "layouts/manageData";
    }
}
