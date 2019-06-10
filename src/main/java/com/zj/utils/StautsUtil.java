package com.zj.utils;

public class StautsUtil {
	
	public String stauts(String stauts) {
		if(stauts.equals("0")) {
			return "退单";
		}
		else if(stauts.equals("1")){
			return "人工审单";
		}
		else if(stauts.equals("2")){
			return "负面清单";
		}
		else if(stauts.equals("3")){
			return "查验";
		}
		else if(stauts.equals("1")){
			return "禁止处境初审";
		}
		else if(stauts.equals("5")){
			return "禁止处境复审";
		}
		else if(stauts.equals("6")){
			return "禁止处境";
		}
		else if(stauts.equals("7")){
			return "放行";
		}
		return "无状态";
	}
}
