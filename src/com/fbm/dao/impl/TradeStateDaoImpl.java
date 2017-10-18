package com.fbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fbm.vo.TradeState;

public class TradeStateDaoImpl {
	private static List<TradeState> list = new ArrayList<TradeState>();
	static {
		TradeState e = new TradeState(1, "等待接受..");
		list.add(e);	
		e = new TradeState(2, "制作中...");
		list.add(e);
		e = new TradeState(3, "用餐中..");
		list.add(e);
		e = new TradeState(4, "完成");
		list.add(e);
		e = new TradeState(5, "无效订单");
		list.add(e);
	}

	public static TradeState getById(Integer id) {
		for (TradeState t : list) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;

	}
}
