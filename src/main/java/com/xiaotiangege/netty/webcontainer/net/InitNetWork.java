package com.xiaotiangege.netty.webcontainer.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Objects;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //初始化网络
 * @Date 2019/7/22 9:57
 **/
public class InitNetWork {

    private int port = 80;

    private ChannelFuture channelFuture = null;

    /**
     * 启动网络监听
     *
     * @throws Exception
     */
    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();//事件循环组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)//
                    .channel(NioServerSocketChannel.class)//
                    .childHandler(new WebServerInitializer());

            ChannelFuture channelFuture = b.bind(port).sync();
            System.out.println("server start ...");
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * 关闭服务器
     */
    public void close() {
        if (Objects.nonNull(channelFuture)) {
            channelFuture.channel().closeFuture();
        }
    }
}
