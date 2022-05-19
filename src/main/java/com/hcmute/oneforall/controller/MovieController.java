package com.hcmute.oneforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
    @RequestMapping(value = "/info")
    public static String movieInfo(Model model){
        return "layouts/movieInfo";
    }

//    @PostMapping(value = "/info")
//    public static String movieInfo(){
//        return "layouts/movieInfo";
//    }
}
