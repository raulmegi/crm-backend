package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.constant.GeneralConstants;
import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.exception.GeneralException;
import org.ediae.tfm.crmapi.repository.AppUserRepository;
import org.ediae.tfm.crmapi.service.iAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements iAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser createAppUser(AppUser appUser) throws GeneralException {
        try{
            return appUserRepository.save(appUser);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.APPUSER_CREATION_ERROR_CODE,
                    GeneralConstants.APPUSER_CREATION_ERROR_MESSAGE);
        }
    }

    @Override
    public List<AppUser> findAllAppUsers() throws GeneralException {
        try{
            return appUserRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    @Override
    public Optional<AppUser> findAppUserById(Long id) throws GeneralException {
        try{
            return appUserRepository.findById(id);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.APPUSER_NOT_FOUND_CODE,
                    GeneralConstants.APPUSER_NOT_FOUND_MESSAGE);
        }
    }
    @Override
    public AppUser findAppUserByEmail(String email) throws GeneralException {
        try {
            Optional<AppUser> optionalAppUser = appUserRepository.findAppUserByEmail(email);
             if(optionalAppUser.isPresent()) {
                return optionalAppUser.get();
             } else {
                throw new GeneralException(
                    GeneralConstants.APPUSER_EMAIL_NOT_FOUND_CODE,
                    GeneralConstants.APPUSER_EMAIL_NOT_FOUND_MESSAGE);
            }
        } catch (GeneralException genEx) {
            throw genEx;
        } catch (Exception ex) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    @Override
    public List<AppUser> findAppUserByName(String name) throws GeneralException {
        try{
            List<AppUser> appUsers = appUserRepository.findByNameContainingIgnoreCase(name);
            if(!appUsers.isEmpty()) {
                return appUsers;
        } else {
                throw new GeneralException(
                    GeneralConstants.APPUSER_NAME_SEARCH_ERROR_CODE,
                    GeneralConstants.APPUSER_NAME_SEARCH_ERROR_MESSAGE);
        }
        } catch (GeneralException genEx) {
            throw genEx;
        } catch (Exception ex) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) throws GeneralException {
        try {
            return appUserRepository.save(appUser);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.APPUSER_UPDATE_ERROR_CODE,
                    GeneralConstants.APPUSER_UPDATE_ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteAppUserById(Long id) throws GeneralException {
        try{
        appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.APPUSER_DELETE_ERROR_CODE,
                    GeneralConstants.APPUSER_DELETE_ERROR_MESSAGE);
        }
    }

    @Override
    public AppUser login(String email, String password) throws GeneralException {
        try { Optional<AppUser> optionalAppUser = appUserRepository.findAppUserByEmail(email);
            if (optionalAppUser.isEmpty()) {
                throw new GeneralException(
                        GeneralConstants.APPUSER_LOGIN_ERROR_CODE,
                        GeneralConstants.APPUSER_LOGIN_ERROR_MESSAGE);
            }
            AppUser appUser = optionalAppUser.get();
            if (!appUser.getPassword().equals(password)) {
                throw new GeneralException(
                        GeneralConstants.APPUSER_LOGIN_ERROR_CODE,
                        GeneralConstants.APPUSER_LOGIN_ERROR_MESSAGE);
            }
            System.out.println("Login successful");
            return appUser;
        } catch (Exception e) {
            throw new GeneralException(
                    GeneralConstants.GENERAL_ERROR_CODE,
                    GeneralConstants.GENERAL_ERROR_MESSAGE);
        }
    }
}
