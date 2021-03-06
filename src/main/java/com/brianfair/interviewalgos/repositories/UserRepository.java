package com.brianfair.interviewalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brianfair.interviewalgos.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> findAll();
    User findByEmail(String email);
    User findAllByEmail(String email);
    boolean existsByEmail(String email);
    
}