package org.cc.work;

import lombok.SneakyThrows;
import org.cc.entity.Result;

import java.util.concurrent.CountDownLatch;

public class ThreadRunable2 implements Runnable {

    private Result result;

    private CountDownLatch countDownLatch;

    public ThreadRunable2(Result result, CountDownLatch countDownLatch) {
        this.result = result;
        this.countDownLatch = countDownLatch;
    }

    public String doThing() {
        return "hello world";
    }

    @SneakyThrows
    @Override
    public void run() {
        result.setName(doThing());
        countDownLatch.countDown();
    }
}
