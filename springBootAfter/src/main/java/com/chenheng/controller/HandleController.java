package com.chenheng.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chenheng.entity.MyUser;
import com.chenheng.service.HandleService;

import java.util.Map;

@RestController
@CrossOrigin //跨域访问
public class HandleController {
	@Autowired
	private HandleService handleService;
	@PostMapping(value = "/register")
	public String register(@RequestBody MyUser myUser) {
		return handleService.register(myUser);
	}
	@PostMapping(value = "/login")
	public String login(@RequestBody MyUser myUser,  HttpSession session) {
		return handleService.login(myUser, session);
	}
	@GetMapping(value = "/selectAllUserByPage")
	public Map<String, Object> selectAllUserByPage(int currentPage) {
		return handleService.selectAllUserByPage(currentPage);
	}
}
