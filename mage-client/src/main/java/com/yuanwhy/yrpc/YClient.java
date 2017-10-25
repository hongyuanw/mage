package com.yuanwhy.mage;

import com.yuanwhy.mage.registry.api.Registry;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class YClient {

    private Registry registry;

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

    public Object getBean() {
        // TODO: 23/10/2017
        return null;
    }
}
