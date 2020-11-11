package org.cc.service;

import java.util.concurrent.CompletableFuture;

public class AsyncTest9 {

    public static void main(String[] args) {
       String result = CompletableFuture.supplyAsync(() -> "hello world").join();
        System.out.println(result);
    }
}
