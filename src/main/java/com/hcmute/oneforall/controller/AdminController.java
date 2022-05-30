package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.*;
import com.hcmute.oneforall.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/{id}")
    public String dashBoard(Model model,
                            @PathVariable("id") int id){
        Account account = accountRepository.findById(id);
        ArrayList<Account> accounts = accountRepository.findAll();
        ArrayList<Object[]> movieGenres = movieRepository.findAllMovieWithGenre();

        Map<Integer, String[]> movieWithGenre = new HashMap<>();

        for (Object[] movie : movieGenres){
            int idMV = Integer.parseInt(movie[0].toString());
            if (!movieWithGenre.containsKey(idMV)){
                movieWithGenre.put(idMV, new String[]{"",""});
            }
            String name = movie[1].toString();
            String genre = movie[2].toString();
            if (!movieWithGenre.get(idMV)[1].toString().equals("")){
                genre = movieWithGenre.get(idMV)[1] + ", " + movie[2].toString();
            }
            String[] nameAndGenre = {name, genre};
            movieWithGenre.put(idMV, nameAndGenre);
        }

        model.addAttribute("accounts", accounts);
        model.addAttribute("movies", movieWithGenre);
        model.addAttribute("admin", account);

        return "layouts/dashBoard";
    }

    @GetMapping("/{id}/users")
    public String users(Model model,
                        @PathVariable("id") int id) {
        Account account = accountRepository.findById(id);
        ArrayList<Account> accounts = accountRepository.findAll();

        model.addAttribute("accounts", accounts);
        model.addAttribute("admin", account);
        return "layouts/users";
    }

    @GetMapping("/{id}/data")
    public String manageData(Model model,
                             @PathVariable("id") int id){
        Account account = accountRepository.findById(id);
        ArrayList<Genre> genres = genreRepository.findAll();
        ArrayList<Director> directors = directorRepository.findAll();
        ArrayList<Actor> actors = actorRepository.findAll();

        model.addAttribute("genres", genres);
        model.addAttribute("directors", directors);
        model.addAttribute("actors", actors);
        model.addAttribute("admin", account);

        return "layouts/manageData";
    }

    @GetMapping(value = "/{id}/film")
    public String film (Model model,
                        @PathVariable("id") int id){
        return "layouts/film";
    }

    @GetMapping(value = "/{id}/film/edit")
    public String editFilm (Model model,
                        @PathVariable("id") int id){
        return "layouts/editFilm";
    }

    @GetMapping(value = "/{id}/data/edit")
    public String editData (Model model,
                        @PathVariable("id") int id){
        return "layouts/editData";
    }

    @GetMapping(value = "/{id}/data/edit/director")
    public String editDataDirector (Model model,
                            @PathVariable("id") int id){
        return "layouts/editDataDirector";
    }

    @GetMapping(value = "/{id}/data/edit/genre")
    public String editDataGenre (Model model,
                                    @PathVariable("id") int id){
        return "layouts/editDataGenre";
    }
}
