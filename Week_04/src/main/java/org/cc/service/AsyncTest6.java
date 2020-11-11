package org.cc.service;

import lombok.SneakyThrows;
import org.cc.entity.Result;
import org.cc.work.ThreadRunable1;

import java.util.concurrent.TimeUnit;

public class AsyncTest6 {

    @SneakyThrows
    public static void main(String[] args) {
        Result result = new Result();
        Thread thread = new Thread(new ThreadRunable1(result));
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(result.getName());
    }
}
