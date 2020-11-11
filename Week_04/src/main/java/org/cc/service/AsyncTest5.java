package org.cc.service;

import org.cc.entity.Result;
import org.cc.work.ThreadRunable1;

public class AsyncTest5 {

    public static String test(){
        Result result = new Result();
        Thread thread = new Thread(new ThreadRunable1(result));
        thread.start();
        try {
            thread.join();
            return result.getName();
        } catch (InterruptedException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
