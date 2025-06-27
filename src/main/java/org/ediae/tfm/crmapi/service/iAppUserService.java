package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.exception.GeneralException;

import java.util.List;
import java.util.Optional;

public interface iAppUserService {
    AppUser createAppUser(AppUser appUser) throws GeneralException;
    AppUser registerAppUser(AppUser appUser) throws GeneralException;
    List<AppUser> findAllAppUsers() throws GeneralException;
    Optional<AppUser> findAppUserById(Long id) throws GeneralException;
    AppUser updateAppUser (AppUser appUser) throws GeneralException;
    boolean deleteAppUserById(Long id) throws GeneralException;
    AppUser findAppUserByEmail(String email) throws GeneralException;
    AppUser login(String email, String password) throws GeneralException;
    List<AppUser> findAppUserByName(String name) throws GeneralException;
}