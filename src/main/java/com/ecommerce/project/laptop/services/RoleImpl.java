package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Role;
import com.ecommerce.project.laptop.reponsitory.RoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleImpl implements RoleSevice {
@Autowired
private RoleReponsitory roleReponsitory;
    @Override
    public Role getById(int id) {
        return roleReponsitory.findById(id).orElse(new Role());
    }
}
