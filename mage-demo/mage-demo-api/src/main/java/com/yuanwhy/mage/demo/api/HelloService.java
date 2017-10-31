package com.yuanwhy.mage.demo.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public interface HelloService extends Remote{

    String greeting(String name) throws RemoteException;

}
