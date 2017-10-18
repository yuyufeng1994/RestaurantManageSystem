package com.fbm.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fbm.vo.Trade;

import com.fbm.web.Page;

public interface TradeDao {
	// 通过id查找用户
	Trade findById(Long id);

	// 更新
	void update(Trade trade);

	// 删除
	void delete(Long id);

	// 增加
	Long add(Trade trade);

	// 得到所以用户列表
	List<Trade> getList();

	// ===============为分页做准备 如有需要需写上===================

	// 得到总的用户数量
	long getTotalStudentNumber(Integer state);

	// 得到某页的用户列表
	List<Trade> getPageList(int n, int pageSize,Integer state);

	// 得到某页
	Page<Trade> getPage(int n,Integer state);
	
	//得到某个用户某月的业绩 
	Double getUserMonthSalary(Long id, Date dateFrom,Date dateTo);
	//得到某天的业绩 
	Double getUserDaySalary(Date dateFrom,Date dateTo);

	double getUserDaySalary(Timestamp timestamp, Timestamp timestamp2);
}
