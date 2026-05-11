package org.example.service;

import org.example.dto.TaskResponse;
import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.example.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Exemple de test unitaire simple sur la couche service.
 *
 * TODO eleves :
 * - ajoutez des tests sur findById
 * - ajoutez des tests sur update
 * - ajoutez des tests sur delete
 * - ajoutez des tests sur create
 * - ajoutez des tests sur les cas d'erreur
 */
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void findAll_shouldReturnMappedResponses() {
        Date date = new Date();
        Task firstTask = new Task("Premier Task", "Description de test", false, "Check", date);
        firstTask.setId(1L);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Task> taskPage = new PageImpl<>(List.of(firstTask), pageable, 1);

        when(taskRepository.findAll(any(Pageable.class))).thenReturn(taskPage);
        Page<TaskResponse> response = taskService.findAll(pageable);

        assertEquals(1, response.getContent().size());
        assertEquals(1L, response.getContent().getFirst().getId());
        assertEquals("Premier Task", response.getContent().getFirst().getTitle());
        assertEquals("Description de test", response.getContent().getFirst().getDescription());
        assertFalse(response.getContent().getFirst().isDone());
        assertEquals("Check", response.getContent().getFirst().getPriority());
        assertEquals(date, response.getContent().getFirst().getCreated());
    }

    @Test
    void findById_shouldReturnMappedResponses() {
        Date date = new Date();
        Task firtsTask = new Task("Premier Task", "Description de test", false, "Check", date);
        firtsTask.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(firtsTask));

        assertEquals(1, taskService.findById(1L).getId());
        assertEquals("Premier Task", taskService.findById(1L).getTitle());
        assertEquals("Description de test", taskService.findById(1L).getDescription());
        assertFalse(taskService.findById(1L).isDone());
        assertEquals("Check", taskService.findById(1L).getPriority());
        assertEquals(date, taskService.findById(1L).getCreated());
    }
}
