package com.fbm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fbm.dao.impl.TradeDaoImpl;
import com.fbm.dao.impl.TradeItemDaoImpl;
import com.fbm.vo.TradeItem;
import com.fbm.vo.User;

public class Trade_itemDaoImplTest {
	TradeItemDaoImpl trade_itemDao = new TradeItemDaoImpl();
	@Test
	public void testFindById() {
		System.out.println(trade_itemDao.findById(1l));
	}

	@Test
	public void testFindByTradeId() {
		System.out.println(trade_itemDao.findById(1l));
	}

	@Test
	public void testUpdateTrade_item() {
		TradeItem trade_item = new TradeItem();
		trade_item.setId(1l);
		trade_item.setTradeId(1l);
		trade_item.setQuantity(20);
		trade_item.setDishId(1l);
		
		trade_itemDao.update(trade_item);
		System.out.println(trade_itemDao.findById(1l));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		TradeItem trade_item = new TradeItem();
		trade_item.setTradeId(1l);
		trade_item.setQuantity(1);
		trade_item.setDishId(100l);
		trade_itemDao.add(trade_item);
	}

	@Test
	public void testGetList() {
		System.out.println(trade_itemDao.getList(201500008l));
	}
	
	

}
