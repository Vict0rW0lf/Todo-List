package com.todo.app.todoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.app.todoapp.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
