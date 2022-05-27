package com.hcmute.oneforall.utils;

import com.hcmute.oneforall.beans.Rating;

import java.util.ArrayList;

public class RatingsUtil {
    public static double ratings(ArrayList<Rating> ratings){
        double start = 0;
        for (Rating r:ratings){
            start += r.getSao();
        }
        return (double) Math.round((start/ratings.size() * 10) / 10);
    }
}
