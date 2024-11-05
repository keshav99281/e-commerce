package com.example.E_commerce.ServiceInterface;

import com.example.E_commerce.Model.User;
import com.example.E_commerce.Repository.UserRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterf{
    ResponseEntity<?> addUser(User user);
    List<User> GetAll();
    String Delete(int userId);
    String Update(int id,String newName,String newUsername,String newPassword);
}
