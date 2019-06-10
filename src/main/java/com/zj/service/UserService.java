package com.zj.service;

import com.zj.entity.User;



/**
 * @ClassName: UsersService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-18 上午8:54:16 * *
 */
public interface UserService {


	User login(String name, String pwd);

}
