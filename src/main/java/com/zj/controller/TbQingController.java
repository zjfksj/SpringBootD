package com.zj.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zj.entity.Stauts;
import com.zj.entity.TbQing;
import com.zj.service.TbQingService;
import com.zj.utils.StautsUtil;

@Controller
@RequestMapping("/tbQing/")
public class TbQingController {
	
	@Resource
	TbQingService tbQingService;
	
	StautsUtil stautsUtil=new StautsUtil();
	
	@RequestMapping("/Manual_review")
	public ModelAndView Manual_review(@RequestParam(value="indexPage",required=false,defaultValue="1") int indexPage,
			@RequestParam(value="username",required=false,defaultValue="") String username,
			@RequestParam(value="stauts",required=false,defaultValue="6") String stauts,
			@RequestParam(value="start",required=false,defaultValue="") String start,
			@RequestParam(value="end",required=false,defaultValue="") String end) throws ParseException{
		System.out.println(indexPage+","+username+","+stauts+","+start+","+end);
		ModelAndView mv = new ModelAndView();
		int size = 6;
		List<TbQing> tbQingl = tbQingService.findUserByPage1((indexPage-1)*size, size,username,stauts,start,end);
		System.out.println(tbQingl+"diyi");
		int count = tbQingService.soucount1(username,stauts,start,end);
		System.out.println(count);
		int countPage = count % size == 0 ? count/size : count/size+1;
		if(countPage==0) {
			countPage=1;
		} 
		mv.addObject("tbQingl",tbQingl);
		mv.addObject("countPage", countPage);
		mv.addObject("indexPage", indexPage);
		mv.addObject("count", count);
		mv.addObject("stautsM",stauts);
		mv.addObject("start",start);
		mv.addObject("end",end);
		mv.addObject("username", username);
		mv.setViewName("/admin-list");
		return mv;
	}  
	@RequestMapping("/admin_edit")
	public ModelAndView admin_edit(String qingNo,String stautsM,String text,HttpServletRequest request){
		System.out.println(text+"admin_edit"+stautsM);
		ModelAndView mv = new ModelAndView();
		tbQingService.qingEdit(qingNo, text);
		mv.setViewName("redirect:/tbQing/Manual_review?stauts="+stautsM); 
		return mv;
	}
	@ResponseBody
	@RequestMapping("/plupdQing")
	public String plupdQing(String messageid[],String stautsT,String stautsM,HttpServletRequest request){
		System.out.println("admin_edit"+messageid+",");
		int a=tbQingService.plupdQing(messageid, stautsT);
		return "成功";
	} 
}
