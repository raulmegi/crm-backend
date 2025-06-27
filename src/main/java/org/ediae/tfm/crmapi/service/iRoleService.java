package org.ediae.tfm.crmapi.service;

import org.ediae.tfm.crmapi.entity.Role;

import java.util.List;

public interface iRoleService {

    public Role findById(Long id);
    List<Role> findAll();

}
