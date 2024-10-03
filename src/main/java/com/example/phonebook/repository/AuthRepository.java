package com.example.phonebook.repository;

import com.example.phonebook.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
