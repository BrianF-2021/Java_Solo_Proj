package com.brianfair.interviewalgos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="comments")
public class Comment {
	
	public Comment() {}
	
	public Comment(User user, Algo algo, String comment)
	{
		this.user = user;
		this.algo = algo;
		this.thisComment = comment;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=500, message="Must be more than 3 characters long!")
	private String thisComment;

	// Monday Jan 27, 2021 = "E, MMM dd, yyyy"
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    
	// Monday Jan 27, 2021 = "E, MMM dd, yyyy"
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
	
    @PrePersist
    private void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    private void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="algo_id")
	private Algo algo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThisComment() {
		return thisComment;
	}

	public void setThisComment(String thisComment) {
		this.thisComment = thisComment;
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

	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	




}
