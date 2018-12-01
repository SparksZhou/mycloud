package com.zhoujin.yonghu.service.impl;

import com.zhoujin.commons.entity.User;
import com.zhoujin.yonghu.dao.UserDao;
import com.zhoujin.yonghu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

}
