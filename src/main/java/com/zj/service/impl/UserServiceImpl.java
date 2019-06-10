package com.zj.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.User;
import com.zj.mapper.UserMapper;
import com.zj.service.UserService;


/**
 * @ClassName: UsersServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-18 上午8:54:43 * *
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper usersMapper;

	public User login(String name, String pwd){
		return usersMapper.login(name, pwd);
	}
	
}
