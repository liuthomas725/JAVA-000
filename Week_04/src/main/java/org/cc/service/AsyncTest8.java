package org.cc.service;

import lombok.SneakyThrows;
import org.cc.entity.Result;
import org.cc.work.ThreadRunable3;

public class AsyncTest8 {

    @SneakyThrows
    public static void main(String[] args) {
        Result result = new Result();
        Thread thread = new Thread(new ThreadRunable3(result));
        thread.start();
        synchronized(AsyncTest8.class){
           AsyncTest8.class.wait();
        }
        System.out.println(result.getName());
    }
}
