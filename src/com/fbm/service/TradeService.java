package com.fbm.service;

import java.util.List;

import com.fbm.exception.DishStockNotEnoughException;
import com.fbm.vo.Dish;
import com.fbm.vo.Trade;
import com.fbm.web.Cart;
import com.fbm.web.DateSale;
import com.fbm.web.Page;

public interface TradeService {

	void addTradeList(Cart cart, Long id, Integer tableId) throws DishStockNotEnoughException;

	Page<Trade> getPage(int pageNo,Integer state);

	Trade getTrade(Long tradeId);



	Cart getTradeInfoToCart(Long tradeId);

	String changeState(Long id);
	
	List<DateSale> getDSales();
	List<DateSale> getMSales();
}
