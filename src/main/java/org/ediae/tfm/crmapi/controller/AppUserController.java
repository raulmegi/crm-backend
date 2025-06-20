package org.ediae.tfm.crmapi.controller;

import org.ediae.tfm.crmapi.dto.LoginRequest;
import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.repository.AppUserRepository;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.ediae.tfm.crmapi.service.impl.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private iAppUserService appUserService;
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/crearAppUser")
    public ResponseEntity<AppUser> createAppUser(@RequestBody AppUser appUser) {
        if (appUserRepository.findAppUserByEmail(appUser.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
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

    @GetMapping("/obtenerAppUserPorEmail/{email}")
    public ResponseEntity<Optional<AppUser>> findAppUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(appUserService.findAppUserByEmail(email));
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
    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody LoginRequest loginRequest) {
        AppUser appUser = appUserService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok()
                .header("X-Login-Confirmation" ,"User ID "+appUser.getId() +" has logged in successfully")  // ✅ Adds a test-friendly message
                .body(appUser);
    }

}
