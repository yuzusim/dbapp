package com.matacoding.myhttp;

public class Todo {
    // 통신으로 받은 JSON 데이터에 파싱하려고
    //
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {}

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
