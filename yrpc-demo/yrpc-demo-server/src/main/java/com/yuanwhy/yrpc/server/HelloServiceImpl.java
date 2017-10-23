package com.yuanwhy.yrpc.server;

import com.yuanwhy.yrpc.demo.api.HelloService;

/**
 * Created by hongyuan.wang on 23/10/2017.
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String greeting(String name) {

        return "Hello, " + name;

    }
}
