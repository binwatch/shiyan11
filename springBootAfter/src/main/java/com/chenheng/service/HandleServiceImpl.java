package com.chenheng.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chenheng.entity.MyUser;
import com.chenheng.repository.MyUserRepository;
@Service
public class HandleServiceImpl implements HandleService{
	@Autowired
	private MyUserRepository myUserRepository;
	@Override
	public String register(MyUser myUser) {
		MyUser u = myUserRepository.save(myUser);
		if(u != null)
			return "ok";
		else
			return "no";
	}

	@Override
	public String login(MyUser myUser, HttpSession session) {
		MyUser u = myUserRepository.findByUnameAndUpwd(myUser.getUname(), myUser.getUpwd());
		if(u != null) {
			session.setAttribute("myuser", u);
			//重定向到控制器某个方法，实现用户查询，查询第一页
			return "ok";
		}
		return "no";
	}

	@Override
	public Map<String, Object> selectAllUserByPage(int currentPage) {
		if(currentPage == 0) {//第一次访问selectAllUserByPage方法时
			currentPage = 1;
		}
		int size = 2;//每页显示2条
		//分页查询，of方法的第一个参数代表第几页（比实际小1），
		//第二个参数代表页面大小，第三个参数代表排序规则
		Page<MyUser> pageData =
				myUserRepository.findAll(PageRequest.of(currentPage-1, size, Sort.by(Direction.DESC, "id")));
		//获得当前页面数据并转换成List<MyUser>，转发到视图页面显示
		List<MyUser> allUser = pageData.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allUser",allUser);
		map.put("totalPage", pageData.getTotalPages());
		map.put("currentPage", currentPage);
		return map;
	}

}
