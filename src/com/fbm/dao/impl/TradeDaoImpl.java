package com.fbm.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.TradeDao;

import com.fbm.vo.Trade;
import com.fbm.vo.User;

import com.fbm.web.Page;

public class TradeDaoImpl extends BaseDAOImpl<Trade> implements TradeDao {

	@Override
	public Trade findById(Long id) {

		String sql = "select id,dish_num,price,userId,customer_table,date,state from trade where id = ?";
		return query(sql, id);
	}

	@Override
	public void update(Trade trade) {
		String sql = "update trade set dish_num=?,price=?,userId=?,customer_table=?,date=?,state=? where id = ?";
		update(sql, trade.getDish_num(), trade.getPrice(), trade.getUserId(),
				trade.getCustomer_table(), trade.getDate(), trade.getState(),
				trade.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from trade where id = ?";
		update(sql, id);
	}

	@Override
	public Long add(Trade trade) {
		String sql = "insert into trade(dish_num,price,userId,customer_table,date,state) "
				+ "values(?,?,?,?,?,?)";
		Long id = insert(sql, trade.getDish_num(), trade.getPrice(),
				trade.getUserId(), trade.getCustomer_table(), trade.getDate(),
				trade.getState());
		return id;
	}

	@Override
	public List<Trade> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalStudentNumber(Integer state) {
		String sql = null;
		if (state == null) {
			sql = "SELECT count(id) FROM trade";
		} else {
			sql = "SELECT count(id) FROM trade where state < ?";
		}
		return getSingleVal(sql, state);
	}

	@Override
	public List<Trade> getPageList(int n, int pageSize, Integer state) {
		String sql = null;
		if (state == null) {
			sql = "SELECT id,dish_num,price,userId,customer_table,date,state "
					+ "FROM trade order by date desc LIMIT ?, ?";
			return queryForList(sql, (n - 1) * pageSize, pageSize);
		} else {
			sql = "SELECT id,dish_num,price,userId,customer_table,date,state "
					+ "FROM trade where state < ? order by date desc LIMIT ?, ?";

			return queryForList(sql, state, (n - 1) * pageSize, pageSize);
		}

	}

	@Override
	public Page<Trade> getPage(int n, Integer state) {
		Page<Trade> page = new Page<Trade>(n);
		page.setTotalItemNumber(getTotalStudentNumber(state));
		// 校验 pageNo 的合法性
		n = page.getPageNo();
	//	if (page.getTotalPageNumber() != 0) {
			page.setList(getPageList(n, 10, state));
	//	}
		return page;
	}

	@Override
	public Double getUserMonthSalary(Long id, Date dateFrom,Date dateTo) {
		String sql = "select sum(price) from trade where  userId = ? and date > ? and date < ?";
		return getSingleVal(sql, id,dateFrom,dateTo);
	}

	@Override
	public Double getUserDaySalary(Date dateFrom, Date dateTo) {
		String sql = "select sum(price) from trade where date > ? and date < ?";
		return getSingleVal(sql,dateFrom,dateTo);
	}

	@Override
	public double getUserDaySalary(Timestamp dateFrom, Timestamp dateTo) {
		String sql = "select sum(price) from trade where date >= ? and date < ?";
		return getSingleVal(sql,dateFrom,dateTo);
	}

}
