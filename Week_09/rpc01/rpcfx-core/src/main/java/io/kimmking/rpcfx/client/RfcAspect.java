package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.annotation.Rpc;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.exception.RpcfxException;
import io.kimmking.rpcfx.server.RpcfxInvoker;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static io.kimmking.rpcfx.client.Rpcfx.RpcfxInvocationHandler.JSONTYPE;

@Aspect
public class RfcAspect {
    @Autowired
    RpcfxInvoker invoker;

    @Pointcut(value = "@annotation(io.kimmking.rpcfx.annotation.Rpc)")
    public void poincut() {
    }

    @Around("poincut()")
    public Object around(ProceedingJoinPoint pjp) {
        RpcfxRequest request = new RpcfxRequest();
        Signature signature = pjp.getSignature();
        request.setServiceClass(pjp.getTarget().getClass().getName());
        request.setMethod(signature.getName());
        request.setParams(pjp.getArgs());
        RpcfxResponse response;
        try {
            response = post(request, pjp.getTarget().getClass().getAnnotation(Rpc.class).url());
            return JSON.parse(response.getResult().toString());
        } catch (Exception e) {
            response = new RpcfxResponse();
            response.setException(new RpcfxException(e.getMessage()));
            return JSON.parse(response.getResult().toString());
        }
    }

    private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: " + reqJson);

        // 1.可以复用client
        // 2.尝试使用httpclient或者netty client
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSONTYPE, reqJson))
                .build();
        String respJson = client.newCall(request).execute().body().string();
        System.out.println("resp json: " + respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }
}
