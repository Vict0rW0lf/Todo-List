package com.todo.app.todoapp.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListResource {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
}
