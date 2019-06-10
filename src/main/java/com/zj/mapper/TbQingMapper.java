package com.zj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.entity.Stauts;
import com.zj.entity.TbQing;
import com.zj.entity.User;

public interface TbQingMapper {

	List<TbQing> findUserByPage1(int i, int size, @Param("username")String username,@Param("stauts")String stauts, @Param("start")String start, @Param("end")String end);

	TbQing selectUsername(String username);

	int soucount1(@Param("username")String username,@Param("stauts")String stauts,  @Param("start")String start, @Param("end")String end);

	int delQing(String qingNo);

	TbQing selectTbQing(String qingNo);
 
	int qingEdit(String qingNo, @Param("stauts")String stauts);

	List<Stauts> selectStauts();

	int plupdQing(@Param("messageid") String[] messageid,@Param("stauts") String stautsT);

}