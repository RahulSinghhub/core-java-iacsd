package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommentDto;
import com.blogs.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	public CommentController() {
		System.out.println("starting controller");
	}
	
	//adding a post method for comment
	@PostMapping
	public ApiResponse addNewComment(@RequestBody CommentDto commentdto) {
		System.out.println("gonna add a new comment " + commentdto);
		return commentService.addNewComment(commentdto);
	}
	

}
