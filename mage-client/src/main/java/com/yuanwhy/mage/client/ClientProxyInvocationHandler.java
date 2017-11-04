package com.yuanwhy.mage.client;

import com.yuanwhy.mage.rpc.rmi.RmiInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hongyuan.wang on 04/11/2017.
 */
public class ClientProxyInvocationHandler implements InvocationHandler {

    private RmiInvocationHandler rmiInvocationHandler;


    public ClientProxyInvocationHandler(RmiInvocationHandler rmiInvocationHandler) {
        this.rmiInvocationHandler = rmiInvocationHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return rmiInvocationHandler.invoke(method.getName(), method.getParameterTypes(), args);

    }

    public RmiInvocationHandler getRmiInvocationHandler() {
        return rmiInvocationHandler;
    }
}
