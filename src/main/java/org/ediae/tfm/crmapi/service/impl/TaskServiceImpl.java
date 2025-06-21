package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.exception.GeneralException;
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

    public Task create(Task task) throws GeneralException {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_CREATION_ERROR_CODE,
                    GeneralConstants.TASK_CREATION_ERROR_MESSAGE);
        }
    }

    public List<Task> findAll() throws GeneralException{
        try {
            return taskRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE
            );
        }
    }

    public Task findById(Long id) throws GeneralException{
        try {
            Optional<Task> optionalTask= taskRepository.findById(id);
            if(optionalTask.isPresent()) {
                return optionalTask.get();
            } else {
                throw new GeneralException(GeneralConstants.TASK_NOT_FOUND_CODE, GeneralConstants.TASK_NOT_FOUND_MESSAGE);
            }
        } catch (GeneralException genEx) {
            throw genEx;
        } catch (Exception ex) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }

    }

    public Task update(Task task) throws GeneralException {
        if (task.getId() == null || !taskRepository.existsById(task.getId())) {
            throw new GeneralException(
                    GeneralConstants.TASK_NOT_FOUND_CODE,
                    GeneralConstants.TASK_NOT_FOUND_MESSAGE
            );
        }

        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_UPDATE_ERROR_CODE,
                    GeneralConstants.TASK_UPDATE_ERROR_MESSAGE
            );
        }

    }

    public Boolean delete(Long id) throws GeneralException {
        if (!taskRepository.existsById(id)) {
            throw new GeneralException(
                    GeneralConstants.TASK_NOT_FOUND_CODE,
                    GeneralConstants.TASK_NOT_FOUND_MESSAGE
            );
        }

        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_DELETE_ERROR_CODE,
                    GeneralConstants.TASK_DELETE_ERROR_MESSAGE
            );
        }
    }

    public List<Task> findByStatus(Task.Status status) throws GeneralException {
        try {
            return taskRepository.findByStatus(status);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.TASK_STATUS_INVALID_CODE,
                    GeneralConstants.TASK_STATUS_INVALID_MESSAGE
            );
        }
    }
}
