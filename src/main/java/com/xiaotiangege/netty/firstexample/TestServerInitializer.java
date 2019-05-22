package com.xiaotiangege.netty.firstexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    public TestServerInitializer() {
        System.out.println("TestServerInitializer create ...");
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //A combination of {@link HttpRequestDecoder} and {@link HttpResponseEncoder}
        //HttpServerCodec相当HttpRequestDecoder和HttpResponseEncoder功能的组合
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
