package com.camp.campApi.modules.users.repository;

import com.camp.campApi.modules.users.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    public Role findRoleByRoleName(String name);

}
