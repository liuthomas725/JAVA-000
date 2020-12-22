package io.kimmking.rpcfx.demo.api;

import io.kimmking.rpcfx.annotation.Rpc;
import org.springframework.stereotype.Service;

@Rpc(url = "http://localhost:8080/")
public interface OrderService {

    Order findOrderById(int id);

}
