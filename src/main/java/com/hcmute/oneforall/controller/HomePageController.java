package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.beans.Movie;
import com.hcmute.oneforall.repositories.MovieRepository;
import com.hcmute.oneforall.utils.MovieNameImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/")
public class HomePageController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("")
    public String getHomePage(Model model) {
        List<Movie> movies = movieRepository.findAll();
        ArrayList<String> names = new ArrayList<>();

        Map<String, Movie> mapMovies = new HashMap<>();

        names = MovieNameImageUtil.nameImages(movies);

        for (int i=0; i<movies.size(); i++){
            mapMovies.put(names.get(i), movies.get(i));
        }

        model.addAttribute("movies", mapMovies);
        return "index";
    }

    @PostMapping("")
    public String postHomePage(@ModelAttribute("mapMovie") Map<String, Movie> mapMovies,
                               ModelMap modelMap) {

        return "index";
    }
}
