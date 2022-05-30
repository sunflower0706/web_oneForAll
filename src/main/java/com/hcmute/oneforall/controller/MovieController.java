package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.Movie;
import com.hcmute.oneforall.repositories.*;
import com.hcmute.oneforall.utils.ArrayToString;
import com.hcmute.oneforall.utils.MovieNameImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping(value = "movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "/info/{name}/{id}")
    public String movieInfo(Model model,
                                   @PathVariable("id") int id){
        Movie movie = movieRepository.findById(id);
        if (movie != null){
            String name = MovieNameImageUtil.nameImage(movie.getTen_phim());
            ArrayList<String> genres = movieRepository.findGenres(id);
            ArrayList<String> directors = movieRepository.findDirector(id);
            ArrayList<String> actors = movieRepository.findActors(id);

            model.addAttribute("movie", movie);
            model.addAttribute("genres", ArrayToString.arrToString(genres));
            model.addAttribute("directors", ArrayToString.arrToString(directors));
            model.addAttribute("actors", ArrayToString.arrToString(actors));
            model.addAttribute("name", name);

            return "layouts/movieInfo";
        }

        return "redirect:/404";
    }



    @GetMapping(value = "/theatre/{name}/{id}")
    public String movieTheatre(Model model,
                               @PathVariable("id") int id,
                               @PathVariable("name") String name){
        Movie movie = movieRepository.findById(id);
        String[] names = name.split(" ");
        String[] linkPhims = movie.getLink_phim().split(";");
        String linkPhim;
        int ep = 0;
        if (!Objects.equals(names[names.length - 1], "cuoi")){
            ep = Integer.parseInt(names[names.length-1]);
            linkPhim = linkPhims[ep-1];
        }else {
            linkPhim = linkPhims[linkPhims.length-1];
        }

        if(ep < linkPhims.length){
            model.addAttribute("movie", movie);
            model.addAttribute("linkPhim", linkPhim);

            return "layouts/movieTheatre";
        }

        return "redirect:/404";
    }
}
