package com.example.exrep.Controller;

import com.example.exrep.ApiResponce.ApiResponce;
import com.example.exrep.Model.User;
import com.example.exrep.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAlluser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addnewUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        }
        userService.addNewUser(user);
        return ResponseEntity.status(200).body(new ApiResponce("User Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(user,id);
        return ResponseEntity.status(200).body(new ApiResponce("User updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deletUser(id);
        return ResponseEntity.status(200).body(new ApiResponce("User Deleted"));
    }
    @GetMapping("getemail/{email}")
    public ResponseEntity getUsernameAndPass(@PathVariable String email){
        User user=userService.findUserbyEmail(email);
        return ResponseEntity.status(200).body(new ApiResponce("User Found"));
    }
    @GetMapping("getUser/username/{username}/passwords/{pass}")
    public ResponseEntity findUserbyEmail(@PathVariable String username,@PathVariable String pass){
        User user=userService.checkUsernameAndPass(username,pass);
        return ResponseEntity.status(200).body(new ApiResponce("User Found"));

    }

    @GetMapping("getRole/{role}")
    public ResponseEntity getrole(@PathVariable String role){
        List<User> user=userService.getrole(role);
        return ResponseEntity.status(200).body(new ApiResponce("User Found"));
    }

    @GetMapping("getUsersAge/{age}")
    public ResponseEntity getUsersAge(@PathVariable Integer age){
        List<User> user=userService.getUsersAge(age);
        return ResponseEntity.status(200).body(new ApiResponce("User Found"));
    }


}
