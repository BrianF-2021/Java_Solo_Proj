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
public class ViewService {
	
	@Autowired
	private ViewRepository viewRepository;
	@Autowired
	private AlgoService algoService;
	
   
    public View save(View view)
    {
    	return this.viewRepository.save(view);
    }
    
    

    public View findViewById(Long id) {
    	Optional<View> view = this.viewRepository.findById(id);
//    	Comment comment = this.commentRepository.findById(id);

    	
    	if(view.isPresent()) {
            return view.get();
    	} else {
    	    return null;
    	}
    }
    
//    public void incrementView(User user, Algo algo)
//    {
////    	if (old.getUser().getId() == user.getId())
////    	{
////    		
////    	}
////    	List <View> views = algo.getViews();
////    	views.add())
//    	List <View> views= algo.getViews();
//    	
//    	
//    	View updatedViewCount = new View(user,algo, newCount);
////    	old.setRating(n_ew.getRating());
////    	List<User> usersWhoLiked = idea.getLikers();
////    	usersWhoLiked.add(user);
////    	show.getRatings.add(user);
//    	this.viewRepository.save(updatedViewCount);
//    }

    public void delete(Long id)
    {
    	viewRepository.deleteById(id);
    }
//    public void updateRating(User user, Show show, String rating)
//    {
////    	if (old.getUser().getId() == user.getId())
////    	{
////    		
////    	}
//    	Rate newRate = new Rate(user,show,rating);
////    	old.setRating(n_ew.getRating());
////    	List<User> usersWhoLiked = idea.getLikers();
////    	usersWhoLiked.add(user);
////    	show.getRatings.add(user);
//    	this.rateRepository.save(newRate);
//    }
//    
    

    
}