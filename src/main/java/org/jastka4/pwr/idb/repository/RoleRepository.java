package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(final String role);
}
