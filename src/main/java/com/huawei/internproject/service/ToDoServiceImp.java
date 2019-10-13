package com.huawei.internproject.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.internproject.model.Todo;
import com.huawei.internproject.model.User;
import com.huawei.internproject.repository.ToDoRepository;
import com.huawei.internproject.repository.UserRepository;

@Service
public class ToDoServiceImp implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	@Autowired
	private UserRepository userRepository;

	List<Todo> todos;

	@Override
	public List<Todo> findAll(Long userId) {
		Optional<User> currentUser= userRepository.findByUserId(userId);
		if(currentUser.isPresent()) {

			return currentUser.get().getTodos();
		} else {
			return null;
		}
		
	}

	@Override
	public Todo findOne(Long id, Long userId) {
		
		Optional<User> currentUser = userRepository.findByUserId(userId);

		if (currentUser.isPresent()) {

			
			  userId= currentUser.get().getUserId();
			  return toDoRepository.findOne(id);
			
			
		} else {
			
		}

		return null;
	}
	

	@Override
	public Todo addTodo(Todo newTodo, Long userId) {

		Optional<User> currentUsers=userRepository.findByUserId(userId);
		

		if (currentUsers.isPresent()) {

			
			userId= currentUsers.get().getUserId();
			newTodo.setUser(currentUsers.get());
			return toDoRepository.save(newTodo);
			
		} else {
			// TODO exception handling throw something
		}

		return null;
	}

	@Override
	public Todo deleteTodo(Long id, Long userId) {
		
		Optional<User> currentUser = userRepository.findByUserId(userId);
		
		if (currentUser.isPresent()) {

			
			  userId= currentUser.get().getUserId();
			  toDoRepository.delete(id);
			  return null;
			
			
		} else {
			
		}

		return null;
	}

	@Override
	public Todo updateTodo(Todo currentTodo, Long userId, Long id) {
		
		Optional<User> currentUser = userRepository.findByUserId(userId);
		Optional<Todo> todos = toDoRepository.findById(id);
		
		if (currentUser.isPresent()) {

			
			userId= currentUser.get().getUserId();
			id= todos.get().getId();
			currentTodo.setUser(currentUser.get());
			return toDoRepository.save(currentTodo);
			  
			
			
			
		} else {
			
		}

		return null;
	}

}
