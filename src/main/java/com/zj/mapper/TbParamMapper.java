package com.zj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.entity.TbParam;

public interface TbParamMapper {

	TbParam selectParam(String id);

	int soucount1(@Param("username")String username,@Param("stauts") String stauts);

	List<TbParam> findUserByPage1(int i, int size,@Param("username")String username, @Param("stauts")String stauts);

	int paramEdit(String id, String paramType, String paramCode, String paramValue, String idString);

	int delParam(String id);

	int pldelParam(String[] messageid);

	int addParam(String id, String paramType, String paramCode, String paramValue, String d3dDrawImage);
}