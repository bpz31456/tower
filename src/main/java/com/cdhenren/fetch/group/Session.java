package com.cdhenren.fetch.group;

import com.cdhenren.fetch.entity.TaskWrap;

/**
 * 每个账号为一个Session
 *
 * @author Fuhj
 * @date 2019.09.21
 * version 3.0.0
 */
public class Session {
    private boolean login = false;
    private User user;
    private Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    /**
     * 判读是否为同一个Session
     *
     * @return
     */
    public boolean isTheSame(TaskWrap taskWrap) {
        return user != null && user.equals(new User(taskWrap.getSysTask().getUser(), taskWrap.getSysTask().getPwd()));
    }

    /**
     * 判断当前Session是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * 登录
     */
    public void login() {
        login = true;
    }

    /**
     * 注销
     */
    public void loginOut() {
        region = null;
        login = false;
    }

}
