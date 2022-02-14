package com.brianfair.interviewalgos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianfair.interviewalgos.models.Algo;
import com.brianfair.interviewalgos.models.User;
import com.brianfair.interviewalgos.models.View;
import com.brianfair.interviewalgos.repositories.AlgoRepository;
import com.brianfair.interviewalgos.repositories.ViewRepository;



@Service
public class AlgoService {
    
    @Autowired
    private AlgoRepository algoRepository;
    @Autowired
    private ViewRepository viewRepository;
    
    
    public List<Algo> getAllAlgos()
    {
    	return algoRepository.findAll();
    }

//    
    //find idea by id
    public Algo findAlgoById(Long id) {
    	Optional<Algo> algo = this.algoRepository.findById(id);
    	
    	if(algo.isPresent()) {
            return algo.get();
    	} else {
    	    return null;
    	}
    }
    
    public Algo save(Algo algo)
    {
    	return this.algoRepository.save(algo);
    }
    
    public Algo update(Algo algo)
    {
    	return this.algoRepository.save(algo);
    }
    
//    public void update(String content, Long id)
//    {
//    	this.ideaRepository.updateIdea(content, id);
//    }
//    
//    
    public void delete(Long id)
    {
    	algoRepository.deleteById(id);
    }
    
    public void like(User user, Algo algo)
    {
//    	List<User> usersWhoLiked = idea.getLikers();
//    	usersWhoLiked.add(user);
    	algo.getLikers().add(user);
    	this.algoRepository.save(algo);
    }
    
    
    public void unlike(User user, Algo algo)
    {
//    	List<User> usersWhoLiked = idea.getLikers();
//    	usersWhoLiked.remove(user);
    	algo.getLikers().remove(user);
    	this.algoRepository.save(algo);
    }
    
    
    public View incrementView(User user, Algo algo)
    {
//  	if (old.getUser().getId() == user.getId())
//  	{
//  		
//  	}
//  	List <View> views = algo.getViews();
//  	views.add())
    	Integer viewCount = algo.getViews().size();
    	View newView = new View(user, algo, viewCount+1);
//	  	List <View> views= algo.getViews();
//	  	
//	  	View updatedViewCount = new View(user,algo, newCount);
	//  	old.setRating(n_ew.getRating());
	//  	List<User> usersWhoLiked = idea.getLikers();
	//  	usersWhoLiked.add(user);
	//  	show.getRatings.add(user);
	  	return this.viewRepository.save(newView);
    }
    

    
}