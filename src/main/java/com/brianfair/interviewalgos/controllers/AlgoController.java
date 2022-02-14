package com.brianfair.interviewalgos.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brianfair.interviewalgos.models.Algo;
import com.brianfair.interviewalgos.models.Comment;
import com.brianfair.interviewalgos.models.User;
import com.brianfair.interviewalgos.models.View;
import com.brianfair.interviewalgos.services.AlgoService;
import com.brianfair.interviewalgos.services.CommentService;
import com.brianfair.interviewalgos.services.UserService;
import com.brianfair.interviewalgos.services.ViewService;



@Controller
public class AlgoController
{

	@Autowired
    private UserService userService;
	@Autowired
	private AlgoService algoService;
	@Autowired
	private CommentService commentService;
//	@Autowired
//	private ViewService viewService;
	
	
	
  @RequestMapping("/algo/details/{id}")
  public String algoDetails(@ModelAttribute("comment") Comment comment, @PathVariable("id") Long algo_id,
  						Model model, 
  						HttpSession session)
  {
	if (session.getAttribute("user_id") == null)
	{
		return "redirect:/";
	}

 	Long user_id = (Long)session.getAttribute("user_id");
	User usr = this.userService.findUserById(user_id);
	model.addAttribute("user", usr);
	Algo algo = this.algoService.findAlgoById(algo_id);
	List <Comment> comments = algo.getComments();
	View viewCount = this.algoService.incrementView(usr, algo);
	model.addAttribute("viewCount", viewCount);


	boolean hasCommented = false;
	for(Comment thisComment: comments)
	{
		if(thisComment.getUser().getId() == user_id) hasCommented = true;
	}
	model.addAttribute("hasCommented", hasCommented);
	model.addAttribute("algo", algo);
	return "algodetails.jsp";
  }
  @RequestMapping(value="/add/comment/{id}", method=RequestMethod.POST)
  public String addingComment(@Valid @ModelAttribute("comment") Comment comment,
  							BindingResult result,
  							@PathVariable("id") Long algo_id,
  							HttpSession session,
  							Model model)
  {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
		model.addAttribute("user", usr);
		Algo this_algo = this.algoService.findAlgoById(algo_id);
		model.addAttribute("algo",this_algo);
      if (result.hasErrors()) {
          return "algodetails.jsp";
      } else{
      	commentService.save(comment);
      	return "redirect:/algo/details/"+algo_id;
      }
  }
  
  
  @RequestMapping("/edit/comment/{id}")
  public String editComment(@PathVariable("id") Long comment_id,
  						Model model, 
  						HttpSession session)
  {
	if (session.getAttribute("user_id") == null)
	{
		return "redirect:/";
	}
	Long user_id = (Long)session.getAttribute("user_id");
	User usr = this.userService.findUserById(user_id);
	model.addAttribute("user", usr);
	Comment thisComment = commentService.findCommentById(comment_id);
	model.addAttribute("comment", thisComment);
	Algo algo = thisComment.getAlgo();
	model.addAttribute("algo", algo);
	
	return "editcomment.jsp";
  }
  @RequestMapping(value="/editing/comment/{id}", method=RequestMethod.POST)
  public String editingComment(@Valid @ModelAttribute("comment") Comment comment,
  							BindingResult result,
  							@PathVariable("id") Long comment_id,
  							HttpSession session,
  							Model model)
  {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
		model.addAttribute("user", usr);
		Comment thisComment = commentService.findCommentById(comment_id);
		model.addAttribute("comment", thisComment);
		Algo algo = thisComment.getAlgo();
		model.addAttribute("algo", algo);
      if (result.hasErrors()) {
          return "editcomment.jsp";
      } else{
      	commentService.save(comment);
      	return "redirect:/algo/details/"+algo.getId();
      }
  }
  

  
    
