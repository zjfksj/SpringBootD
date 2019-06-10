package com.zj.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zj.entity.TbParam;
import com.zj.service.TbParamService;
import com.zj.utils.DateUtil;

@Controller
@RequestMapping("/tbParam/")
public class TbParamController {

	@Resource
	TbParamService tbParamService;
	
	@RequestMapping("/selectParam")
	public ModelAndView Manual_review(@RequestParam(value="indexPage",required=false,defaultValue="1") int indexPage,
			@RequestParam(value="username",required=false,defaultValue="") String username,
			@RequestParam(value="stauts",required=false,defaultValue="0") String stauts,HttpServletRequest request) throws ParseException{
		System.out.println(indexPage+","+username+","+stauts);
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		int size = 6;
		String stauts2="";
		List<TbParam> tbParam = tbParamService.findUserByPage1((indexPage-1)*size, size,username,stauts);
		System.out.println(tbParam+"diyi");
		int count = tbParamService.soucount1(username,stauts);
		System.out.println(count);
		int countPage = count % size == 0 ? count/size : count/size+1;
		if(countPage==0) {
			countPage=1;
		} 
		mv.addObject("tbParams",tbParam);
		mv.addObject("countPage", countPage);
		mv.addObject("indexPage", indexPage);
		mv.addObject("count", count);
		session.setAttribute("stautsp", stauts);
		mv.addObject("username", username);
		mv.setViewName("/automatictrialscalemaintenance-list");
		return mv;
	}
	  @RequestMapping("/paramEdit") 
	  public ModelAndView paramEdit(String id ,HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		TbParam tbParam=tbParamService.selectParam(id);
		mv.addObject("tbParam", tbParam);
		session.setAttribute("tbParamid", id);
		mv.setViewName("/param-edit");
		return mv;
	 }
	  @RequestMapping("/paramAdd") 
	  public String paramAdd() { 
		return "param-add";
	 }
	  @RequestMapping("/addParam") 
	  public String addParam(String id,String paramType,String paramCode,String paramValue,HttpServletRequest request) { 
		HttpSession session=request.getSession();
		String stautsp=(String) session.getAttribute("stautsp");
		Date dd=new Date();
		String D3DDrawImage =DateUtil.dateToStrLong(dd);
		int a=tbParamService.addParam(id,paramType,paramCode,paramValue,D3DDrawImage);
		System.out.println("add"+a);
		return "redirect:/tbParam/selectParam?stauts="+stautsp;
	 }
	  @RequestMapping("/editParam") 
	  public ModelAndView editParam(String id,String paramType,String paramCode,String paramValue,HttpServletRequest request) { 
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		String stautsp=(String) session.getAttribute("stautsp");
		String idString=(String) session.getAttribute("tbParamid");
		tbParamService.paramEdit(id,paramType,paramCode,paramValue,idString);
		mv.setViewName("redirect:/tbParam/selectParam?stauts="+stautsp);
		return mv;
	 }
	  @ResponseBody
	  @RequestMapping("/delParam") 
	  public String  delParam(String id,HttpServletRequest request) { 
		int a= tbParamService.delParam(id);
		return "成功";
	 }
	  @RequestMapping("/pldelParam") 
	  public String  pldelParam(String messageid[],HttpServletRequest request) { 
		HttpSession session=request.getSession();
		String stautsp=(String) session.getAttribute("stautsp");
		int a= tbParamService.pldelParam(messageid);
		return "redirect:/tbParam/selectParam?stauts="+stautsp;
	 }
	  
}
