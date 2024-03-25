package com.example.lab_10.Controller;


import com.example.lab_10.API.ApiResponse;
import com.example.lab_10.Model.User;
import com.example.lab_10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService ;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = userService.updateUser(Id , user);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){


        if (userService.deleteUser(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));

    }

}
