package org.example.dto;

import java.util.Date;

public class TaskUpdate {
    private Long id;
    private String title;
    private String description;
    private boolean done;
    private String priority;
    private Date created;

    public TaskUpdate() {
    }

    public TaskUpdate(Long id, String title, String description, boolean done,  String priority, Date created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.priority = priority;
        this.created = created;
    }

    public Long getId() { return id; }
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

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { this.done = done; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setCreated(Date created) { this.created = created; }

}
