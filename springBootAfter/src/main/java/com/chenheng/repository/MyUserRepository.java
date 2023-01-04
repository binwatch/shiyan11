package com.chenheng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chenheng.entity.MyUser;

public interface MyUserRepository extends  JpaRepository<MyUser, Integer>{
	public MyUser findByUnameAndUpwd(String uname, String upwd);
}
