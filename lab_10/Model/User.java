package com.example.lab_10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "name must be not empty")
    @Size(min = 4 , message = "name must be more than 4 char")
    @Pattern(regexp = "^[a-zA-Z]", message = "characters only")
    @Column(columnDefinition = "varchar(10) not null")
    private String name ;


    @Email(message = "please enter a valid email")
    @Column(columnDefinition = "varchar(25) unique not null")
    private String email ;


    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String password ;


    @NotNull
    @Min(value = 21)
    @Column(columnDefinition = "int not null")
    private Integer age ;


    @NotEmpty
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$" , message = "role must be either JOB_SEEKER or EMPLOYER only.")
    @Column(columnDefinition = "varchar(11) not null check(role = 'JOB_SEEKER' or role = 'EMPLOYER')")
    private String role ;
}
