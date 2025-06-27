package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
