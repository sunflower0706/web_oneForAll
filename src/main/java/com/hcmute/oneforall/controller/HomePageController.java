package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.beans.Movie;
import com.hcmute.oneforall.beans.Rating;
import com.hcmute.oneforall.repositories.GenreRepository;
import com.hcmute.oneforall.repositories.MovieGenreRepository;
import com.hcmute.oneforall.repositories.MovieRepository;
import com.hcmute.oneforall.repositories.RatingRepository;
import com.hcmute.oneforall.utils.MovieNameImageUtil;
import com.hcmute.oneforall.utils.RatingsUtil;
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

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("")
    public String getHomePage(Model model) {
        ArrayList<Movie> movies = movieRepository.findAll();
        ArrayList<Rating> ratings;
        ArrayList<String> names = MovieNameImageUtil.nameImages(movies);
        ArrayList<Double> starts = new ArrayList<>();

        for (Movie movie : movies) {
            double start = 0;
            ratings = ratingRepository.findAllByIdMV(movie.getId());
            start = RatingsUtil.ratings(ratings);

            starts.add(start);
        }

        model.addAttribute("movies", movies);
        model.addAttribute("names", names);
        model.addAttribute("stars", starts);
        System.out.println(movies);
        System.out.println(names);
        System.out.println(starts);
        return "index";
    }

    @PostMapping("")
    public String postHomePage(@ModelAttribute("mapMovie") Map<String, Movie> mapMovies,
                               ModelMap modelMap) {

        return "index";
    }
}
