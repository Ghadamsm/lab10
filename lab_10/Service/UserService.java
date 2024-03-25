package com.example.lab_10.Service;


import com.example.lab_10.Model.JobPost;
import com.example.lab_10.Model.User;
import com.example.lab_10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository ;


    public List<User> getUser(){
        return userRepository.findAll();
    }


    public void addUser(User user){

        userRepository.save(user);

    }

    public Boolean updateUser(Integer Id , User user){

        User u = userRepository.getById(Id);

        if (u == null){
            return false;
        }

        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());


        userRepository.save(u);
        return true ;
    }



    public Boolean deleteUser(Integer Id){

        if (userRepository.existsById(Id)) {
            userRepository.deleteById(Id);
            return true;
        }
        return false ;
    }


}
