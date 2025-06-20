package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface iAppUserService {
    AppUser createAppUser(AppUser appUser);
    List<AppUser> findAllAppUsers();
    Optional<AppUser> findAppUserById(Long id);
    AppUser updateAppUser (AppUser appUser);
    void deleteAppUserById(Long id);
    Optional<AppUser> findAppUserByEmail(String email);
    public AppUser login(String email, String password);
}