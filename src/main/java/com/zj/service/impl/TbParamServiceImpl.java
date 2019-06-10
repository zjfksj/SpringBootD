package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.TbParam;
import com.zj.mapper.TbParamMapper;
import com.zj.service.TbParamService;

@Service
public class TbParamServiceImpl implements TbParamService {
	
	@Resource
	TbParamMapper tbParamMapper;

	@Override
	public TbParam selectParam(String id) {
		return tbParamMapper.selectParam(id);
	}

	@Override
	public int soucount1(String username,String stauts) {
		return tbParamMapper.soucount1(username,stauts);
	}

	@Override
	public List<TbParam> findUserByPage1(int i, int size, String username,String stauts) {
		return tbParamMapper.findUserByPage1(i,size,username,stauts);
	}

	@Override
	public int paramEdit(String id, String paramType, String paramCode, String paramValue, String idString) {
		return tbParamMapper.paramEdit(id,paramType,paramCode,paramValue,idString);
	}

	@Override
	public int delParam(String id) {
		return tbParamMapper.delParam(id);
	}

	@Override
	public int pldelParam(String[] messageid) {
		return tbParamMapper.pldelParam(messageid);
	}

	@Override
	public int addParam(String id, String paramType, String paramCode, String paramValue, String d3dDrawImage) {
		return tbParamMapper.addParam(id,paramType,paramCode,paramValue,d3dDrawImage);
	}
}