    @RequestMapping("/add/algo")
    public String addAlgo(@ModelAttribute("algo") Algo algo, 
    			HttpSession session,
    			Model model) 
    {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
    	model.addAttribute("user", usr);
//		model.addAttribute("categories", this.categoryService.getAllCategories());
        return "addalgo.jsp";
    }
    @RequestMapping(value="/adding/algo", method=RequestMethod.POST)
    public String addingAlgo(@Valid @ModelAttribute("algo") Algo algo,
    							BindingResult result,
    							HttpSession session,
    							Model model)
    {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
    	model.addAttribute("user", usr);
        if (result.hasErrors()) {
            return "addalgo.jsp";
        } else{
        	Algo this_algo = algoService.save(algo);
        	return "redirect:/algo/details/"+this_algo.getId();
        }
    }
    
    
    
    
    @RequestMapping("/edit/algo/{id}")
    public String editAlgo(@PathVariable("id") Long algo_id, 
    			HttpSession session,
    			Model model) 
    {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
    	model.addAttribute("user", usr);

		Algo this_algo = this.algoService.findAlgoById(algo_id);
    	model.addAttribute("algo", this_algo);
    	//		model.addAttribute("categories", this.categoryService.getAllCategories());
        return "editalgo.jsp";
    }
    @RequestMapping(value="/editing/algo/{id}", method=RequestMethod.POST)
    public String editingAlgo(@Valid @ModelAttribute("algo") Algo algo,
    							BindingResult result,
    							@PathVariable("id") Long algo_id,
    							HttpSession session,
    							Model model)
    {
		if (session.getAttribute("user_id") == null)
		{
			return "redirect:/";
		}
		Long user_id = (Long)session.getAttribute("user_id");
		User usr = this.userService.findUserById(user_id);
    	model.addAttribute("user", usr);
//		Algo this_algo = this.algoService.findAlgoById(algo_id);
//    	model.addAttribute("algo", this_algo);
        if (result.hasErrors()) {
        	System.out.println(result);
            return "editalgo.jsp";
        } else{
        	Algo this_algo = algoService.save(algo);
        	return "redirect:/algo/details/"+this_algo.getId();
        }
    }
	
    
    
  	@RequestMapping("/delete/algo/{id}")
  	public String deleteIdea(@PathVariable("id") Long algo_id, HttpSession session)
  	{
  		if (session.getAttribute("user_id") == null)
  		{
  			return "redirect:/";
  		}
  		algoService.delete(algo_id);
  		return "redirect:/home";
  	}
  	
  	
  	@RequestMapping("/delete/comment/{comment_id}/{id}")
  	public String deleteComment(@PathVariable("comment_id") Long comment_id, @PathVariable("id") Long algo_id, HttpSession session)
  	{
  		if (session.getAttribute("user_id") == null)
  		{
  			return "redirect:/";
  		}
  		commentService.delete(comment_id);
  		return "redirect:/algo/details/"+algo_id;
  	}
  	
  	
	
	
}
	

//    
//    
//    @GetMapping("/edit/show/{id}")
//    public String editShow(@PathVariable("id") Long show_id, 
//  		  				HttpSession session,
//  		  				Model model) 
//    {
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//		Long user_id = (Long)session.getAttribute("user_id");
//		User usr = this.userService.findUserById(user_id);
//		model.addAttribute("user", usr);
//		model.addAttribute("showEdit", this.showService.findShowById(show_id));
//        return "editshow.jsp";
//    }
//    @PostMapping("/editing/show/{id}")
//    public String updateShow(@Valid @ModelAttribute("showEdit") Show show,
//  		  					BindingResult result,
//  							Model model,
//  							@PathVariable("id") Long show_id,
//  							HttpSession session)
//    {
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//        if (result.hasErrors()) {
////      	  model.addAttribute("ideaEdit", ideaService.findIdeaById(idea_id));
//            return "editshow.jsp";
//        } else{
//   //   	  System.out.println(idea.getContent());
//      	  this.showService.update(show);
//      	  return "redirect:/home";
//        }
    
    
  //################################################################################################3
  //######################################## - Exam Code Below - ############################################33	
