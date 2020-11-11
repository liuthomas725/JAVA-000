package org.cc.service;

import org.cc.work.ThreadCallable1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncTest1 {

    public static String test() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new ThreadCallable1());
        try {
            return future.get();
        } catch (InterruptedException e) {
            return "";
        } catch (ExecutionException e) {
            return "";
        }finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
