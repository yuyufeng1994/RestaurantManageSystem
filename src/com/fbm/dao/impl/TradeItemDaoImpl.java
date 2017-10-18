package com.fbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fbm.base.BaseDAOImpl;

import com.fbm.dao.TradeItemDao;

import com.fbm.vo.TradeItem;
import com.fbm.web.DishTypeSale;

public class TradeItemDaoImpl extends BaseDAOImpl<TradeItem> implements TradeItemDao{

	@Override
	public TradeItem findById(Long id) {
		String sql = "select id,tradeId,quantity,dishId from Trade_item where id = ?";
		return query(sql, id);
	}


	@Override
	public void update(TradeItem trade_item) {
		String sql = "update trade_item set tradeId=?,quantity=?,dishId=? where id = ?";
		update(sql, trade_item.getTradeId(), trade_item.getQuantity(), trade_item.getDishId(),
				 trade_item.getId());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from trade_item where tradeId = ?";
		update(sql, id);
		
	}

	@Override
	public Long add(TradeItem tradeItem) {
		String sql = "insert into Trade_item(tradeId,quantity,dishId) "
				+ "values(?,?,?)";
		Long id = insert(sql, tradeItem.getTradeId(),tradeItem.getQuantity(),tradeItem.getDishId());
		return id;
	}

	@Override
	public List<TradeItem> getList(Long id) {
		String sql = "select id,tradeId,quantity,dishId from Trade_item where tradeId = ?";
		return queryForList(sql,id);
	}


	
}