//  @GetMapping("/show/details/{id}")
//  public String IdeaDetails(@ModelAttribute("rating") Rate rate, 
//		  				@PathVariable("id") Long show_id,
//  						Model model, 
//  						HttpSession session)
//  {
//	if (session.getAttribute("user_id") == null)
//	{
//		return "redirect:/";
//	}
//	Long user_id = (Long)session.getAttribute("user_id");
//	
//	boolean haveRated = false;
//	session.setAttribute("haveRated", haveRated);
//	Rate thisUsersRating = null;
//	long thisUsersRatingId = 0;
//	List<Rate> thisShowRatings = showService.findShowById(show_id).getRatings();
//	for(Rate rating : thisShowRatings)
//	{
//		if (rating.getUser().getId() == user_id)
//		{
//			haveRated = true;
//			session.setAttribute("haveRated", haveRated);
//			thisUsersRating = rating;
//			thisUsersRatingId = thisUsersRating.getId();
//			session.setAttribute("ratingId", thisUsersRatingId);		
//		} 
////		else { haveRated = false;}
//	}
////	//	model.addAttribute("haveRated", haveRated); 
//	model.addAttribute("usersRating", thisUsersRating);
//	User usr = this.userService.findUserById(user_id);
//  	Show show = this.showService.findShowById(show_id);
//  	model.addAttribute("show", show);
//  	model.addAttribute("user", usr);
//  	return "showdetails.jsp";
// 	}
    
//    
//    @PostMapping("/rate/{id}")
//    public String rateShow(@Valid @ModelAttribute("rating") Rate rate,
//  		  					BindingResult result,
//  		  					@PathVariable("id") Long show_id,
//  							Model model,
//  							HttpSession session)
//    {
//  		if (session.getAttribute("user_id") == null)
//  		{
//  			return "redirect:/";
//  		}
//    		Long user_id = (Long)session.getAttribute("user_id");
//    		User usr = this.userService.findUserById(user_id);
//    	  	Show show = this.showService.findShowById(show_id);
//    	  	model.addAttribute("show", show);
//    	  	model.addAttribute("user", usr);
//        if (result.hasErrors()) {
////      	  model.addAttribute("ideaEdit", ideaService.findIdeaById(idea_id));
//            return "showdetails.jsp";
//        }
////        } else{
////      	  
////  			boolean haveRated = false;
////  			Rate usersRating = null;
////  			List<Rate> thisShowRatings = showService.findShowById(show_id).getRatings();
////  			for(Rate rating : thisShowRatings)
////  			{
////  				if (rating.getUser().getId() == user_id)
////  				{
////  					haveRated = true;
////  					usersRating = rating;
//////  					usersRating.setRating(rate.getRating());
//////  					this.rateService.createRating(usersRating);
//////  					this.rateService.updateRating(usr, show, rate.getRating());
////  					
////  				} 
////  				else 
////  				{ 
////  					haveRated = false;
////  			    	this.rateService.createRating(rate);
////  				}
////  				
////  			}
//  	 //   	  System.out.println(idea.getContent());
////  	    	  System.out.println(rate.getRating());
//  				this.rateService.createRating(rate);
//  				Long showId = rate.getShow().getId();
//  			
//  	    	  return "redirect:/show/details/"+showId;
//        }
//    
//    
    
