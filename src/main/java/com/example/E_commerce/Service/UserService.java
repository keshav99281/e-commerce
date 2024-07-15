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

    public User addUser(User user){ //checked
        return userRepository.save(user);
    }

    public List<User> GetAll(){ //checked
        return userRepository.findAll();
    }

    public String Delete(int id){ //checked
        User user = new User();
        String name = user.getName();
        userRepository.deleteById(id);
        return name+" Has been removed!!";
    }

    public String Update(int id,String newName,String newUsername,String newPassword){ //checked
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User newUser = user.get();
            updateField(newUser,newName,"name");
            updateField(newUser,newUsername,"username");
            updateField(newUser,newPassword,"password");
            userRepository.save(newUser);
            return newUser.getName()+" User updated Successfully!!";
        }else {
            return "No student found with ID: "+id;
        }
    }

    private void updateField(User user,String newValue,String fieldName){
        if (newValue!=null && !newValue.isBlank()){
            switch (fieldName){
                case "name":
                    user.setName(newValue);
                    break;
                case "username":
                    user.setUsername(newValue);
                    break;
                case "password":
                    user.setPassword(newValue);
                    break;
                default:
                    throw new IllegalArgumentException("No Such Column present in table or " +
                            "check the column name and try again!!");
            }
        }
    }

}
