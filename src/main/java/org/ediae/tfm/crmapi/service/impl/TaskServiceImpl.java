package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.repository.TaskRepository;
import org.ediae.tfm.crmapi.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findByStatus(Task.Status status) {
        return taskRepository.findByStatus(status);
    }
}
