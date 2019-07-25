package com.todo.app.todoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.todoapp.entity.Item;
import com.todo.app.todoapp.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	public List<Item> getAllItems() {
		List<Item> itens = new ArrayList<>();
		
		itemRepo.findAll()
			.forEach(itens::add);
		
		return itens;
	}
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
	public Item replaceItem(Item item) {
		return itemRepo.save(item);
	}
	
	public Item updateItem(Item item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(long id) {
		itemRepo.deleteById(id);
	}

	public void deleteAll() {
		itemRepo.deleteAll();
	}
	
}
