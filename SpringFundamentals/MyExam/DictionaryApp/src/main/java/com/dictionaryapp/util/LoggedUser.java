package com.dictionaryapp.util;

import com.dictionaryapp.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {
    private long id = 0;

    private String username;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void logout() {
        this.id = 0;
        this.username = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
