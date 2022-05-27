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
        ArrayList<Movie> movies = movieRepository.findAll();
        ArrayList<Genre> genres = new ArrayList<>();

        for (Movie movie : movies){
            genres.add(genreRepository.findById(movie.getId()));
        }

        model.addAttribute("accounts", accounts);
        model.addAttribute("movies", movies);
        model.addAttribute("genres", genres);
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
}
