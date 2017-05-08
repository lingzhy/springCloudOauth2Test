package com.lzy.firstpsringgradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.firstpsringgradle.dao.UserRepository;
import com.lzy.firstpsringgradle.entity.User;

@Service
public class UsersService {
	@Autowired
	private UserRepository userRepository;

	public User findUserByName(String name) {
		User user = null;
		user = userRepository.findByUserName(name);
		return user;

	}

	@Transactional
	public int updateUserById(String id) {
		User user = null;
		int x = userRepository.updateByUserId(id);
		System.out.println("x::::::::::::::::::" + x);
		return x;

	}

	@PreAuthorize("hasPermission(#name,'222')")
	public void methodFilterTest(String name)
	{
      
    	
    	
		/* for (User s : users) {
			System.out.println(
					"$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + s.getId() + " & " + s.getName() + " & " + s.getPassword());
		} */
	}

}
