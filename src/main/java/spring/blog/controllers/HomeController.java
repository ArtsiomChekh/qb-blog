package spring.blog.controllers;

import spring.blog.models.Post;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.blog.services.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@RequestMapping( value= { "/", "/home" } )
	public String index(Model model){
		// Get last 5 post
		List<Post> latest5Posts = this.postService.findLatest5();
		// Send results to view model
		model.addAttribute("latest5Posts", latest5Posts);
		// From the 5-posts list, get another and limit it to 3
		List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
		// Send to view model
		model.addAttribute("latest3Posts", latest3Posts);
		return "index"; //
	}

}
