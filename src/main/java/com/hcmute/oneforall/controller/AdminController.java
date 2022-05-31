package com.hcmute.oneforall.controller;

import com.hcmute.oneforall.beans.*;
import com.hcmute.oneforall.key.MovieCastKey;
import com.hcmute.oneforall.key.MovieDirectorKey;
import com.hcmute.oneforall.key.MovieGenreKey;
import com.hcmute.oneforall.key.RatingKey;
import com.hcmute.oneforall.repositories.*;
import com.hcmute.oneforall.utils.GetMovieWithGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @Autowired
    MovieGenreRepository movieGenreReposity;

    @Autowired
    MovieCastRepository movieCastRepository;

    @Autowired
    MovieDirectorRepository movieDirectorRepository;

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/{id}")
    public String dashBoard(Model model,
                            @PathVariable("id") int id,
                            HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);
            ArrayList<Account> accounts = accountRepository.findAll();
            ArrayList<Object[]> movieGenres = movieRepository.findAllMovieWithGenre();

            Map<Integer, String[]> movieWithGenre = GetMovieWithGenre.getMovieWithGenre(movieGenres);

            model.addAttribute("accounts", accounts);
            model.addAttribute("movies", movieWithGenre);
            model.addAttribute("admin", account);

            return "layouts/dashBoard";
        }

        return "layouts/dashBoard";
    }

    @GetMapping("/{id}/users")
    public String users(Model model,
                        @PathVariable("id") int id,
                        HttpSession session) {
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);
            ArrayList<Account> accounts = accountRepository.findAll();

            model.addAttribute("accounts", accounts);
            model.addAttribute("admin", account);

            return "layouts/users";
        }

        return "redirect:/404";
    }

    @GetMapping("/{id}/data")
    public String manageData(Model model,
                             @PathVariable("id") int id,
                             HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
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

        return "redirect:/404";
    }

    @GetMapping(value = "/{id}/film")
    public String film (Model model,
                        @PathVariable("id") int id,
                        HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);
            ArrayList<Object[]> movieGenres = movieRepository.findAllMovieWithGenre();

            Map<Integer, String[]> movieWithGenre = GetMovieWithGenre.getMovieWithGenre(movieGenres);

            model.addAttribute("movies", movieWithGenre);
            model.addAttribute("admin", account);

            return "layouts/film";
        }

        return "redirect:/404";
    }

    @GetMapping(value = "/{id}/data/add/actor")
    public String getAddData (Model model,
                            @PathVariable("id") int id,
                            HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);

            model.addAttribute("admin", account);
            model.addAttribute("actor", new Actor());

            return "layouts/addDataActor";
        }

        return "redirect:/404";
    }

    @PostMapping(value = "/{id}/data/add/actor")
    public String postAddData (@ModelAttribute("actor") Actor actor,
                               @PathVariable("id") int id){
        actor.setId(actorRepository.size() + 1);
        actorRepository.save(actor);

        return "redirect:/admin/"+ id + "/data/add/actor";
    }

    @GetMapping(value = "/{id}/data/add/director")
    public String getAddDirector (Model model,
                                    @PathVariable("id") int id,
                                    HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);

            model.addAttribute("admin", account);
            model.addAttribute("director", new Director());

            return "layouts/addDataDirector";
        }

        return "redirect:/404";
    }

    @PostMapping(value = "/{id}/data/add/director")
    public String postAddDirector (@ModelAttribute("director") Director director,
                                   @PathVariable("id") int id){
        director.setId(directorRepository.size() + 1);
        directorRepository.save(director);

        return "redirect:/admin/"+ id + "/data/add/director";
    }

    @GetMapping(value = "/{id}/data/add/genre")
    public String getAddGenre (Model model,
                               @PathVariable("id") int id,
                               HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);

            model.addAttribute("admin", account);
            model.addAttribute("genre", new Genre());

            return "layouts/addDataGenre";
        }

        return "redirect:/404";
    }

    @PostMapping(value = "/{id}/data/add/genre")
    public String postAddGenre (@ModelAttribute("genre") Genre genre,
                                @PathVariable("id") int id){
        genre.setId(genreRepository.size() + 1);
        genreRepository.save(genre);

        return "redirect:/admin/"+ id + "/data/add/genre";
    }

    @GetMapping(value = "/{id}/film/add")
    public String getAddFilm (Model model,
                              @PathVariable("id") int id,
                              HttpSession session){
        Account acc = accountRepository.getById(id);
        if(session.getAttribute("auth") != null && acc.isPhan_quyen()){
            Account account = accountRepository.findById(id);
            ArrayList<Actor> actors = actorRepository.findAll();
            ArrayList<Director> directors = directorRepository.findAll();
            ArrayList<Genre> genres = genreRepository.findAll();

            model.addAttribute("admin", account);
            model.addAttribute("movie", new Movie());
            model.addAttribute("actors", actors);
            model.addAttribute("directors", directors);
            model.addAttribute("genres", genres);

            return "layouts/addFilm";
        }

        return "redirect:/404";
    }

    @PostMapping(value = "/{id}/film/add")
    public String postAddFilm (@ModelAttribute("movie") Movie movie,
                               @RequestParam("director") ArrayList<Director> director,
                               @RequestParam("actor") ArrayList<Actor> actor,
                               @RequestParam("genre") ArrayList<Genre> genre,
                               @PathVariable("id") int id){
        movie.setId(movieRepository.size() + 1);
        movieRepository.save(movie);

        for (Genre gen : genre){
            int genId = genreRepository.findBymota(gen.getMo_ta());
            gen.setId(genId);

            MovieGenreKey movieGenreKey = new MovieGenreKey();

            movieGenreKey.setIdMV(movie.getId());
            movieGenreKey.setIdGR(genId);

            MovieGenre movieGenre = new  MovieGenre();
            movieGenre.setMovie(movie);
            movieGenre.setGenre(gen);

            movieGenre.setId(movieGenreKey);

            movieGenreReposity.save(movieGenre);
        }

        for (Director dir : director){
            int dirId = directorRepository.findByHoAndTen(dir.getHo(), dir.getTen());
            dir.setId(dirId);

            MovieDirectorKey movieDirectorKey = new MovieDirectorKey();

            movieDirectorKey.setIdDT(dirId);
            movieDirectorKey.setIdMV(movie.getId());

            MovieDirector movieDirector = new MovieDirector();
            movieDirector.setMovie(movie);
            movieDirector.setDirector(dir);

            movieDirector.setId(movieDirectorKey);

            movieDirectorRepository.save(movieDirector);
        }

        for (Actor act : actor){
            int actId = actorRepository.findByHoAndTen(act.getHo(), act.getTen());
            act.setId(actId);

            MovieCastKey movieCastKey = new MovieCastKey();

            movieCastKey.setIdMV(movie.getId());
            movieCastKey.setIdAT(actId);

            MovieCast movieCast = new MovieCast();
            movieCast.setMovie(movie);
            movieCast.setActor(act);

            movieCast.setId(movieCastKey);

            movieCastRepository.save(movieCast);
        }

        RatingKey ratingKey = new RatingKey();

        ratingKey.setIdMV(movie.getId());
        ratingKey.setIdTK(1);

        Rating rating = new Rating();
        rating.setAccount(accountRepository.findById(1));
        rating.setMovie(movie);
        rating.setSao(9);

        rating.setId(ratingKey);

        ratingRepository.save(rating);

         return "redirect:/admin/" + id + "/film/add";
    }
}
