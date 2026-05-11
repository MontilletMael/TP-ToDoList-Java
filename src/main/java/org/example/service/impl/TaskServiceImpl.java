package org.example.service.impl;

import org.example.dto.TaskCreate;
import org.example.dto.TaskResponse;
import org.example.dto.TaskStatusRequest;
import org.example.dto.TaskUpdate;
import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.example.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Ici se trouve la logique metier.
 *
 * Le squelette ne laisse qu'un seul vrai exemple fonctionnel : findAll().
 * Le reste doit etre complete par les eleves.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Page<TaskResponse> findAll(Pageable pageable) {
        // Exemple complet :
        // on lit les donnees depuis le repository
        // puis on transforme les entites en DTO de sortie.
        return taskRepository.findAll(pageable)
                //.stream()
                .map(TaskResponse::fromEntity);
                //.toList(); // Ici le stream peut être remplacé par plein d'autre moyen. Il sagit juste d'une manière efficace et efficiente d'écrire cette partie.

        /* Autre manière de faire si le stream n'est pas familié
        List<ItemResponse> itemResponses = new ArrayList<>();
        List<Item> all = itemRepository.findAll();

        for (Item item : all) {
            ItemResponse itemResponse = new ItemResponse(item.getId(), item.getName(), item.getDescription(), item.isDone());
            itemResponses.add(itemResponse);
        }
        return itemResponses;
         */
    }

    @Override
    public TaskResponse findById(Long id) {
        // TODO eleves :
        // 1. lire l'item depuis le repository
        // 2. gerer le cas ou l'item n'existe pas
        // 3. renvoyer un ItemResponse
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            System.out.println("==== Task not found ====");
            return null;
        } else {
            System.out.println("==== Task found ====");
            return TaskResponse.fromEntity(task);
        }
    }

    @Override
    public TaskResponse create(TaskCreate request) {
        // TODO eleves :
        // 1. remplacer Object par un vrai DTO d'entree
        // 2. appliquer les regles metier
        // 3. creer l'entite
        // 4. sauvegarder avec le repository
        // 5. renvoyer un ItemResponse
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDone(request.isDone());
        task.setPriority(request.getPriority());
        task.setCreated(new Date());

        return TaskResponse.fromEntity(taskRepository.save(task));
    }

    @Override
    public TaskResponse update(Long id, TaskUpdate request) {
        // TODO eleves :
        // 1. remplacer Object par un vrai DTO d'entree
        // 2. retrouver l'item en base
        // 3. modifier les champs utiles
        // 4. sauvegarder
        // 5. renvoyer un ItemResponse
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            System.out.println("==== Task not found ====");
            return null;
        } else {
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setDone(request.isDone());
            task.setPriority(request.getPriority());

            return TaskResponse.fromEntity(taskRepository.save(task));
        }

    }

    @Override
    public void delete(Long id) {
        // TODO eleves :
        // 1. retrouver l'item
        // 2. le supprimer
        // 3. reflechir au comportement si l'id n'existe pas

        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            System.out.println("==== Task not found ====");
        } else {
            taskRepository.delete(task);
        }
    }

    @Override
    public TaskResponse taskIsDone(Long id){
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            System.out.println("==== Task not found ====");
            return null;
        } else {
            if(task.isDone()){
                task.setDone(false);
            } else {
                task.setDone(true);
            }
            return TaskResponse.fromEntity(taskRepository.save(task));
        }
    }
}
