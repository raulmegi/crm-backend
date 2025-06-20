package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByName(String name);
    Optional<AppUser> findAppUserByEmail(String email);
}