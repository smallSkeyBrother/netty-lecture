package com.xiaotiangege.netty.secondexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/22 10:45
 **/
public class MyServer {

    public static void main(String[] args) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap s = new ServerBootstrap();
            s.group(boss, worker).channel(NioServerSocketChannel.class)//
                    .childHandler(new MyServerInitializer());

            ChannelFuture future = s.bind(8989).sync();
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
