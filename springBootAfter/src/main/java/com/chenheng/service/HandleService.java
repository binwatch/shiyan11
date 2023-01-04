package com.chenheng.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.chenheng.entity.MyUser;

import java.util.Map;

public interface HandleService {
	public String register(MyUser myUser);
	public String login(MyUser myUser, HttpSession session);
	public Map<String, Object> selectAllUserByPage(int currentPage);
}
