package com.xiaotiangege.netty.webcontainer.net;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class WebHttpServerDispatcher extends SimpleChannelInboundHandler<HttpObject> {

    public WebHttpServerDispatcher() {
        System.out.println("TestHttpServerHandler created ...");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest){
            HttpRequest request = (HttpRequest)msg;
            String uri = request.uri();

            int firstbackslash = uri.indexOf("/");
            if (firstbackslash == 0){
                uri = uri.substring(1, uri.length());
                System.out.println(uri);
            }

            System.out.println("request method : " + request.method().name());
            System.out.println("request uri : " + uri);

            ByteBuf content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);

            if ("favicon.ico".equals(uri)){
                content = Unpooled.copiedBuffer("", CharsetUtil.UTF_8);
            }

            if ("index".equals(uri)){
                content = Unpooled.copiedBuffer(JSON.toJSONString("欢迎来到netty服务"), Charset.forName("gbk"));
            }

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("public void channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("public void channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("public void channelRead");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("public void channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("public void channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("public void channelUnregistered");
        super.channelUnregistered(ctx);
    }
}
