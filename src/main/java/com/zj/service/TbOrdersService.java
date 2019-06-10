package com.zj.service;

import java.util.List;

import com.zj.entity.TbOrders;

public interface TbOrdersService {

	List<TbOrders> findUserByPage1(int i, int size, String username, String accurate);

	int soucount1(String username, String accurate);

}
