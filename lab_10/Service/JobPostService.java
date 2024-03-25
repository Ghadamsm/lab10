package com.example.lab_10.Service;


import com.example.lab_10.Model.JobPost;
import com.example.lab_10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository ;


    public List<JobPost> getJobPost(){
        return jobPostRepository.findAll();
    }


    public void addJobPost(JobPost jobPost){

        jobPostRepository.save(jobPost);

    }

    public Boolean updateJobPost(Integer Id , JobPost jobPost){

        JobPost jp = jobPostRepository.getById(Id);

        if (jp == null){
            return false;
        }

        jp.setTitle(jobPost.getTitle());
        jp.setDescription(jobPost.getDescription());
        jp.setSalary(jobPost.getSalary());
        jp.setLocation(jobPost.getLocation());
        jp.setPostingDate(jobPost.getPostingDate());

        jobPostRepository.save(jp);
        return true ;
    }



    public Boolean deleteJobPost(Integer Id){

        if (jobPostRepository.existsById(Id)) {
            jobPostRepository.deleteById(Id);
            return true;
        }
        return false ;
    }

}
