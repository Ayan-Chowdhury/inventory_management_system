package com.ims.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ims.inventory.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
