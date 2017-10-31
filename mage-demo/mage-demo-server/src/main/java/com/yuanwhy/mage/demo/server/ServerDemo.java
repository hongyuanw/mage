package com.yuanwhy.mage.demo.server;

import com.yuanwhy.mage.demo.api.HelloService;
import com.yuanwhy.mage.registry.api.MageRegistry;
import com.yuanwhy.mage.registry.zookeeper.ZkMageRegistry;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class ServerDemo {

    public static void main(String[] args) {

        // TODO: 23/10/2017 start a mage server to serve
        MageRegistry registry = new ZkMageRegistry();

        HelloService helloService = new HelloServiceImpl();

        MageServer mageServer = new MageServer(registry, 1099);

        mageServer.addOneService(HelloService.class, helloService);




    }

}
