package com.yuanwhy.mage;

import com.yuanwhy.mage.registry.api.Registry;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class YClient<T> {

    private static Logger logger = LoggerFactory.getLogger(YClient.class);

    private Registry registry;

    private List<Member> members = new ArrayList<>();

    private String serviceName;

    private Class iface;

    public YClient(Registry registry, String serviceName, Class iface) {
        this.registry = registry;
        this.serviceName = serviceName;
        this.iface = iface;
    }

    public Registry getRegistry() {
        return registry;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Class getIface() {
        return iface;
    }

    public T get() {

        // TODO: 30/10/2017 load balance algorithms
        if (CollectionUtils.isEmpty(members)) {
            init();
        }

        Member member = members.get(0);

        try {
            java.rmi.registry.Registry rmiRegistry = LocateRegistry.getRegistry(member.getIp(), member.getPort());

            return (T)rmiRegistry.lookup(iface.getName());

        } catch (Exception e) {

            logger.error("connect server refused");
            throw new RuntimeException(e);

        }

    }

    private void init(){

        // TODO: 31/10/2017 get members info from mage registry
        members.add(new Member("127.0.0.1", 1099));
    }
}
