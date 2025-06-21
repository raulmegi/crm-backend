package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.exception.GeneralException;

import java.util.List;
import java.util.Optional;

public interface iAppUserService {
    AppUser createAppUser(AppUser appUser) throws GeneralException;
    List<AppUser> findAllAppUsers() throws GeneralException;
    Optional<AppUser> findAppUserById(Long id) throws GeneralException;
    AppUser updateAppUser (AppUser appUser) throws GeneralException;
    void deleteAppUserById(Long id) throws GeneralException;
    AppUser findAppUserByEmail(String email) throws GeneralException;
    public AppUser login(String email, String password) throws GeneralException;
    List<AppUser> findAppUserByName(String name) throws GeneralException;
}