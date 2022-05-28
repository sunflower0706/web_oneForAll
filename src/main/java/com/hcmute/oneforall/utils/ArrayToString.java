package com.hcmute.oneforall.utils;

import java.util.ArrayList;

public class ArrayToString {
    public static String arrToString(ArrayList<String> strings){
        return strings.toString().replaceAll("[\\[\\]]","");
    }
}
