package com.yuanwhy.mage.demo;

import com.yuanwhy.mage.client.MageClient;
import com.yuanwhy.mage.demo.api.HelloService;
import com.yuanwhy.mage.registry.api.MageRegistry;
import com.yuanwhy.mage.registry.zookeeper.ZkMageRegistry;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class ClientDemo {

    public static void main(String[] args) {

        MageRegistry mageRegistry = new ZkMageRegistry();
        MageClient mageClient = new MageClient<HelloService>(mageRegistry, "demo-service", HelloService.class);

        HelloService helloService = (HelloService) mageClient.get();

        String result = helloService.greeting("Rpc Man");

        System.out.println(result);

    }

}
