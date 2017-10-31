package com.yuanwhy.mage.demo.server;

import com.yuanwhy.mage.registry.api.MageRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongyuan.wang on 31/10/2017.
 */
public class MageServer {

    private static Logger logger = LoggerFactory.getLogger(MageServer.class);

    private MageRegistry registry;

    private int port;

    private Set<Class> ifaces = new HashSet<>();

    private Registry rmiRegistry;

    public MageServer(MageRegistry registry, int port) {
        this.registry = registry;
        this.port = port;
    }

    public MageRegistry getRegistry() {
        return registry;
    }

    public int getPort() {
        return port;
    }

    public <T> void addOneService(Class<T> iface, Remote impl){

        ifaces.add(iface);

        try {

            Remote stub = UnicastRemoteObject.exportObject(impl, 0);

            if (rmiRegistry == null) {
                init();
            }

            rmiRegistry.rebind(iface.getName(), stub);

        } catch (RemoteException e) {
            logger.error("add one service error");
            throw new RuntimeException(e);
        }

    }

    private void init() {
        try {
            rmiRegistry = LocateRegistry.createRegistry(port);

            logger.info("mage server is running");
        } catch (RemoteException e) {
            logger.error("init mage server error");
            throw new RuntimeException(e);
        }
    }




}
