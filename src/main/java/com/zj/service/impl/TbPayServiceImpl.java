package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.TbPay;
import com.zj.mapper.TbPayMapper;
import com.zj.service.TbPayService;

@Service
public class TbPayServiceImpl implements TbPayService {

	
	@Resource
	TbPayMapper tbPayMapper;
	
	@Override
	public List<TbPay> findUserByPage1(int i, int size, String username,String accurate) {
		return tbPayMapper.findUserByPage1(i,size,username,accurate);
	}

	@Override
	public int soucount1(String username,String accurate) {
		return tbPayMapper.soucount1(username,accurate);
	}

}
