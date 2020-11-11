package org.cc.service;

import org.cc.entity.Result;
import org.cc.work.ThreadRunable1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class AsyncTest4 {

    public static String test(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Result result = new Result();
        FutureTask<Result> futureTask = new FutureTask(new ThreadRunable1(result), result);
        executorService.submit(futureTask);
        try {
            return futureTask.get().getName();
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
