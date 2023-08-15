package com.atguigu.admin.bean;

public class Account {

    private Long id;
    private String userId;
    private Integer money;

    public Account() {
    }

    public Account(Long id, String user_id, Integer money) {
        this.id = id;
        this.userId = user_id;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user_id) {
        this.userId = user_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_id='" + userId + '\'' +
                ", money=" + money +
                '}';
    }
}
