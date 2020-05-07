package com.himalaya.aqua.aqua.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.User;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.repository.RoleRepository;
import com.himalaya.aqua.aqua.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Long save(User user) throws HimalayaAquaException {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
		return userRepository.save(user).getId();
	}

	@Override
	public User findByUsername(String username) throws HimalayaAquaException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new HimalayaAquaException("The specified user not found");
		}
		return user;
	}
}
