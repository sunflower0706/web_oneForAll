package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.Movie;
import com.hcmute.oneforall.repositories.GenreRepository;
import com.hcmute.oneforall.repositories.MovieGenreRepository;
import com.hcmute.oneforall.repositories.MovieRepository;
import com.hcmute.oneforall.utils.MovieNameImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    @GetMapping(value = "/info/{name}/{id}")
    public String movieInfo(Model model,
                                   @PathVariable("id") int id){
        Movie movie = movieRepository.findById(id);

        String name = MovieNameImageUtil.nameImage(movie);
        model.addAttribute("movie", movie);
        model.addAttribute("name", name);
        return "layouts/movieInfo";
    }



    @GetMapping(value = "/theatre/{name}/{id}")
    public String movieTheatre(Model model,
                                      @PathVariable("id") int id){
        Movie movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);
        return "layouts/movieTheatre";
    }
}
