package com.brianfair.interviewalgos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="algos")
public class Algo
{

	public Algo() {
	}
    
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	    
   
	@NotNull
	@Size(min = 2, max = 100, message="Must be more than 2 characters long!")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 500, message="Must be more than 2 characters long!")
	private String solution;
	
	@NotNull(message="Can't be blank!")
	@Size(min = 2, max = 500, message="Must be more than 2 characters long!")
	private String description;
	    
	    	    
		// Monday Jan 27, 2021 = "E, MMM dd, yyyy"
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    
	// Monday Jan 27, 2021 = "E, MMM dd, yyyy"
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
	
	
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
//	
//	
//	@OneToMany(mappedBy="show", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<Rate> ratings;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable
	(
	    name = "likes", 
	    joinColumns = @JoinColumn(name = "algo_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> likers;
	
	@OneToMany(mappedBy="algo", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Comment> comments;
	
	@OneToMany(mappedBy="algo", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<View> views;

	
    @PrePersist
    private void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    private void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<View> getViews() {
		return views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}
	
	

	
	
   
   
		
	    
	    
}
