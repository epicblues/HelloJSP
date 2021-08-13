package com.example.emaillist.dao;

import java.util.List;

import com.example.emaillist.vo.EmailVO;

public interface EmaillistDao {
	public List<EmailVO> getList();
	public int insert(EmailVO vo);
	public int delete(Long pk);
	public int update(EmailVO vo);
}
