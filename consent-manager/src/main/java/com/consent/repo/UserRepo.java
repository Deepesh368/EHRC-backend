package com.consent.repo;

import com.consent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    public User findByEmailIgnoreCase(String email);
    public User findByUniqueIDIgnoreCase(String id);
}
