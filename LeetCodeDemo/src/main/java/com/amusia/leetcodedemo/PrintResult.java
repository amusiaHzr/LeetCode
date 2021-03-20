package com.amusia.leetcodedemo;

import com.google.gson.Gson;

public class PrintResult {
    public static void print(Object o){
        System.out.println("result :"+new Gson().toJson(o));
    }

    public static void print(String s,Object o){
        System.out.println(s+new Gson().toJson(o));
    }
}
