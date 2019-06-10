package com.zj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zj.entity.TbOrders;
import com.zj.entity.TbWaybill;
import com.zj.service.TbwaybillService;

@Controller
@RequestMapping("/tbWaybill/")
public class TbwaybillController {
	@Resource
	TbwaybillService tbwaybillService;
	
	@RequestMapping("/Waybilllist")
	public ModelAndView Waybilllist(@RequestParam(value="indexPage",required=false,defaultValue="1") int indexPage,
			@RequestParam(value="username",required=false,defaultValue="") String username,
			@RequestParam(value="stauts",required=false,defaultValue="6") String stauts,
			@RequestParam(value="accurate",required=false,defaultValue="") String accurate){
		System.out.println(indexPage+","+username+","+accurate);
		ModelAndView mv = new ModelAndView();
		int size = 6;
		List<TbWaybill> tbWaybillL = tbwaybillService.findUserByPage1((indexPage-1)*size, size,username,accurate);
		System.out.println(tbWaybillL+"diyi");
		int count = tbwaybillService.soucount1(username,accurate);
		System.out.println(count);
		int countPage = count % size == 0 ? count/size : count/size+1;
		if(countPage==0) {
			countPage=1;
		} 
		if(username.length()<1) {
			username=accurate;
		}
		mv.addObject("tbWaybillL",tbWaybillL);
		mv.addObject("countPage", countPage);
		mv.addObject("indexPage", indexPage);
		mv.addObject("count", count); 
		mv.addObject("stautsM", stauts); 
		mv.addObject("username", username);
		mv.setViewName("/Waybill-list");
		return mv;
	}  
	
}	
