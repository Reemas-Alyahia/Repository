package com.example.exrep.Repository;


import com.example.exrep.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRipository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);
    User findUserByEmail(String email);
    User findUserByRole(String role);

//
//    /// //JPQL
//    ///
//
//
    @Query("select  u from User u where u.id=?1")
    User getUserById(Integer id);

    @Query("select u from  User u where u.username=?1 and u.password=?2")
    User getUsernameAndPass(String username,String passwords);

    @Query("select u from User u where u.role=?1")
    List<User>  getSpecificRole(String role);

    @Query("select u from User u where u.age>=?1")
    List<User> getUsererbyAge(Integer age);





}
