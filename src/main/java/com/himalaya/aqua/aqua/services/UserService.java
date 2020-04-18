package com.himalaya.aqua.aqua.services;

import com.himalaya.aqua.aqua.core.entity.User;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;

public interface UserService {
	Long save(User user) throws HimalayaAquaException;

	User findByUsername(String username) throws HimalayaAquaException;
}
