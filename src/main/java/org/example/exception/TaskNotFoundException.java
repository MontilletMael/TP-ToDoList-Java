package org.example.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("La tâche avec l'id " + id + " n'existe pas");
    }
}