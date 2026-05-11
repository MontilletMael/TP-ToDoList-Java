package org.example.dto;

import java.util.Date;

public class TaskCreate {

    private String title;
    private String description;
    private boolean done;
    private String priority;
    private Date created;

    public TaskCreate() {
    }

    public TaskCreate(String title, String description, boolean done, String priority, Date created) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.priority = priority;
        this.created = created;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean isDone() {
        return done;
    }
    public String getPriority() { return priority; }
    public Date getCreated() { return created; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { this.done = done; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setCreated(Date created) { this.created = created; }

}
