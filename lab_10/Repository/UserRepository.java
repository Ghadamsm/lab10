package com.example.lab_10.Repository;

import com.example.lab_10.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {
}
