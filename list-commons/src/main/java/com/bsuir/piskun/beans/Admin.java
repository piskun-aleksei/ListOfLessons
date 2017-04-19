package com.bsuir.piskun.beans;

public class Admin extends User{
    public Admin() {
        this.permissionsLevel = 5;
    }

    public Admin(String username) {
        this.username = username;
        this.permissionsLevel = 5;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissionsLevel = 5;
    }
}
