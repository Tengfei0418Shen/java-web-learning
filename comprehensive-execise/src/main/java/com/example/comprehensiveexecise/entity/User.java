package com.example.comprehensiveexecise.entity;

public class User {
    // 主键
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
