package com.wule.pojo;

//创建于2022/6/20 9:52
public class User
{
    String userNum;//用户号
    String userName;//用户名
    String userPassword;//用户密码
    String userPower;//用户权限
    int userIntegration;//用户积分


    public User() {
    }

    public User(String userNum, String userName,String userPassword, String userPower, int userIntegration) {
        this.userNum = userNum;
        this.userName = userName;
        this.userPassword=userPassword;
        this.userPower = userPower;
        this.userIntegration = userIntegration;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }

    public int getUserIntegration() {
        return userIntegration;
    }

    public void setUserIntegration(int userIntegration) {
        this.userIntegration = userIntegration;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNum='" + userNum + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIntegration='" + userIntegration + '\'' +
                '}';
    }
}
