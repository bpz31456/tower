package com.cdhenren.fetch.group;

import com.cdhenren.fetch.entity.TaskWrap;

/**
 * @author Fuhj
 */
public final class SessionFactory {
    public static Session getInstance(TaskWrap taskWrap) {
        return new Session(new User(taskWrap.getSysTask().getUser(), taskWrap.getSysTask().getPwd()));
    }
}
