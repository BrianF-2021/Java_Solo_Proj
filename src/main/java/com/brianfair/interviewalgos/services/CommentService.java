package com.brianfair.interviewalgos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brianfair.interviewalgos.models.Algo;
import com.brianfair.interviewalgos.models.Comment;
import com.brianfair.interviewalgos.models.User;
import com.brianfair.interviewalgos.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
   
    public Comment save(Comment comment)
    {
    	return this.commentRepository.save(comment);
    }
    
    

    public Comment findCommentById(Long id) {
    	Optional<Comment> comment = this.commentRepository.findById(id);
//    	Comment comment = this.commentRepository.findById(id);

    	
    	if(comment.isPresent()) {
            return comment.get();
    	} else {
    	    return null;
    	}
    }
    
    public void updateComment(User user, Algo algo, String comment)
    {
//    	if (old.getUser().getId() == user.getId())
//    	{
//    		
//    	}
    	Comment newComment = new Comment(user,algo, comment);
//    	old.setRating(n_ew.getRating());
//    	List<User> usersWhoLiked = idea.getLikers();
//    	usersWhoLiked.add(user);
//    	show.getRatings.add(user);
    	this.commentRepository.save(newComment);
    }

    public void delete(Long id)
    {
    	commentRepository.deleteById(id);
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