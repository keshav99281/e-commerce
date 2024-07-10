package com.example.E_commerce.Service;

import com.example.E_commerce.Model.User;
import com.example.E_commerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> GetAll(){
        return userRepository.findAll();
    }

    public String Delete(int id){
        User user = new User();
        userRepository.deleteById(id);
        return user.getName()+" Has been removed!!";
    }

    public String Update(int id,String newName,String newUsername,String newPassword){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User newUser = user.get();
            newUser.setName(newName);
            newUser.setUsername(newUsername);
            newUser.setPassword(newPassword);
            userRepository.save(newUser);
            return newName+"User updated Successfully!!";
        }else {
            return "No student found with ID:"+id;
        }
    }

}
