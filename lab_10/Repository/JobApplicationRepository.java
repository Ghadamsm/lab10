package com.example.lab_10.Repository;

import com.example.lab_10.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication , Integer> {
}
