package com.huawei.internproject.service;

import java.util.List;
import com.huawei.internproject.model.User;

public interface UserService {
	List<User> findAll();
	User findOne(Long userId);
	User addUser(User user);
	User deleteUser(Long userId);
	User updateUser(User user);
	
}
