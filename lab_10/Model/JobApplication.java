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
public class JobApplication {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotNull(message = "user Id should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;


    @NotNull(message = "job Post Id should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId ;


}
