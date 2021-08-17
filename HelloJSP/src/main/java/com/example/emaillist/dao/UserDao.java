package com.example.emaillist.dao;

import com.example.emaillist.vo.UserVo;

public interface UserDao {
	public int insert(UserVo vo);	
	public UserVo getUserByEmailAndPassword(String email, String password);
}
