package ua.sapipa.dao;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class Student {
    private int id;
    private final Chat chat;
    private final User user;
    private String name;
    private String group;

    public Student(Chat chat, User user) {
        this.chat = chat;
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
