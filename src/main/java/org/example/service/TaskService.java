package org.example.service;

import org.example.dto.TaskCreate;
import org.example.dto.TaskResponse;
import org.example.dto.TaskStatusRequest;
import org.example.dto.TaskUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Contrat du service metier.
 * Une seule methode est vraiment implementee dans le squelette.
 * Les autres servent de guide pour le TD / TP.
 */
public interface TaskService {

    Page findAll(Pageable pageable);

    TaskResponse findById(Long id);

    TaskResponse create(TaskCreate request);

    TaskResponse update(Long id, TaskUpdate request);

    void delete(Long id);

    TaskResponse updateStatus(Long id, TaskStatusRequest request);
}
