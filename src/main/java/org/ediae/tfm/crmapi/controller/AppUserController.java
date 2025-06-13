package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appUser")
public class AppUserController {

    @Autowired
    private iAppUserService appUserService;

    @PostMapping("/crearAppUser")
    public ResponseEntity<AppUser> createAppUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.createAppUser(appUser));
    }

    @GetMapping("/obtenerTodosAppUser")
    public ResponseEntity<List<AppUser>> getAllAppUsers(){
        return ResponseEntity.ok(appUserService.findAllAppUsers());
    }

    @GetMapping("/obtenerAppUserById/{id}")
    public ResponseEntity<Optional<AppUser>> findAppUserById(@PathVariable Long id){
        return ResponseEntity.ok(appUserService.findAppUserById(id));
    }

    @PutMapping("/actualizarAppUser/{id}")  //PETA SI NO ACTUALIZAS ALGO
    public ResponseEntity<AppUser> updateClient(@PathVariable Long id, @RequestBody AppUser appUser){
        appUser.setId(id);
        return ResponseEntity.ok(appUserService.updateAppUser(appUser));
    }

    // @PutMapping("/cambiarContrasena") -algo más complicado por lo visto

    @DeleteMapping("eliminarAppUser/{id}")
    public ResponseEntity<Void> deleteAppUserById(@PathVariable Long id) {
        appUserService.deleteAppUserById(id);
        return ResponseEntity.noContent().build();
    }
}
