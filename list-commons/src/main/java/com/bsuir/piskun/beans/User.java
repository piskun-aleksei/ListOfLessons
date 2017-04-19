package com.bsuir.piskun.beans;

public abstract class User {

    protected String username;
    protected String password;
    protected int permissionsLevel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissonsLevel() {
        return permissionsLevel;
    }

    public void setPermissonsLevel(int permissionsLevel) {
        this.permissionsLevel = permissionsLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (getPermissonsLevel() != user.getPermissonsLevel()) {
            return false;
        }
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null) {
            return false;
        }
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getPermissonsLevel();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissonsLevel=" + permissionsLevel +
                '}';
    }
}
