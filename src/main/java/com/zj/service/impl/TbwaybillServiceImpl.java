package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.TbOrders;
import com.zj.entity.TbWaybill;
import com.zj.mapper.TbWaybillMapper;
import com.zj.service.TbwaybillService;

@Service
public class TbwaybillServiceImpl implements TbwaybillService {
	
	@Resource
	TbWaybillMapper tbWaybillMapper;

	@Override
	public List<TbWaybill>  findUserByPage1(int i, int size, String username,String accurate) {
		return tbWaybillMapper.findUserByPage1(i,size,username,accurate);
	}

	@Override
	public int soucount1(String username,String accurate) {
		return tbWaybillMapper.soucount1(username,accurate);
	}
}
