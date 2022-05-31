package com.hcmute.oneforall.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetMovieWithGenre {
    public static Map<Integer, String[]> getMovieWithGenre(ArrayList<Object[]> movieGenres){
        Map<Integer, String[]> movieWithGenre = new HashMap<>();

        for (Object[] movie : movieGenres) {
            int idMV = Integer.parseInt(movie[0].toString());
            if (!movieWithGenre.containsKey(idMV)) {
                movieWithGenre.put(idMV, new String[]{"", ""});
            }
            String name = movie[1].toString();
            String genre = movie[2].toString();
            String release = movie[3].toString();
            if (!movieWithGenre.get(idMV)[1].equals("")) {
                genre = movieWithGenre.get(idMV)[1] + ", " + movie[2].toString();
            }
            String[] nameAndGenre = {name, genre, release};
            movieWithGenre.put(idMV, nameAndGenre);
        }

        return movieWithGenre;
    }
}
