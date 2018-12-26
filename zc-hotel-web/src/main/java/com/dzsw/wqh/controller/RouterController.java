package com.dzsw.wqh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class RouterController
{

	@GetMapping("/login")
	public String loginUi()
	{
		return "login";
	}

	@GetMapping("/register")
	public String registerUi()
	{
		return "register";
	}

	@GetMapping("/index")
	public String indexUi()
	{
		return "index";
	}

	@GetMapping("/mainPage")
	public String mainPage()
	{
		return "mainPage";
	}


	@GetMapping("/list")
	public String list()
	{
		return "list";
	}


	@GetMapping("/search")
	public String search()
	{
		return "search";
	}
}
