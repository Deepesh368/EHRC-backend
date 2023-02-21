package com.authentication.repo;

import com.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    public User findByEmailIgnoreCase(String email);
}
