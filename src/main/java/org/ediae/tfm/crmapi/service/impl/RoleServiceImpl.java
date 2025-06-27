package org.ediae.tfm.crmapi.service.impl;

import org.ediae.tfm.crmapi.entity.Role;
import org.ediae.tfm.crmapi.repository.RoleRepository;
import org.ediae.tfm.crmapi.service.iRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements iRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
