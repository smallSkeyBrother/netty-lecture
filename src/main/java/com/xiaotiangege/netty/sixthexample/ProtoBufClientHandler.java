package com.xiaotiangege.netty.sixthexample;

import com.xiaotiangege.serialize.protobuf.Users;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/27 14:03
 **/
public class ProtoBufClientHandler extends SimpleChannelInboundHandler<Users.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Users.Person msg) throws Exception {
        System.out.println("客户端收到服务器端消息" + msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Users.Person msg = Users.Person.newBuilder().setAge(20).//
                setName("张三").setSex("male").build();
        ctx.writeAndFlush(msg);
    }
}
