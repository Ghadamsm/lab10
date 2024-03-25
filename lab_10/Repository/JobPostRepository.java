package com.example.lab_10.Repository;

import com.example.lab_10.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost , Integer> {
}
