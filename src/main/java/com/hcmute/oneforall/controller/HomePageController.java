package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.repositories.*;
import com.hcmute.oneforall.utils.MovieNameImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "/")
public class HomePageController {
    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("")
    public String getHomePage(Model model) {
        ArrayList<Object[]> movies = movieRepository.findAllMovieWithRating();
        ArrayList<String> names = new ArrayList<>();

        for (Object[] movie : movies){
            names.add(MovieNameImageUtil.nameImage(movie[1].toString()));
        }

        model.addAttribute("movies", movies);
        model.addAttribute("names", names);

        return "index";
    }

    @GetMapping(value = "/404")
    public String errorPage(){
        return "404";
    }
}
