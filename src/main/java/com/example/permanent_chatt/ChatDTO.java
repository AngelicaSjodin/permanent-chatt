package com.example.permanent_chatt;

import java.util.List;

public class ChatDTO {
    private Long id;

    private String text;

    //get set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

