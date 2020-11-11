package org.cc.service;

import org.cc.work.ThreadCallable1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class AsyncTest3 {

    public static String test(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(new ThreadCallable1());
        executorService.submit(futureTask);
        try {
            return futureTask.get();
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
