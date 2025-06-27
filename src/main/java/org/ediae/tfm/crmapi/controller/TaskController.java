package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.entity.Task;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.service.ITaskService;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final ITaskService taskService;
    private final iAppUserService appUserService;
    public TaskController(ITaskService taskService, iAppUserService appUserService) {
        this.taskService = taskService;
        this.appUserService = appUserService;
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

    @GetMapping("/usuario/{userId}")
    public ModelMap findByUser(@PathVariable Long userId) {
        try {
            AppUser user = appUserService
                    .findAppUserById(userId)                     // tu método
                    .orElseThrow(() -> new GeneralException(
                            GeneralConstants.APPUSER_NOT_FOUND_CODE,
                            GeneralConstants.APPUSER_NOT_FOUND_MESSAGE));

            // 2) Busca las tareas de ese usuario
            List<Task> tareas = taskService.findByUser(Optional.ofNullable(user));

            // 3) Devuelve OK con la lista en data
            return GeneralUtilsController.crearRespuestaModelMapOk(tareas);

        } catch (GeneralException ge) {
            // Si el usuario no existe o falla tu excepción controlada
            return GeneralUtilsController.crearRespuestaModelMapError(ge);
        } catch (Exception ex) {
            // Cualquier otro error
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }
}



