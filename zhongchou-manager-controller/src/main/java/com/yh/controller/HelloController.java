package com.yh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	
	@RequestMapping("/")
	public String hello(){
		
		return "login";
	}
	@RequestMapping("/{url}")
	public String pagehello(@PathVariable String url){
		return url;
	}
	
}
