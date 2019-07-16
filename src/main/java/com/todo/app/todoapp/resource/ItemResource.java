package com.todo.app.todoapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.todo.app.todoapp.entity.Item;
import com.todo.app.todoapp.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemResource {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
	public Item replaceItem(@RequestBody Item item) {
		return itemService.replaceItem(item);
	}
	
	@PatchMapping
    @ResponseStatus(HttpStatus.OK)
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteItembyId(@PathVariable long id) {
		itemService.deleteItemById(id);
	}
	
	@DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		itemService.deleteAll();
	}
	
}
