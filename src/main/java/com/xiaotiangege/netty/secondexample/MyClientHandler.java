package com.xiaotiangege.netty.secondexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/22 11:11
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("receive server msg : " + msg);
        ByteBuf send = Unpooled.copiedBuffer(LocalDateTime.now().toString(), CharsetUtil.UTF_8);
        ctx.writeAndFlush(send);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf send = Unpooled.copiedBuffer("client connection", CharsetUtil.UTF_8);
        ctx.writeAndFlush(send);
    }
}
