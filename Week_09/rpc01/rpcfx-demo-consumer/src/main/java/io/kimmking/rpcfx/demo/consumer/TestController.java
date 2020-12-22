package io.kimmking.rpcfx.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestSetvice testSetvice;

    @GetMapping("/print")
    public void print(){
        testSetvice.test();
    }
}
