package com.todo.app.todoapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo.app.todoapp.service.ItemService;

@Controller
public class ListResource {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("itens", itemService.getAllItems());
		
		return "home";
	}
	
	
}
