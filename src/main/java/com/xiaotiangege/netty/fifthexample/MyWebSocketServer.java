package com.xiaotiangege.netty.fifthexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //websocket客户端
 * @Date 2019/5/24 10:05
 **/
public class MyWebSocketServer {

    public static void main(String[] args) throws Exception{
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,worker).handler(new LoggingHandler()).channel(NioServerSocketChannel.class)//
                .childHandler(new MyWebSocketServerInitializer());

            ChannelFuture future = bootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
