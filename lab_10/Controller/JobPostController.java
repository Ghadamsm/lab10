package com.example.lab_10.Controller;


import com.example.lab_10.API.ApiResponse;
import com.example.lab_10.Model.JobPost;
import com.example.lab_10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-post")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService ;

    @GetMapping("/get")
    public ResponseEntity getJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }



    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("job added"));

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateJobPost(@PathVariable Integer Id , @RequestBody @Valid JobPost jobPost , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = jobPostService.updateJobPost(Id , jobPost);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("job updated"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer Id ){


        if (jobPostService.deleteJobPost(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("job deleted"));

    }

}
