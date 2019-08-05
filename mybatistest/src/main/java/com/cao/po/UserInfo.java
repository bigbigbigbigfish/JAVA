package com.cao.po;

public class UserInfo {
    private int userId;
    private String userNmae;

    private UserInfo() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userNmae='" + userNmae + '\'' +
                '}';
    }
}
