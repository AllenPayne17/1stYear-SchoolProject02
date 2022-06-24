package com.Payne;

public class GetUser {
    private String username, email, phone;
    private int balance;

    public GetUser(int balance, String username, String email, String phone) {
        this.balance=balance;
        this.username=username;
        this.email=email;
        this.phone=phone;
    }
    public int getBalance(){
        return balance;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
}
