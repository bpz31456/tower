package com.cdhenren.fetch.group;

import java.util.Objects;

/**
 * 每个Session对应一个User
 * @author Fuhj
 * version 3.0.0
 */
public class User {
    private String user;
    private String pwd;

    public User(String user,String pwd){
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user1 = (User) o;
        return Objects.equals(user, user1.user) &&
                Objects.equals(pwd, user1.pwd);
    }


    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, pwd);
    }
}
