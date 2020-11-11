package org.cc.work;

import org.cc.entity.Result;

public class ThreadRunable1 implements Runnable {

    private Result result;

    public ThreadRunable1(Result result) {
        this.result = result;
    }

    public String doThing() {
        return "hello world";
    }

    @Override
    public void run() {
        result.setName(doThing());
    }
}
