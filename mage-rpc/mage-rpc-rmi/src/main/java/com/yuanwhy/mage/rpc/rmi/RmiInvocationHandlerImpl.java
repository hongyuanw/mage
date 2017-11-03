package com.yuanwhy.mage.rpc.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * Created by hongyuan.wang on 03/11/2017.
 */
public class RmiInvocationHandlerImpl implements RmiInvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(RmiInvocationHandlerImpl.class);

    private Object targetObject;

    public RmiInvocationHandlerImpl(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    @Override
    public Object invoke(String methodName, Class[] parameterTypes, Object[] arguments) throws RemoteException {

        Method method = null;
        try {
            method = targetObject.getClass().getMethod(methodName, parameterTypes);

        } catch (NoSuchMethodException e) {

            logger.error("no such method {}", methodName);

            throw new RuntimeException(e);

        }

        try {

            return method.invoke(targetObject, arguments);

        } catch (IllegalAccessException e) {

            throw new RuntimeException(e);

        } catch (InvocationTargetException e) {

            throw new RuntimeException(e);

        }

    }

}
