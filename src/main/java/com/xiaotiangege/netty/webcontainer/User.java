package com.xiaotiangege.netty.webcontainer;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //测试bean
 * @Date 2019/7/22 15:28
 **/
public class User {

    public User(String userName, String email, String address, int age, Byte sex) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    private String userName;

    private String email;

    private String address;

    private int age;

    private Byte sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}
