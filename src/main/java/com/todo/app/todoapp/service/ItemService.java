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
	
	
}
