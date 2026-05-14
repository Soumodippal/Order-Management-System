package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmailAndPassword(String email,String password);
}
