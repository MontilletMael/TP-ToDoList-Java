package org.example.dto;

import org.example.entity.Task;

import java.util.Date;

/**
 * DTO de sortie.
 * Permet de controler ce que l'API renvoie.
 */
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean done;
    private String priority;
    private Date created;

    public TaskResponse() {
    }

    public TaskResponse(Long id, String title, String description, boolean done, String priority, Date created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.priority = priority;
        this.created = created;
    }

    public static TaskResponse fromEntity(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isDone(),
                task.getPriority(),
                task.getCreated()
        );
    }

    public Long getId() {
        return id;
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
}
