package com.xiaotiangege.netty.fifthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //websocket处理器
 * @Date 2019/5/24 10:17
 **/
public class MyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("接收到客户端消息：" + msg.text());
        ctx.writeAndFlush(new TextWebSocketFrame("服务端接收到消息：" + LocalDateTime.now().toString() + " " + msg.text()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端创建链接");
        TextWebSocketFrame tw = new TextWebSocketFrame("服务器连接建立");
        ctx.writeAndFlush(tw);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开链接");
        TextWebSocketFrame tw = new TextWebSocketFrame("服务器连接断开");
        ctx.writeAndFlush(tw);
    }
}
