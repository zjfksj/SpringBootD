package com.zj.mapper;
import java.util.List;

import com.zj.entity.TbEnterprise;
import com.zj.entity.TbGoods;
import com.zj.entity.TbOrders;
import com.zj.entity.TbOrdersdetails;
import com.zj.entity.TbParam;
import com.zj.entity.TbPay;
import com.zj.entity.TbQing;
import com.zj.entity.TbWaybill;
import com.zj.entity.User;
/**
 * @ClassName: UsersMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-11 下午5:43:18 * *
 */
public interface InsertMapper{
	//字符串方式添加
	public int add2(String cbecodeinsp,String cbename,String type,String audit_type,String stauts,String person,String create_time);
	//对象方式添加
	public int add3(TbEnterprise T);
	
	public int listadd3(List<TbEnterprise> T);
	
		TbOrders	findByOrderNo(String orderNumber);
		List<TbOrdersdetails> finddetilsByOrderNo(String orderNo);
		List<TbParam>  findByType (String mame);
		List<TbParam> findByTypejishu (String name);
		
		int addqing(TbQing q);
		
		           int  insertgoods(String one,String two);
		           
		           int       addgood( TbGoods goods);
		           
		           int  insertorder (TbOrders TbOrders);       
		           int  insertorderdetails (TbOrdersdetails TbOrders); 
		           
		           int  inserttbwaybill (TbWaybill Tbwaybill);       
		           int insertparam(TbParam tbParam);
		           int insertGoods(TbGoods tbParam);
		           int insertwat(TbWaybill t);
		           int  insertpaybill (TbPay Tbwaybill);
}
