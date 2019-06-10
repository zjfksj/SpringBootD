package com.zj.service;

import java.util.List;

import com.zj.entity.Stauts;
import com.zj.entity.TbQing;

public interface TbQingService {
 
	List<TbQing> findUserByPage1(int i, int size, String username, String stauts, String start, String end);

	TbQing selectUsername(String username); 

	int soucount1(String username, String stauts, String start, String end);

	int delQing(String qingNo);
 
	TbQing selectTbQing(String qingNo);

	int qingEdit(String qingNo, String stauts);

	List<Stauts> selectStauts();

	int plupdQing(String[] messageid, String stautsT);

}