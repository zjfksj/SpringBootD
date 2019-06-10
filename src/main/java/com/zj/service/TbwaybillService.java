package com.zj.service;

import java.util.List;

import com.zj.entity.TbOrders;
import com.zj.entity.TbWaybill;

public interface TbwaybillService {

	List<TbWaybill> findUserByPage1(int i, int size, String username, String accurate);

	int soucount1(String username, String accurate);
	
}
