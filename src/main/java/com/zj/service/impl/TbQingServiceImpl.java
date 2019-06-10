package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.Stauts;
import com.zj.entity.TbQing;
import com.zj.entity.User;
import com.zj.mapper.TbQingMapper;
import com.zj.service.TbQingService;

@Service
public class TbQingServiceImpl implements TbQingService {

	
	@Resource
	TbQingMapper tbQingMapper;
	
	@Override
	public List<TbQing> findUserByPage1(int i, int size, String username,String stauts,String start, String end) {
		return tbQingMapper.findUserByPage1(i,size,username,stauts,start,end);
	}

	@Override
	public TbQing selectUsername(String username) {
		return tbQingMapper.selectUsername(username);
	}

	@Override
	public int soucount1(String username,String stauts,String start, String end) {
		return tbQingMapper.soucount1(username,stauts,start,end);
	}

	@Override
	public int delQing(String qingNo) {
		return tbQingMapper.delQing(qingNo);
	}

	@Override
	public TbQing selectTbQing(String qingNo) {
		return tbQingMapper.selectTbQing(qingNo);
	}

	@Override
	public List<Stauts> selectStauts() {
		return tbQingMapper.selectStauts();
	}

	@Override
	public int qingEdit(String qingNo, String stauts) {
		return tbQingMapper.qingEdit(qingNo,stauts);
	}

	@Override
	public int plupdQing(String[] messageid, String stautsT) {
		return tbQingMapper.plupdQing(messageid,stautsT);
	}

}
