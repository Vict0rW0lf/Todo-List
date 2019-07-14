package com.todo.app.todoapp.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.todoapp.entity.Item;
import com.todo.app.todoapp.repository.ItemRepository;

@RestController
public class ItemResource {

	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("")
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		
		itemRepo.findAll().forEach(items::add);
		
		return items;
	}
	
	
}
