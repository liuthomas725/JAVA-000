package org.cc.work;

import java.util.concurrent.Callable;

public class ThreadCallable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello world";
    }
}
