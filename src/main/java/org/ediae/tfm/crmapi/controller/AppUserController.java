package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.dto.LoginRequest;
import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.AppUserRepository;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUser")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    @Autowired
    private iAppUserService appUserService;

    @PostMapping("/crearAppUser")
    public ModelMap createAppUser(@RequestBody AppUser appUser) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.createAppUser(appUser));
        } catch (GeneralException genEx) {
            return GeneralUtilsController.crearRespuestaModelMapError(genEx);
        }
    }

    @GetMapping("/obtenerTodosAppUser")
    public ModelMap getAllAppUsers() {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.findAllAppUsers());
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/obtenerAppUserById/{id}")
    public ModelMap getAppUserById(@PathVariable Long id) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.findAppUserById(id));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/obtenerAppUserByEmail/{email}")
    public ModelMap getAppUserByEmail(@PathVariable String email) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.findAppUserByEmail(email));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @GetMapping("/obtenerAppUserByName")
    public ModelMap getAppUserByName(@RequestParam String name) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.findAppUserByName(name));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @PutMapping("/actualizarAppUser/{id}")  //PETA SI NO ACTUALIZAS ALGO
    public ModelMap updateClient(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUser.setId(id);
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.updateAppUser(appUser));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    // @PutMapping("/cambiarContrasena") -algo más complicado por lo visto

    @DeleteMapping("eliminarAppUser/{id}")
    public ModelMap deleteAppUserById(@PathVariable Long id) {
        try {
            return GeneralUtilsController.crearRespuestaModelMapOk(appUserService.deleteAppUserById(id));
        } catch (Exception ex) {
            return GeneralUtilsController.crearRespuestaModelMapError(ex);
        }
    }

    @PostMapping("/login")
    public ModelMap login(@RequestBody LoginRequest loginRequest) {
        try {
            AppUser appUser = appUserService.login(loginRequest.getEmail(), loginRequest.getPassword());
            ModelMap modelMap = GeneralUtilsController.crearRespuestaModelMapOk(appUser);
            modelMap.put("loginMessage", "User ID " + appUser.getId() + " has logged in successfully");
            return modelMap;
        } catch(GeneralException genEx){
            return GeneralUtilsController.crearRespuestaModelMapError(genEx);
        }
    }
}