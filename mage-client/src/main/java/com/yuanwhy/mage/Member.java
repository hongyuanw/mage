package com.yuanwhy.mage;

/**
 * Created by hongyuan.wang on 30/10/2017.
 */
public class Member {

    private String ip;

    private int port;

    public Member(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
