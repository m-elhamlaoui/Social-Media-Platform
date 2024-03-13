package org.sop.spacebackend.security.repositories;


import org.sop.spacebackend.security.models.ERole;
import org.sop.spacebackend.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

