package com.zest.employee_management.repository.User;

import com.zest.employee_management.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
}