//  @PostMapping("/rate/update/{id}")
//  public String updatShowRate(@Valid @ModelAttribute("rating") Rate rate,
//		  					BindingResult result,
//		  					@PathVariable("id") Long rating_id,
//							Model model,
//							HttpSession session)
//  {
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//		boolean haveRated = false;
//		Rate usersRating = null;
//		Long user_id = (Long)session.getAttribute("user_id");
//		List<Rate> thisShowRatings = showService.findShowById(rating_id).getRatings();
//		for(Rate rating : thisShowRatings)
//		{
//			if (rating.getUser().getId() == user_id)
//			{
//				haveRated = true;
//				usersRating = rating;
//			} 
//			else { haveRated = false;}
//		}
//      if (result.hasErrors()) {
////    	  model.addAttribute("ideaEdit", ideaService.findIdeaById(idea_id));
//	  		User usr = this.userService.findUserById(user_id);
//	  		Rate rating = this.rateService.findRateById(rating_id);
//	  	  	Show show = this.showService.findShowById(rating.getShow().getId());
//	  	  	model.addAttribute("show", show);
//	  	  	model.addAttribute("user", usr);
//          return "showdetails.jsp";
//      } else{
// //   	  System.out.println(idea.getContent());
//    	  System.out.println(rate.getRating());
//    	  this.rateService.createRating(rate);
//    	  Long showId = rate.getShow().getId();
//    	  return "redirect:/show/details/"+showId;
//      }
//  }
   
  
//################################################################################################3
//##############################################################################################33
//  @GetMapping("/show/details/{id}")
//  public String IdeaDetails(@PathVariable("id") Long show_id,
//  						Model model, 
//  						HttpSession session)
//  {
//	if (session.getAttribute("user_id") == null)
//	{
//		return "redirect:/";
//	}
//	Long user_id = (Long)session.getAttribute("user_id");
//	
//	boolean haveRated = false;
//	if (session.getAttribute("haveRated") == null)
//	{
//		session.setAttribute("haveRated", false);
//	}
//
//	Rate thisUsersRating = null;
//	long thisUsersRatingId = 0;
//  	Show show = this.showService.findShowById(show_id);
//	List<Rate> thisShowRatings = showService.findShowById(show_id).getRatings();
//	model.addAttribute("usersRating", thisUsersRating);
//	User usr = this.userService.findUserById(user_id);
//  	model.addAttribute("show", show);
//  	model.addAttribute("user", usr);
//	for(Rate rating : thisShowRatings)
//	{
//		if (rating.getUser().getId() == user_id)
//		{
//			haveRated = true;
//			session.setAttribute("haveRated", haveRated);
//			thisUsersRating = rating;
//			thisUsersRatingId = thisUsersRating.getId();
//			session.setAttribute("ratingId", thisUsersRatingId);
//			return "redirect:/details/update/rate/"+show_id;
//		}
//	}
//  	return "redirect:/details/rate/"+show_id;
//  }
//  
//  
//  @GetMapping("/details/update/rate/{id}")
//  public String detailsUpdateRating(@PathVariable("id") Long show_id,
//  						Model model, 
//  						HttpSession session)
//  {
//	if (session.getAttribute("user_id") == null)
//	{
//		return "redirect:/";
//	}
//	Long user_id = (Long)session.getAttribute("user_id");
//	Long thisUserRatingId = (Long)session.getAttribute("ratingId");
//	boolean haveRated = (boolean)session.getAttribute("haveRated");
//	Show show = this.showService.findShowById(show_id);
//	User usr = this.userService.findUserById(user_id);
//	model.addAttribute("usersRating", this.rateService.findRateById(thisUserRatingId));
//  	model.addAttribute("show", show);
//  	model.addAttribute("user", usr);
//  	return "showdetails.jsp";
//	
//  }
//  
//  
//  
//  @GetMapping("/details/rate/{id}")
//  public String detailsRating(@RequestParam 
//						@PathVariable("id") Long show_id,
//  						Model model, 
//  						HttpSession session)
//  {
//	if (session.getAttribute("user_id") == null)
//	{
//		return "redirect:/";
//	}
//	Long user_id = (Long)session.getAttribute("user_id");
//	Long thisUserRatingId = (Long)session.getAttribute("ratingId");
//	boolean haveRated = (boolean)session.getAttribute("haveRated");
//	Show show = this.showService.findShowById(show_id);
//	User usr = this.userService.findUserById(user_id);
//	model.addAttribute("usersRating", this.rateService.findRateById(thisUserRatingId));
//  	model.addAttribute("show", show);
//  	model.addAttribute("user", usr);
//  	return "showdetails.jsp";
//	
//  }
//  
//
////################################################################################################3
////##############################################################################################33
//
//  @PostMapping("/rate/{id}")
//  public String rateShow(@RequestParam 
//		  					@PathVariable("id") Long show_id,
//							Model model,
//							HttpSession session)
//  {
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//  		Long user_id = (Long)session.getAttribute("user_id");
//  		User usr = this.userService.findUserById(user_id);
//  	  	Show show = this.showService.findShowById(show_id);
//  	  	model.addAttribute("show", show);
//  	  	model.addAttribute("user", usr);
////   	  System.out.println(idea.getContent());
////	    	  System.out.println(rate.getRating());
//				this.rateService.createRating(rate);
//				Long showId = rate.getShow().getId();
//			
//	    	  return "redirect:/show/details/"+showId;
//      }
// 
//  
//  
//  
//	@GetMapping("/delete/show/{id}")
//	public String deleteIdea(@PathVariable("id") Long show_id, HttpSession session)
//	{
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//		showService.delete(show_id);
//		return "redirect:/home";
//	}
//	
//    @RequestMapping("/logout")
//    public String logout(HttpSession session)
//    {
//		if (session.getAttribute("user_id") == null)
//		{
//			return "redirect:/";
//		}
//    	session.invalidate();
//    	return "redirect:/";
//    }
//  
//	
//}
//	
//	
////DONT FORGET TO CHECK TO MAKE SURE USER IS LOGGED IN!!!!!!!!!!!!!!!!!!!!!!!!!
//    
//    @GetMapping("/idea/details/{idea_id}")
//    public String IdeaDetails(@PathVariable("idea_id") Long idea_id,
//    						Model model, 
//    						HttpSession session)
//    {
//		Long user_id = (Long)session.getAttribute("user_id");
//		User usr = this.userService.findUserById(user_id);
//    	Show this_idea = this.ideaService.findIdeaById(idea_id);
//    	model.addAttribute("idea", this_idea);
//    	model.addAttribute("user", usr);
//    	return "ideadetails.jsp";
//   	}
//    
//    
//    @RequestMapping("/create/idea")
//    public String createIdea(@ModelAttribute("idea") Show idea, 
//    			HttpSession session,
//    			Model model) 
//    {
//		Long user_id = (Long)session.getAttribute("user_id");
//		User usr = this.userService.findUserById(user_id);
//    	model.addAttribute("user", usr);
////		model.addAttribute("categories", this.categoryService.getAllCategories());
//        return "createidea.jsp";
//    }
//    @RequestMapping(value="/creating/idea", method=RequestMethod.POST)
//    public String creatingIdea(@Valid @ModelAttribute("idea") Show idea,
//    							BindingResult result)
//    {
//        if (result.hasErrors()) {
//            return "createidea.jsp";
//        } else{
//        	ideaService.save(idea);
//            return "redirect:/home";
//        }
//    }
//    
//    //TRY #5
//  @GetMapping("/edit/idea/{id}")
//  public String editIdea(@PathVariable("id") Long idea_id, 
//		  				HttpSession session,
//		  				Model model) 
//  {
//	  Long user_id = (Long)session.getAttribute("user_id");
//	  User usr = this.userService.findUserById(user_id);
//	  model.addAttribute("user", usr);
//  	  model.addAttribute("ideaEdit", this.ideaService.findIdeaById(idea_id));
//      return "editidea.jsp";
//  }
//  @PostMapping("/editing/idea/{id}")
//  public String updateIdea(@Valid @ModelAttribute("ideaEdit") Show idea,
//		  					BindingResult result,
//							Model model,
//							@PathVariable("id") Long idea_id)
//  {
//      if (result.hasErrors()) {
////    	  model.addAttribute("ideaEdit", ideaService.findIdeaById(idea_id));
//          return "editidea.jsp";
//      } else{
// //   	  System.out.println(idea.getContent());
//    	  this.ideaService.update(idea);
//    	  return "redirect:/home";
//      }
//  }
//  
//  	@GetMapping("/delete/idea/{idea_id}")
//  	public String deleteIdea(@PathVariable("idea_id") Long idea_id)
//  	{
//  		ideaService.deleteIdea(idea_id);
//  		return "redirect:/home";
//  	}
//  	
//    @RequestMapping("/logout")
//    public String logout(HttpSession session)
//    {
//    	session.invalidate();
//    	return "redirect:/";
//    }
//    TRY #1
//    @RequestMapping("/edit/idea/{idea_id}")
//    public String editIdea(HttpSession session,
//    			Model model,
//    			@PathVariable("idea_id") Long idea_id) 
//    {
// //   	session.setAttribute("idea_id", idea_id);
//		Long user_id = (Long)session.getAttribute("user_id");
//		Idea this_idea = ideaService.findIdeaById(idea_id);
//		User usr = this.userService.findUserById(user_id);
//    	model.addAttribute("user", usr);
//    	model.addAttribute("this_idea", this_idea);
//      return "editidea.jsp";
//    }
//    @RequestMapping("/editing/idea/{idea_id}")
//    public String updateIdea(@Valid @ModelAttribute("this_idea") Idea idea,
//    							@PathVariable("idea_id") Long idea_id,
//    							BindingResult result)
//    {
//        if (result.hasErrors()) {
//            return "editidea.jsp";
//        } else{
//        	System.out.println(idea_id);
//        	ideaService.update(idea);
//          return "redirect:/home";
//        }
//    }
//    
    
    
//    TRY #2
//    @GetMapping("/edit/idea/{idea_id}")
//    public String editIdea(@PathVariable("idea_id") Long idea_id,
//    					@ModelAttribute("idea") Idea idea,
//    					Model model) 
//    {
// //   	session.setAttribute("idea_id", idea_id);
////		Long user_id = (Long)session.getAttribute("user_id");
////		User usr = this.userService.findUserById(user_id);
////    	model.addAttribute("user", usr);
//    	model.addAttribute("idea", ideaService.findIdeaById(idea_id));
////		model.addAttribute("categories", this.categoryService.getAllCategories());
//        return "editidea.jsp";
//    }
//    @PostMapping("/edit/idea/{idea_id}")
//    public String updateIdea(@Valid @ModelAttribute("idea") Idea idea, 
//    							BindingResult result,
//    							@PathVariable("idea_id") Long idea_id,
//    							Model model
//    							)
//    {
//        if (result.hasErrors()) {
//        	model.addAttribute("idea", ideaService.findIdeaById(idea_id));
//            return "editidea.jsp";
//        } else{
//        	System.out.println(idea_id);
//        	ideaService.update(idea);
//            return "redirect:/home";
//        }
//    }
    
