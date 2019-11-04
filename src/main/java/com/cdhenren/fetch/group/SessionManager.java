package com.cdhenren.fetch.group;

import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Session管理器，贯穿执行任务
 *
 * @author Fuhj
 * version 3.0.0
 */
public final class SessionManager {
    private static ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap<>(1 << 4);
    private static ConcurrentHashMap<String, WebDriver> drivers = new ConcurrentHashMap<>(1 << 4);

    public static synchronized void addSession(Session session) {
        sessions.put(session.getUser().getUser(), session);
    }

    public static synchronized void addDriver(Session session,WebDriver driver) {
        drivers.put(session.getUser().getUser(), driver);
    }


    public static synchronized WebDriver getDriver(Session session) {
        return drivers.get(session.getUser().getUser());
    }

    public static synchronized Session getSession(String key) {
        return sessions.get(key);
    }

    public static synchronized Set<String> getKeys() {
        return sessions.keySet();
    }

    public static synchronized void removeSessin(String user) {
        sessions.remove(user);
    }
}
