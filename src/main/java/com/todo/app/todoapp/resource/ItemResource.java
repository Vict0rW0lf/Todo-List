package com.todo.app.todoapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.todoapp.entity.Item;
import com.todo.app.todoapp.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemResource {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
	
	@PostMapping
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	@PutMapping
	public Item replaceItem(@RequestBody Item item) {
		return itemService.replaceItem(item);
	}
	
	@PatchMapping
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
	
	@DeleteMapping
	public void deleteItembyId(long id) {
		itemService.deleteItemById(id);
	}
	
	@DeleteMapping("/all")
	public void deleteAll() {
		itemService.deleteAll();
	}
	
}
