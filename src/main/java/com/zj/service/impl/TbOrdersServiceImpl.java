package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.TbOrders;
import com.zj.mapper.TbOrdersMapper;
import com.zj.service.TbOrdersService;

@Service
public class TbOrdersServiceImpl implements TbOrdersService {
	
	@Resource
	TbOrdersMapper tbOrdersMapper;

	@Override
	public List<TbOrders> findUserByPage1(int i, int size, String username, String accurate) {
		return tbOrdersMapper.findUserByPage1(i,size,username,accurate);
	}

	@Override
	public int soucount1(String username, String accurate) {
		return tbOrdersMapper.soucount1(username,accurate);
	}
	
}
