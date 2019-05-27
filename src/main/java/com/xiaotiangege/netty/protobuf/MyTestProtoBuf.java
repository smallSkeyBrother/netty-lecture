package com.xiaotiangege.netty.protobuf;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description 测试protobuf的编解码功能
 * @Date 2019/5/27 11:15
 **/
public class MyTestProtoBuf {

    public static void main(String[] args) throws Exception{
        Users.Person person = Users.Person.newBuilder().setAge(20).setName("张三").setSex("male").build();

        byte[] personByte = person.toByteArray();

        Users.Person outer = Users.Person.parseFrom(personByte);
        //System.out.println(outer.toString());
        System.out.println(outer.getName());
        System.out.println(outer.getAge());
        System.out.println(outer.getSex());
    }
}
