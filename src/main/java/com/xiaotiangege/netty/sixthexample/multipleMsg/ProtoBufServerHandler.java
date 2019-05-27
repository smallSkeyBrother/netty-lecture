package com.xiaotiangege.netty.sixthexample.multipleMsg;

import com.xiaotiangege.serialize.protobuf.Human;
import com.xiaotiangege.serialize.protobuf.Users;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/5/27 14:03
 **/
public class ProtoBufServerHandler extends SimpleChannelInboundHandler<Human.People> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Human.People msg) throws Exception {
        Human.People.DataType dataType = msg.getType();
        switch (dataType.getNumber()){
            case 0:
                System.out.println("收到客户端消息：职位Teacher," + msg.getTeacher().toString());
                break;
            case 1: System.out.println("收到客户端消息：职位Student," + msg.getStu().toString());
                break;
        }
    }
}
