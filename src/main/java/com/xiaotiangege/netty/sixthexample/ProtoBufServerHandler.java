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
public class ProtoBufServerHandler extends SimpleChannelInboundHandler<Users.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Users.Person msg) throws Exception {
        System.out.println("收到客户端消息：" + msg.toString());

        Users.Person sendMsg = Users.Person.newBuilder().setAge(msg.getAge()).//
                setName("changeNameServer").setSex(msg.getSex()).build();
        ctx.writeAndFlush(sendMsg);
    }
}
