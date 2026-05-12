package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.TaskCreate;
import org.example.dto.TaskResponse;
import org.example.dto.TaskStatusRequest;
import org.example.dto.TaskUpdate;
import org.example.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller parle HTTP.
 * Il ne doit pas contenir la logique metier.
 *
 * Le seul endpoint complet du squelette est GET /items.
 */
@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(taskService.findAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable("id") Long id) {
        // TODO eleves :
        // appeler le service et choisir la bonne reponse HTTP.
        // return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        TaskResponse task = taskService.findById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskCreate request) {
        // TODO eleves :
        // 1. remplacer Object par un vrai DTO d'entree
        // 2. appeler le service
        // 3. renvoyer 201 Created
        // return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        TaskResponse createdTask = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@Valid @PathVariable("id") Long id, @RequestBody TaskUpdate request) {
        // TODO eleves :
        // 1. remplacer Object par un vrai DTO d'entree
        // 2. appeler le service
        // 3. renvoyer la bonne reponse HTTP
        // return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        TaskResponse updateTask = taskService.update(id, request);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        // TODO eleves :
        // appeler le service puis choisir la bonne reponse HTTP.
        // return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();

        TaskResponse task = taskService.findById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        taskService.delete(id);
        System.out.println("==== Task has been deleted ====");
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateStatus(@Valid @PathVariable("id") Long id, @RequestBody TaskStatusRequest request) {
        TaskResponse task = taskService.findById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.updateStatus(id, request));
        }
    }
}
