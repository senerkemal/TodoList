package com.huawei.internproject.service;

import java.util.List;
import com.huawei.internproject.model.Todo;


public interface ToDoService {

	List<Todo> findAll(Long userId);

	Todo findOne(Long id, Long userId);

	Todo addTodo(Todo newTodo, Long userId);

	Todo deleteTodo(Long id, Long userId);

	Todo updateTodo(Todo currentTodo, Long userId, Long id);
	

}
