package com.fbm.dao;

import java.util.List;

import com.fbm.vo.TradeItem;
import com.fbm.web.DishTypeSale;

public interface TradeItemDao {
	// 通过id查找
	TradeItem findById(Long id);

	// 更新
	void update(TradeItem trade_item);

	// 删除
	void delete(Long id);

	// 增加
	Long add(TradeItem trade_item);

	// 得到列表
	List<TradeItem> getList(Long id);
	
	
}
