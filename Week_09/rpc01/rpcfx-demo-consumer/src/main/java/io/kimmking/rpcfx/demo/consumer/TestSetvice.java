package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;
import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSetvice {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    public void test(){
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());

        Order order = orderService.findOrderById(1992129);
        System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));
    }
}
