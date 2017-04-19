package com.bsuir.piskun.beans;

public class Teacher extends User {
    public Teacher() {
        this.permissionsLevel = 2;
    }

    public Teacher(String username) {
        this.username = username;
        this.permissionsLevel = 2;
    }

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissionsLevel = 2;
    }
}
