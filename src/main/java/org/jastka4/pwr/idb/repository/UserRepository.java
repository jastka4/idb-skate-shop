package org.jastka4.pwr.idb.repository;

import org.jastka4.pwr.idb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(final String email);
}
