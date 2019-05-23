package com.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @projectName:tcp-test
 * @packageName:com.tcp.server
 * @authorName:wangjiaming
 * @createDate:2019-05-23
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class TcpServer extends Thread{


    public TcpServer(Integer port) throws IOException {
        ServerSocket sk = new ServerSocket(port);
        System.out.println("线程占用"+port+"端口成功");
    }
}
