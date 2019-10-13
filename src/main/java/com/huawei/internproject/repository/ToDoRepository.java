package com.huawei.internproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.huawei.internproject.model.Todo;



@Repository
public interface ToDoRepository extends JpaRepository<Todo, Long> {	
	
	Optional<Todo> findById(Long id);
}
