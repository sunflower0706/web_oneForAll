package com.hcmute.oneforall.utils;

import com.hcmute.oneforall.beans.Account;
import com.hcmute.oneforall.beans.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieNameImageUtil {
    public static String nameImage(String name){

        return name.replace(" ","%20");
    }
}
