package com.xiaotiangege.netty.webcontainer.net;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class WebServerInitializer extends ChannelInitializer<SocketChannel> {
    public WebServerInitializer() {
        System.out.println("TestServerInitializer create ...");
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        /**
         *  A combination of {@link HttpRequestDecoder} and {@link HttpResponseEncoder}
         *
         *  HttpServerCodec相当HttpRequestDecoder和HttpResponseEncoder功能的组合
         */
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler", new WebHttpServerDispatcher());
    }
}
