package com.yuanwhy.mage.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by hongyuan.wang on 03/11/2017.
 */
public interface RmiInvocationHandler extends Remote {

    Object invoke(String methodName, Class[] parameterTypes, Object[] arguments) throws RemoteException;

}
