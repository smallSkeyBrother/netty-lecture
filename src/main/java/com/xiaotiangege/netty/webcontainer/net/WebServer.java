package com.xiaotiangege.netty.webcontainer.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 1. 代码分析：　
    bossGroup，workerGroup是两个基于死循环的事件组。
    bossGroup，用来监听绑定的端口和接收客户端请求，然后交给workerGroup对SocketChannel进行处理，具体的业务逻辑处理，
            会交个具体的系统线程进行处理，处理结果返回。
    ServerBootstrap，的作用是启动服务，并让bossGroup对绑定端口进行监听。
    TestServerInitializer，在服务启动时进行创建，整个服务运行期间只一个实例。
    Handler，在TestServerInitializer中添加的处理类，每个请求过来会重新对应的所有的handler，来处理对应的业务逻辑。
 */
public class WebServer {

    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();//事件循环组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)//
             .childHandler(new WebServerInitializer());

            ChannelFuture channelFuture = b.bind(8081).sync();
            System.out.println("server start ...");
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}