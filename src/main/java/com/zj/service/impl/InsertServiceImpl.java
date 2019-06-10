package com.zj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.entity.TbEnterprise;
import com.zj.entity.TbGoods;
import com.zj.entity.TbOrders;
import com.zj.entity.TbOrdersdetails;
import com.zj.entity.TbParam;
import com.zj.entity.TbPay;
import com.zj.entity.TbQing;
import com.zj.entity.TbWaybill;
import com.zj.entity.User;
import com.zj.mapper.InsertMapper;
import com.zj.service.InsertService;



/**
 * @ClassName: UsersService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-18 上午8:54:16 * *
 */
@Service
public class InsertServiceImpl implements InsertService{

	@Resource InsertMapper insertMapper;
	
	public int add2(String cbecodeinsp,String cbename,String type,String audit_type,String stauts,String person,String create_time)

	{
		
		
		return insertMapper.add2(cbecodeinsp, cbename, type, audit_type, stauts, person, create_time);
		
	}

	@Override
	public int add3(TbEnterprise t) {
		// TODO Auto-generated method stub
		System.out.println("Service层的"+t.toString());
		return insertMapper.add3(t);
	}

	@Override
	public int listadd3(List<TbEnterprise> T) {
	
		for (TbEnterprise tbEnterprise : T) {
			System.out.println("serviceceng"+tbEnterprise);
		}
		
		
		return insertMapper.listadd3(T);
	}

	@Override
	public TbOrders findByOrderNo(String orderNumber) {
		// TODO Auto-generated method stub
		return insertMapper.findByOrderNo(orderNumber);
	}

	@Override
	public List<TbOrdersdetails> finddetilsByOrderNo(String orderNo) {
		System.out.println("servicedasdas他的大小"+insertMapper.finddetilsByOrderNo(orderNo));
		return insertMapper.finddetilsByOrderNo(orderNo);
	}

	@Override
	public
	List<TbParam>  findByType (String mame)
	{
		System.out.println(mame);
		return insertMapper.findByType(mame);
	}

	@Override
	public List<TbParam> findByTypejishu(String name) {
		// TODO Auto-generated method stub
		return insertMapper.findByTypejishu(name);
	}

	@Override
	public int addqing(TbQing q) {
		// TODO Auto-generated method stub
		return insertMapper.addqing(q);
	}

	@Override
	public int insertgoods(String one,String two) {
		// TODO Auto-generated method stub
		return insertMapper.insertgoods(one,two);
	}

	@Override
	public int addgood(TbGoods goods) {
		// TODO Auto-generated method stub
		return insertMapper.addgood(goods);
	}

	@Override
	public int insertorder(TbOrders TbOrders) {
		// TODO Auto-generated method stub
		return insertMapper.insertorder(TbOrders);
	}

	@Override
	public int insertorderdetails(TbOrdersdetails TbOrders) {
		// TODO Auto-generated method stub
		return insertMapper.insertorderdetails(TbOrders);
	}

	@Override
	public int inserttbwaybill(TbWaybill Tbwaybill) {
		return insertMapper.inserttbwaybill(Tbwaybill);
	}

	@Override
	public int insertparam(TbParam tbParam) {	
		return insertMapper.insertparam(tbParam);
	}

	@Override
	public int insertGoods(TbGoods tbParam) {
		// TODO Auto-generated method stub
		return insertMapper.insertGoods(tbParam);
	}

	@Override
	public int insertpaybill(TbPay Tbwaybill) {
		// TODO Auto-generated method stub
		return insertMapper.insertpaybill(Tbwaybill);
	}


	
}
