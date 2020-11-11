package org.cc.work;

import lombok.SneakyThrows;
import org.cc.entity.Result;
import org.cc.service.AsyncTest8;

public class ThreadRunable3 implements Runnable {

    private Result result;

    public ThreadRunable3(Result result) {
        this.result = result;
    }

    public String doThing() {
        return "hello world";
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (AsyncTest8.class) {
            result.setName(doThing());
            AsyncTest8.class.notifyAll();
        }
    }
}
