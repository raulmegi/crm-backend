package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.service.ITaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/crearTarea")
    public ModelMap crearTarea(@RequestBody Task task) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.create(task));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/listarTareas")
    public ModelMap getAll() {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.findAll());
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/encontrarPorId/{id}")
    public ModelMap getById(@PathVariable Long id) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.findById(id));
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @PutMapping("/actualizarTarea")
    public ModelMap update( @RequestBody Task task) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.update(task));
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @DeleteMapping("eliminarTarea/{id}")
    public ModelMap delete(@PathVariable Long id) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.delete(id));
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/estado/{status}")
    public ModelMap getByStatus(@PathVariable Task.Status status) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(taskService.findByStatus(status));
        }catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }


}
