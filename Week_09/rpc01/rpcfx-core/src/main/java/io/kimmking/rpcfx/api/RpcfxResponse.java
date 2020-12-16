package io.kimmking.rpcfx.api;

import io.kimmking.rpcfx.exception.RpcfxException;

public class RpcfxResponse {

    private Object result;

    private boolean status;

    private RpcfxException rpcfxException;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RpcfxException getException() {
        return rpcfxException;
    }

    public void setException(RpcfxException rpcfxException) {
        this.rpcfxException = rpcfxException;
    }
}
