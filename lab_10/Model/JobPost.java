package com.example.lab_10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;


    @NotEmpty(message = "title cannot be empty")
    @Size(min = 4 , message = "title must be more than 4 characters")
    @Column(columnDefinition = "varchar(40) not null")
    private String title ;


    @NotEmpty(message = "description cannot be empty")
    @Column(columnDefinition = "varchar(250) not null ")
    private String description ;


    @NotEmpty(message = "location cannot be empty")
    @Column(columnDefinition = "varchar(100) not null ")
    private String location ;


    @NotNull
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer salary ;


    @DateTimeFormat
    @Column(columnDefinition = "date")
    private LocalDate postingDate ;

}
