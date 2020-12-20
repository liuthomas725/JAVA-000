package io.kimmking.rpcfx.demo.consumer;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcFactory<T> implements FactoryBean<T> {

    private Class<T> rpcClass;
    /**
     *
     * @param rpcClass  TestInterface 接口class
     */
    public RpcFactory(Class<T> rpcClass) {
        this.rpcClass = rpcClass;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public T getObject() {
        return (T) Proxy.newProxyInstance(rpcClass.getClassLoader(), new Class[]{rpcClass}, new NullInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return rpcClass;
    }

    public static class NullInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            try {
                // getDeclaringClass method 方法在哪个类class中
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, params);
                }
            } catch (Throwable t) {
                throw t;
            }
            System.out.println("调用"+method.getName()+"方法成功");
            // 执行sql 操作。
            return "";
        }
    }
}
