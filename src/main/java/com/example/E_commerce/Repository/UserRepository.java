package com.example.E_commerce.Repository;

import com.example.E_commerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String username);

    boolean existsByPassword(String password);
}
