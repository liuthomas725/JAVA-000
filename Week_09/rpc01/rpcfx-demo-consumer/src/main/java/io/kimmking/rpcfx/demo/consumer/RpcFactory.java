package io.kimmking.rpcfx.demo.consumer;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * spring使用FactoryBean的实现类来实例化对象
 * @param <T>
 */
public class RpcFactory<T> implements FactoryBean<T> {

    private Class<T> rpcClass;

    public RpcFactory(Class<T> rpcClass) {
        this.rpcClass = rpcClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public T getObject() {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{rpcClass}, new NullInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return rpcClass;
    }

    public static class NullInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            return method.invoke(proxy,params);
        }
    }
}