////  TRY #3
//  @RequestMapping("/edit/idea/{idea_id}")
//  public String editIdea(@PathVariable("idea_id") Long idea_id, Model model, HttpSession session) 
//  {
////   	session.setAttribute("idea_id", idea_id);
//		Long user_id = (Long)session.getAttribute("user_id");
//		User usr = this.userService.findUserById(user_id);
//  	model.addAttribute("user", usr);
//  	model.addAttribute("idea", ideaService.findIdeaById(idea_id));
////		model.addAttribute("categories", this.categoryService.getAllCategories());
//      return "editidea.jsp";
//  }
//  @RequestMapping(value="/editing/idea/{idea_id}", method=RequestMethod.PUT)
//  public String updateIdea(@Valid @ModelAttribute("idea") Idea idea,
//		  					BindingResult result)
//  					
//  {
//      if (result.hasErrors()) {
//          return "editidea.jsp";
//      } else{
//      	ideaService.update(idea);
//          return "redirect:/home";
//      }
//  }

    
//    //TRY #4
//  @GetMapping("/edit/idea/{idea_id}")
//  public String editIdea(@PathVariable("idea_id") Long idea_id, Model model) 
//  {
//  	  model.addAttribute("ideaEdit", this.ideaService.findIdeaById(idea_id));
//      return "editidea.jsp";
//  }
//  @PostMapping("/editing/idea/{idea_id}")
//  public String updateIdea(@Valid @ModelAttribute("ideaEdit") Idea idea,
//		  					BindingResult result, 
//							@PathVariable("idea_id") Long idea_id,
//							Model model)
//  {
//      if (result.hasErrors()) {
//          return "editidea.jsp";
//      } else{
//    	  System.out.println(idea.getContent());
//    	  this.ideaService.update(idea);
//    	  return "redirect:/home";
//      }
//  }
  
//    @RequestMapping("/logout")
//    public String logout(HttpSession session) {
//    	session.invalidate();
//    	return "redirect:/";
//    }



