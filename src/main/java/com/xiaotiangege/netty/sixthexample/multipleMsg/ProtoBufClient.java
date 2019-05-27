package com.xiaotiangege.netty.sixthexample.multipleMsg;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/27 14:00
 **/
public class ProtoBufClient {

    public static void main(String[] args) throws Exception{
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker).channel(NioSocketChannel.class).handler(new ProtoBufClientInitializer());

            ChannelFuture future = bootstrap.connect("localhost", 9999).sync();
            future.channel().closeFuture().sync();
        }finally {
            worker.shutdownGracefully();
        }
    }
}
