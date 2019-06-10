package com.zj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.entity.TbPay;

public interface TbPayMapper {

	List<TbPay> findUserByPage1(int i, int size,@Param("username")String username, @Param("accurate")String accurate);

	int soucount1(@Param("username")String username, @Param("accurate")String accurate);
}