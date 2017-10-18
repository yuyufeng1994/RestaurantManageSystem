package com.fbm.dao;

import java.util.List;

import com.fbm.vo.Message;
import com.fbm.web.Page;

public interface MessageDao {
		// 通过id查找用户
		Message findById(Long id);

		Message findByIdByToFrom(Long to,Long from);
		
		Message findByIdTo(Long to);
		
		// 更新
		void update(Message message);

		// 删除
		void delete(Long id);

		
		
		// 增加
		Long add(Message message);
		
		
		long getUnReadMessage(Long to);
		
		//得到所以用户列表
		List<Message> getList();

		// ===============为分页做准备 如有需要需写上===================

		// 得到总的用户数量
		long getTotalStudentNumber(Long to);

		List<Message> getPageList(int n, int pageSize,Long to,Long from);

		// 得到某页
		Page<Message> getPage(int n,Long to,Long from);
		
		void batch(List<Message> list);
}
