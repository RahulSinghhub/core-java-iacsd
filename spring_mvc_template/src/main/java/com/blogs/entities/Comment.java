package com.blogs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "comments",uniqueConstraints =
@UniqueConstraint(columnNames = {"post_id","commenter_id"}))
public class Comment extends BaseEntity {
	//cinfigure comment *-> user commenter

	@Column(name="comment_text",length = 100)
	
	private String commentText;
	private int rating;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="commenter_id",nullable=false)
	private User commenter;
	@ManyToOne
	@JoinColumn(name="post_id",nullable = false)
    private BlogPost post;

	public BlogPost getPost() {
		return post;
	}

	public void setPost(BlogPost post) {
		this.post = post;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentText, int rating) {
		super();
		this.commentText = commentText;
		this.rating = rating;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Comment ID "+getId()+" [commentText=" + commentText + ", rating=" + rating + "]";
	}
	
	
}
