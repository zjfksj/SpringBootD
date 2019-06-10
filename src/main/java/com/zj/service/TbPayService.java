package com.zj.service;

import java.util.List;

import com.zj.entity.TbPay;

public interface TbPayService {

	List<TbPay> findUserByPage1(int i, int size, String username, String accurate);

	int soucount1(String username, String accurate);

}
