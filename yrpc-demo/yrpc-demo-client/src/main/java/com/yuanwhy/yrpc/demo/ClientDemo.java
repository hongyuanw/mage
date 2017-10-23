package com.yuanwhy.yrpc.demo;

import com.yuanwhy.yrpc.YClient;
import com.yuanwhy.yrpc.demo.api.HelloService;
import com.yuanwhy.yrpc.registry.api.Registry;
import com.yuanwhy.yrpc.registry.zookeeper.ZkRegistry;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class ClientDemo {

    public static void main(String[] args) {

        Registry registry = new ZkRegistry();
        YClient yClient = new YClient(registry, "demo-service", HelloService.class);

        HelloService helloService = (HelloService) yClient.getBean();

        String result = helloService.greeting("Rpc Man");

        System.out.println(result);

    }

}
