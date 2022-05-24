package com.hcmute.oneforall.utils;

import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieNameImageUtil {
    public static ArrayList<String> nameImages(List<Movie> movies){
        ArrayList<String> names = new  ArrayList<>();
        for (Movie movie : movies){
            String unSpace = movie.getTen_phim().replace(" ","%20");
            names.add(unSpace);
        }

        return names;
    }

    public static String nameImage(Movie movie){

        return movie.getTen_phim().replace(" ","%20");
    }
}
