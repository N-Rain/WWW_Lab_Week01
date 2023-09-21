package vn.edu.iuh.fit.lab_week_01.services;

import vn.edu.iuh.fit.lab_week_01.models.Role;
import vn.edu.iuh.fit.lab_week_01.repositories.RoleRepository;

public class RoleServices {
    private RoleRepository repository;

    public RoleServices() {
        repository=new RoleRepository();
    }

    public void addRole(Role role){
        repository.addRole(role);
    }
}
