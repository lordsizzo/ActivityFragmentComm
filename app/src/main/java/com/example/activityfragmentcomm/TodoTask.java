package com.example.activityfragmentcomm;

public class TodoTask {

    private String todoName;
    private String todoCategory;

    public TodoTask(String todo, String category) {
    }

    public TodoTask() {

    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoCategory() {
        return todoCategory;
    }

    public void setTodoCategory(String todoCategory) {
        this.todoCategory = todoCategory;
    }

}
