package com.god.bo.domain;

public class Post {
    private String title;
    private String contents;
    private String create;
    private String date;
    private Object comments;
    private Object categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
