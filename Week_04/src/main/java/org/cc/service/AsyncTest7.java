package org.cc.service;

import lombok.SneakyThrows;
import org.cc.entity.Result;
import org.cc.work.ThreadRunable2;

import java.util.concurrent.CountDownLatch;

public class AsyncTest7 {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @SneakyThrows
    public static void main(String[] args) {
        Result result = new Result();
        Thread thread = new Thread(new ThreadRunable2(result,countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println(result.getName());
    }
}
