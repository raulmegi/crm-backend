package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.exception.GeneralException;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    Task create(Task task) throws GeneralException;
    List<Task> findAll() throws GeneralException;
    Task findById(Long id) throws GeneralException;
    Task update(Task task) throws GeneralException;
    Boolean delete(Long id) throws GeneralException;
    List<Task> findByStatus(Task.Status status) throws GeneralException;
    List<Task> findByUser(Optional<AppUser> user) throws GeneralException;
}
