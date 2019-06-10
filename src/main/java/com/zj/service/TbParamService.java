package com.zj.service;

import java.util.List;

import com.zj.entity.TbParam;
import com.zj.entity.TbQing;

public interface TbParamService {

	TbParam selectParam(String id);

	int paramEdit(String id, String paramType, String paramCode, String paramValue, String idString);

	int soucount1(String username, String stauts);

	List<TbParam> findUserByPage1(int i, int size, String username, String stauts);

	int delParam(String id);

	int pldelParam(String[] messageid);

	int addParam(String id, String paramType, String paramCode, String paramValue, String d3dDrawImage);

}
