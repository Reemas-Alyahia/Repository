package com.example.exrep.Service;

import com.example.exrep.ApiResponce.ApiExption;
import com.example.exrep.Model.User;
import com.example.exrep.Repository.UserRipository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRipository userRepository;

    public List<User>getUsers(){
        return userRepository.findAll();
    }


    public void addNewUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user,Integer id){
        User olduser=userRepository.getUserById(id);
        if(olduser==null){
            throw new ApiExption("No users yet");
        }
        olduser.setName(user.getName());
        olduser.setAge(user.getAge());
        olduser.setRole(user.getRole());
        olduser.setUsername(user.getUsername());
        olduser.setEmail(user.getEmail());
        olduser.setPassword(user.getPassword());

        userRepository.save(olduser);

    }


    public void deletUser(Integer id){
        User user=userRepository.getUserById(id);
        if(user==null){
            throw new ApiExption("No users yet");

        }
        userRepository.delete(user);
    }

    public User checkUsernameAndPass(String username,String passwords){
        User user =userRepository.getUsernameAndPass(username,passwords);
        if(user==null){
            throw new ApiExption("Cannot found user like this");
        }
        return user;
    }
    public User findUserbyEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiExption("Cannot found user like this");
        }
        return user;

    }

public List<User> getrole(String role){
    List<User>newl=userRepository.getSpecificRole(role);
    if(newl==null){
        throw new ApiExption("not found");
    }
    return newl;

}

    public List<User> getUsersAge(Integer age) {
        List<User> newList = userRepository.getUsererbyAge(age);
        if (newList == null || newList.isEmpty()) {
            throw new ApiExption("Cannot find users with this age or above.");
        }
        return newList;
    }




}
