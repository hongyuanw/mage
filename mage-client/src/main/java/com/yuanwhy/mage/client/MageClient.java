package com.yuanwhy.mage.client;

import com.yuanwhy.mage.registry.api.MageRegistry;
import com.yuanwhy.mage.rpc.rmi.RmiInvocationHandler;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.reflect.Proxy;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class MageClient<T> {

    private static Logger logger = LoggerFactory.getLogger(MageClient.class);

    private MageRegistry mageRegistry;

    private List<Member> members = new ArrayList<>();

    private String serviceName;

    private Class<T> iface;

    public MageClient(MageRegistry mageRegistry, String serviceName, Class<T> iface) {
        this.mageRegistry = mageRegistry;
        this.serviceName = serviceName;
        this.iface = iface;
    }

    public MageRegistry getMageRegistry() {
        return mageRegistry;
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

            RmiInvocationHandler rmiInvocationHandler = (RmiInvocationHandler) rmiRegistry.lookup(iface.getName());

            return (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class[]{iface}, new ClientProxyInvocationHandler(rmiInvocationHandler));
        } catch (Exception e) {

            logger.error("connect server refused");
            throw new RuntimeException(e);

        }

    }

    private void init(){

        // TODO: 31/10/2017 get members info from mage mageRegistry
        members.add(new Member("127.0.0.1", 1099));
    }
}
