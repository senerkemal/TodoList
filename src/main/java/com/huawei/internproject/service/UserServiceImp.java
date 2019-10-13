package com.huawei.internproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huawei.internproject.model.User;
import com.huawei.internproject.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	
	List<User> users;
	
    @Override
    public List<User> findAll() {
    	
    	return (List<User>) userRepository.findAll();
    	
    }
    
	@Override
	public User findOne(Long userId) {
		return userRepository.findOne(userId);
	}
    
    
    @Override
    public User addUser(User user) {
    	return userRepository.save(user);
    }
    
    @Override
    public User deleteUser(Long userId) {
    	
    	
    	userRepository.delete(userId);
    	return null; 
    }
    
    @Override
    public User updateUser(User user) {
    	return userRepository.save(user);
    }
    


}
