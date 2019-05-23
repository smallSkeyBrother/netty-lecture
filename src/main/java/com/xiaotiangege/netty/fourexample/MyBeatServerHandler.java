package com.xiaotiangege.netty.fourexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MyBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleState idleState = ((IdleStateEvent) evt).state();
            switch (idleState){
                case READER_IDLE:
                    System.out.println("读中断");
                    break;
                case WRITER_IDLE:
                    System.out.println("写中断");
                    break;
                case ALL_IDLE:
                    System.out.println("读写中断");
                    break;
            }
        }
    }
}
