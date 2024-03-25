package com.example.lab_10.Service;


import com.example.lab_10.Model.JobApplication;
import com.example.lab_10.Model.JobPost;
import com.example.lab_10.Model.User;
import com.example.lab_10.Repository.JobApplicationRepository;
import com.example.lab_10.Repository.JobPostRepository;
import com.example.lab_10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository ;
    private final JobPostRepository jobPostRepository ;
    private final UserRepository userRepository ;


    public List<JobApplication> getJobApplication(){
        return jobApplicationRepository.findAll();
    }


    public Boolean addJobApplication(JobApplication jobApplication ){

        if (userRepository.existsById(jobApplication.getUserId()) && jobPostRepository.existsById(jobApplication.getJobPostId())) {
            jobApplicationRepository.save(jobApplication);
            return true ;
        }
        return null ;
    }


    public Boolean deleteJobApplication(Integer Id){

        if (jobApplicationRepository.existsById(Id)) {
            jobApplicationRepository.deleteById(Id);
            return true;
        }
        return null ;
    }

}
