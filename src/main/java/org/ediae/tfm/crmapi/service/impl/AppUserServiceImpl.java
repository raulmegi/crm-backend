package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.entity.AppUser;
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
    public AppUser createAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findAppUserById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUserById(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public Optional<AppUser> findAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }
    @Override
    public AppUser login(String email, String password) {
        Optional<AppUser> optionalAppUser = appUserRepository.findAppUserByEmail(email);
        if (optionalAppUser.isPresent()) {
            AppUser appUser = optionalAppUser.get();
            if (appUser.getPassword().equals(password)) {
                System.out.println("Login successful");
                return appUser;
            } else {
                throw new RuntimeException("Invalid email or password");
            }
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
