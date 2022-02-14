package com.brianfair.interviewalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brianfair.interviewalgos.models.Algo;


@Repository
public interface AlgoRepository extends CrudRepository<Algo,  Long>
{
	List<Algo> findAll();
	
//	List<Show> findAllByOrderByLikersAsc();
	
//	@Modifying
//	@Query("update Idea idea set idea.content=?1 where idea.id=?2")
//	int updateIdea(String content, Long id);
    
}