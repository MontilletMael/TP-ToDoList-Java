package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/**
 * Entite volontairement generique.
 * Les eleves peuvent la garder telle quelle ou la renommer selon leur sujet.
 *
 * Exemples :
 * - Item -> Book
 * - Item -> Movie
 * - Item -> Expense
 * - Item -> Habit
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean done;

    private String priority;

    private Date created;

    public Task() {
    }

    public Task(String title, String description, boolean done, String priority, Date created) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.priority = priority;
        this.created = created;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }
}
