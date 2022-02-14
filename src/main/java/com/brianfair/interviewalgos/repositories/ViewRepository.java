package com.brianfair.interviewalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brianfair.interviewalgos.models.View;

@Repository
public interface ViewRepository extends CrudRepository<View, Long>
{
	List<View> findAll();
//	List<Rate> findAllByOrderByLikersAsc();
	
//	@Modifying
//	@Query("update Idea idea set idea.content=?1 where idea.id=?2")
//	int updateIdea(String content, Long id);
    

    
}