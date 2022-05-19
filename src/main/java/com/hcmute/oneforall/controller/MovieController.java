package com.hcmute.oneforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "movie")
public class MovieController {
    @GetMapping(value = "/info")
    public static String movieInfo(Model model){
        return "layouts/movieInfo";
    }



    @GetMapping(value = "/theatre")
    public static String movieTheatre(){
        return "layouts/movieTheatre";
    }
}
