package com.yuanwhy.mage.server;

import com.yuanwhy.mage.demo.api.HelloService;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String greeting(String name) {

        return "Hello, " + name;

    }
}
