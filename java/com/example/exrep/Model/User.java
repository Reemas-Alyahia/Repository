package com.example.exrep.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Check(constraints = "role IN ('User', 'Admin')")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not be Empty!...")
    @Size(min = 4, message = "The length must be more than 4 characters")
    @Column(columnDefinition ="varchar(10) not null")
    private String name;

    @NotEmpty(message = "username must not be Empty!...")
    @Size(min = 4, message = "The length must be more than 4 characters")
    @Column(columnDefinition ="varchar(10) not null unique")
    private String username;

    @Pattern(regexp = "(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$",message ="Password must contain at least one digit [0-9].\n" +
            "Password must contain at least one lowercase Latin character [a-z].\n" +
            "Password must contain at least one uppercase Latin character [A-Z].\n" +
            "Password must contain at least one special character like ! @ # & ( ).\n" +
            "Password must contain a length of at least 8 characters and a maximum of 20 characters." )
    @NotEmpty(message = "password cannot be Empty!..")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;


    @NotEmpty(message = "email cannot be Empty!..")
    @Email(message = "Must be a valid email format")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


    @NotEmpty(message = "Role cannot be Empty!..")
    @Pattern(regexp = "^(User|Admin)$",message = "the role must be \"User\" or \"Admin\"")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;

    @NotNull(message = " age cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer age;


}
