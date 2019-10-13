package com.huawei.internproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.internproject.model.Todo;
import com.huawei.internproject.service.ToDoService;


@RestController
@RequestMapping("/api")
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
		
	@GetMapping(value= "/user/{userId}/todos")
	public List<Todo> getTodos(@PathVariable Long userId) {
		
		List<Todo> todo= toDoService.findAll(userId);
		return todo;
		}
	
	@GetMapping(value="/user/{userId}/todo/{id}")
	public Todo FindOne(@PathVariable Long id, @PathVariable Long userId) {
		Todo todo=toDoService.findOne(id, userId);
		return todo;
	}
	
	@PostMapping(value= "/user/{userId}/todos")
	public Todo addTodo(@RequestBody Todo newTodo, @PathVariable Long userId) {
		
		Todo todo =toDoService.addTodo(newTodo, userId);
		return todo;
	}
	
	@DeleteMapping(value="/user/{userId}/todo/{id}")
	public Todo deleteTodo(@PathVariable Long id, @PathVariable Long userId) {
		
		Todo todo= toDoService.deleteTodo(id, userId);
		return todo;
	}
	
	@PutMapping(value="/user/{userId}/todo/{id}")
	public Todo updateTodo(@RequestBody Todo currentTodo, @PathVariable("userId") Long userId, @PathVariable("id") Long id) {
		
		Todo todo= toDoService.updateTodo(currentTodo, userId, id);
		return todo;
	}

}


	
	
	

	

	
	
	
	
  



