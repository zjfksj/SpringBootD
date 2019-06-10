package com.zj.mapper;

import com.zj.entity.User;

/**
 * @ClassName: UsersMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-11 下午5:43:18 * *
 */
public interface UserMapper{
	public User login(String name,String pwd);
}
