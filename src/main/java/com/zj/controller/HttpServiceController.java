package com.zj.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.resources.compiler;
import com.zj.entity.TbEnterprise;
import com.zj.entity.TbGoods;
import com.zj.entity.TbOrders;
import com.zj.entity.TbOrdersdetails;
import com.zj.entity.TbParam;
import com.zj.entity.TbPay;
import com.zj.entity.TbQing;
import com.zj.entity.TbWaybill;
import com.zj.service.InsertService;
import com.zj.utils.DateUtil;

import jdk.nashorn.internal.ir.BreakableNode;

/**
 * http服务端
 * 
 * @author：WangYuanJun
 * @date：2017年12月21日 下午8:27:08
 */
@RestController
@RequestMapping("/httpService")
public class HttpServiceController {
	
	@Autowired
	InsertService insertService;
	java.util.Date date = new java.util.Date();

	@RequestMapping(value = "/sendPostDataByJson", method = RequestMethod.POST)
	public String sendPostDataByJson(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String requestBody) {
		JSONObject jsonObject = JSONObject.parseObject(requestBody);
		String code = jsonObject.getString("code");
		Integer code1 = Integer.parseInt(code);
		System.out.println(code1);
		System.out.println("当前Code是" + code);
		System.out.println(code.equals("1001"));
		if (code1 == 1001) {
			System.out.println("近来了吗");
			// 入库
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			String n7 = jsonObject.getString("n7");
			TbOrders t = new TbOrders();
			t.setOrdersNo(n1);
			t.setCbename(n2);
			t.setCbecodeinsp(n3);
			Integer n44 = Integer.valueOf(n4);
			t.setGoodsNumber(n44);
			t.setUserName(n5);
			Float n66 = Float.valueOf(n6);
			t.setTotalMoney(n66);
			t.setCreateTime(n7);

			insertService.insertorder(t);
		} else if (code.equals("1002")) {
			// 运单
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			String n7 = jsonObject.getString("n7");
			TbWaybill tbWaybill = new TbWaybill(n1, n2, n3, n4, n5, n6, n7);
			insertService.inserttbwaybill(tbWaybill);
		} else if (code.equals("1003")) {
			TbQing q = new TbQing();

			String orderNo = jsonObject.getString("n2");
			String qINGNo = jsonObject.getString("n1");
			String Waybill_no = jsonObject.getString("n3");
			String Pay_no = jsonObject.getString("n4");
			String goodsname = jsonObject.getString("n5");
			String Create_Time = jsonObject.getString("n6");

			q.setQingNo(qINGNo);
			q.setWaybillNo(Waybill_no);
			q.setPayNo(Pay_no);
			q.setCreateTime(Create_Time);
			q.setOrdersNo(orderNo);

			TbOrders or = insertService.findByOrderNo(orderNo); // 传入订单编号得到订单
			List<TbOrdersdetails> ordersDetailsList = insertService.finddetilsByOrderNo(orderNo);// 传入订单编号得到订单详细
			List<TbParam> byTypeList = insertService.findByType("负面清单");// 查询字典表，返回负面清单的所有
			boolean falg = false;

			for (TbOrdersdetails od : ordersDetailsList) {
				for (TbParam p : byTypeList) {
					if (od.getGoodsName().contains(p.getParamValue())) {

						falg = true;
						break;
					}
				}
				if (falg) {
					break;
				}

			}

			if (falg) {
				q.setStauts("2");
				System.out.println("此时的清单编号是" + q.getStauts());
			}

			else {
				System.out.println("走到这里了");
				List<TbParam> paramsList = insertService.findByTypejishu("自动放行");
				System.out.println(paramsList.get(0));
				System.out.println("走到这里了+++++" + paramsList.get(0).getParamCode());
				int jishu = Integer.parseInt(paramsList.get(0).getParamCode());
				int suijishu = (int) (Math.random() * 100 + 1);
				System.out.println("随基数" + suijishu);
				System.out.println("基数说" + jishu);

				if (suijishu > jishu) {
					q.setStauts("1");
				}

				else {
					q.setStauts("7");

					for (TbOrdersdetails od : ordersDetailsList) {
						TbGoods goods = new TbGoods();
						goods.setGoodsinsp(od.getGoodsinsp());
						int i = 5;
						goods.setCbecodeinsp("" + i++);
						goods.setGoodsNo(od.getGoodsNo());
						goods.setCbename(od.getGoodsName());
						goods.setStauts(q.getStauts());
						goods.setCreateTime(Create_Time);

						System.out.println("是否走到这一行" + goods.getGoodsNo() + goods.getCbename());

						int iI = insertService.insertgoods(goods.getGoodsNo(), goods.getCbename());
						System.out.println("此时的i" + i);
						if (iI == 0) {
							insertService.addgood(goods);
							System.out.println("是否成功");
						}

					}
				}
			}
			insertService.addqing(q);// 上面有setStatus

		} else if (code.equals("1004")) {
			// 运单
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			String n7 = jsonObject.getString("n7");
			TbWaybill tbWaybill = new TbWaybill(n1, n2, n3, n4, n5, n6, n7);
			System.out.println(tbWaybill.toString());
			insertService.inserttbwaybill(tbWaybill);

		} else if (code.equals("1005")) {
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			TbParam tbParam = new TbParam(n1, n2, n3, n4, n5, n6);
			System.out.println(tbParam.toString());
			insertService.insertparam(tbParam);
		} else if (code.equals("1006")) {
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			String n7 = jsonObject.getString("n7");
			String n8 = jsonObject.getString("n8");
			TbGoods tbParam = new TbGoods();

			System.out.println(tbParam.toString());
			insertService.insertGoods(tbParam);
		} else if (code.equals("1008")) {

			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
			String n6 = jsonObject.getString("n6");
			String n7 = jsonObject.getString("n7");
			String n8 = jsonObject.getString("n8");
			TbPay tb = new TbPay(n1, n2, n3, n4, n5, n6, n7, n8);
			System.out.println(tb.toString() + "dasdad");

			insertService.insertpaybill(tb);

		}

		else if (code.equals("1009")) {
			String cString = jsonObject.getString("n");
			String n1 = jsonObject.getString("n1");
			String n2 = jsonObject.getString("n2");
			String n3 = jsonObject.getString("n3");
			String n4 = jsonObject.getString("n4");
			String n5 = jsonObject.getString("n5");
//			Float float1=Float.valueOf(n5);
			String n6 = jsonObject.getString("n6");
			Integer n66 = Integer.valueOf(n6);
			String n7 = jsonObject.getString("n7");
			Float n77 = Float.valueOf(n7);
			String n8 = jsonObject.getString("n8");
			System.out.println(n8);

			TbOrdersdetails tb = new TbOrdersdetails(cString, n1, n2, n3, n4, n5, n66, n77, n8);
			System.out.println(tb.toString() + "dasdad");
			System.out.println(n77);

			insertService.insertorderdetails(tb);

		}

//	        insertService.add2(n1, n2, n3, n4, n5, n6, n7);
//	        insertService.add3(tb);
		/*
		 * 
		 */

		String result = "调用成功：数据是 " + "n1:" + jsonObject.getString("n1") + " n2:" + jsonObject.getString("n2");
		return JSON.toJSONString(result);
	}

}
