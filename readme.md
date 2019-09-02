# 端口占用程序

### 背景
- 由于网络防火墙原因，需要测试每个端口是否能telnet通，如果正常测试每个端口，则需要部署多个程序对端口进行占用才能进行telnet，故开发这个程序。


使用方法
- 1.对程序进行打包，并拷贝到需要测试的机器上
- 2.在jar同级目录下建立serverConfig.properties文件
- 3.在serverConfig.properties里编辑port配置；配置用例如下<br>
``
port=8888;9999;10001
``
- 4.使用java -jar 对程序进行启动。
- 5.在本地机器对测试机器进行telnet测试。

- macos或者linux可以使用nmap进行批量扫描
> nmap -sT IP