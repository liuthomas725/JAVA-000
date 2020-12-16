package io.kimmking.rpcfx.demo.api;

import io.kimmking.rpcfx.annotation.Rpc;

@Rpc(url = "http://localhost:8080/")
public interface UserService {

    User findById(int id);

}
