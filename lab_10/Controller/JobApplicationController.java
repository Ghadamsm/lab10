package com.example.lab_10.Controller;


import com.example.lab_10.API.ApiResponse;
import com.example.lab_10.Model.JobApplication;
import com.example.lab_10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-app")
@RequiredArgsConstructor
public class JobApplicationController {


    private final JobApplicationService jobApplicationService ;



    @GetMapping("/get")
    public ResponseEntity getJopApplication(){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }




    @PostMapping("/add")
    public ResponseEntity addJopApplication(@RequestBody @Valid JobApplication jobApplication , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (jobApplicationService.addJobApplication(jobApplication) == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        jobApplicationService.addJobApplication( jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("job application added"));

    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer Id){
        if (jobApplicationService.deleteJobApplication(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("job application deleted"));

    }


}
