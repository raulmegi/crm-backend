package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    Task create(Task task);
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task update(Task task);
    void delete(Long id);
    List<Task> findByStatus(Task.Status status);
}
