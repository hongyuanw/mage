package com.yuanwhy.mage.demo;

import com.yuanwhy.mage.YClient;
import com.yuanwhy.mage.demo.api.HelloService;
import com.yuanwhy.mage.registry.api.Registry;
import com.yuanwhy.mage.registry.zookeeper.ZkRegistry;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class ClientDemo {

    public static void main(String[] args) {

        Registry registry = new ZkRegistry();
        YClient yClient = new YClient<HelloService>(registry, "demo-service", HelloService.class);

        HelloService helloService = (HelloService) yClient.get();

        String result = helloService.greeting("Rpc Man");

        System.out.println(result);

    }

}
