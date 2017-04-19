package com.bsuir.piskun.beans;

public class Student extends User {
    public Student() {
        this.permissionsLevel = 1;
    }

    public Student(String username) {
        this.username = username;
        this.permissionsLevel = 1;
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissionsLevel = 1;
    }
}
