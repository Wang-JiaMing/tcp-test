package com.tcp.server;

import com.expansion.readProperties.PropertiesUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @projectName:tcp-test
 * @packageName:com.tcp.server
 * @authorName:wangjiaming
 * @createDate:2019-05-23
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class MainServer {

    public String getPath(){
        try {
            return java.net.URLDecoder.decode(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] port=null;
        String path=new MainServer().getPath();
        if(System.getProperty("os.name").indexOf("Mac")==-1){
            String[] pathsz= path.substring(1).split("/");
            StringBuffer tmp=new StringBuffer();
            for(int sz=0;sz<pathsz.length-1;sz++){
                tmp.append(pathsz[sz]+"/");
            }
            path=tmp.toString();
        }

        System.out.println("**************程序配置预览****************");
        System.out.println("\n作者:王嘉明\n");
        System.out.println("配置文件路径："+path+"serverConfig.properties");
        System.out.println("程序将在60分钟后自行关闭");
        if(path!=null){
            port= PropertiesUtils.getPropertiesByPath(path+"serverConfig.properties", "port").split(";");
        }else{
            port= PropertiesUtils.getProperties("serverConfig", "port").split(";");
        }
        try {
            for (int i = 0; i < port.length; i++) {
                Thread thread = new TcpServer(Integer.valueOf(port[i]));
                thread.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序启动完成");
        System.out.println("****************************************");

        try {
            TimeUnit.MINUTES.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }


}
