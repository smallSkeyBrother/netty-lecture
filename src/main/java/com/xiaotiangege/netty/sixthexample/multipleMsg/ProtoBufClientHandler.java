package com.xiaotiangege.netty.sixthexample.multipleMsg;

import com.xiaotiangege.serialize.protobuf.Human;
import com.xiaotiangege.serialize.protobuf.Users;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/27 14:03
 **/
public class ProtoBufClientHandler extends SimpleChannelInboundHandler<Human.People> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Human.People msg) throws Exception {
        System.out.println("客户端收到服务器端消息" + msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Random random = new Random();
        int i = random.nextInt(10);

        if (i % 2 == 0){
            Human.People msg = Human.People.newBuilder().setTypeValue(0)//
                    .setTeacher(Human.Teacher.newBuilder().setId(20).setName("hello world")).build();
            ctx.writeAndFlush(msg);
        }else {
            Human.People msg = Human.People.newBuilder().setTypeValue(1)//
                    .setStu(Human.Student.newBuilder().setId(15).setName("study hello world")).build();
            ctx.writeAndFlush(msg);
        }
    }
}
