package com.fbm.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fbm.dao.DishDao;
import com.fbm.dao.MessageDao;
import com.fbm.dao.TradeDao;
import com.fbm.dao.TradeItemDao;
import com.fbm.dao.UserDao;
import com.fbm.dao.impl.DishDaoImpl;
import com.fbm.dao.impl.MessageDaoImpl;
import com.fbm.dao.impl.TradeDaoImpl;
import com.fbm.dao.impl.TradeItemDaoImpl;
import com.fbm.dao.impl.TradeStateDaoImpl;
import com.fbm.dao.impl.UserDaoImpl;
import com.fbm.exception.DishStockNotEnoughException;
import com.fbm.service.TradeService;
import com.fbm.vo.Dish;
import com.fbm.vo.Message;
import com.fbm.vo.Trade;
import com.fbm.vo.TradeItem;
import com.fbm.vo.TradeState;
import com.fbm.vo.User;
import com.fbm.web.Cart;
import com.fbm.web.CartItem;
import com.fbm.web.DateSale;
import com.fbm.web.Page;

public class TradeServiceImpl implements TradeService {
	TradeDao tradeDao = new TradeDaoImpl();
	TradeItemDao tradeItemDao = new TradeItemDaoImpl();
	DishDao dishdao = new DishDaoImpl();
	MessageDao messageDao = new MessageDaoImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public void addTradeList(Cart cart, Long id, Integer tableId)
			throws DishStockNotEnoughException {
		List<CartItem> cartItemList = cart.getItems();
		Trade trade = new Trade();
		trade.setDate(new Timestamp(new java.util.Date().getTime()));
		trade.setCustomer_table(tableId);
		trade.setPrice(cart.getTotalMoney());
		trade.setDish_num(cart.getTotalNumber());
		trade.setState(1);
		trade.setUserId(id);
		Long tradeId = tradeDao.add(trade);
		for (CartItem c : cartItemList) {
			TradeItem tradeItem = new TradeItem();
			tradeItem.setDishId(c.getDish().getId());
			tradeItem.setQuantity(c.getQuantity());
			tradeItem.setTradeId(tradeId);
			tradeItemDao.add(tradeItem);
			Dish dish = dishdao.findById(c.getDish().getId());
			dish.setSale(dish.getSale() + c.getQuantity());
			dish.setStock(dish.getStock() - c.getQuantity());
			if(dish.getStock() <= 0){
				// 当库存不足的时候对经理警醒提示
					List<User> users = userDao.getList();
					for (User u : users) {
						if (u.getType() == 5) {
							Message message = new Message();
							message.setContext("<b>编号为 " + dish.getId() + "  的 "
									+ dish.getName()
									+ " 库存不足，请注意!</b>");
							message.setDate(new Timestamp(new java.util.Date()
									.getTime()));
							message.setFromUser(10086l);
							message.setToUser(u.getId());
							messageDao.add(message);
						}
					}
				
			}
			if (dish.getStock() < 0) {
				throw new DishStockNotEnoughException();
			}
			dishdao.update(dish);
		}

	}

	@Override
	public Page<Trade> getPage(int pageNo, Integer state) {

		Page<Trade> page = tradeDao.getPage(pageNo, state);
		if (page.getList() != null) {
			for (Trade t : page.getList()) {
				t.setTradeState(TradeStateDaoImpl.getById(t.getState()));
				t.setUser(userDao.findById(t.getUserId()));
			}
		}

		return page;
	}

	@Override
	public Trade getTrade(Long tradeId) {
		Trade trade = tradeDao.findById(tradeId);
		trade.setTradeState(TradeStateDaoImpl.getById(trade.getState()));
		trade.setUser(userDao.findById(trade.getUserId()));
		return trade;
	}

	@Override
	public Cart getTradeInfoToCart(Long tradeId) {
		List<TradeItem> tradeItems = tradeItemDao.getList(tradeId);
		Dish dish = null;
		Dish dish2 = new Dish();
		dish2.setName("该菜品已被删除");
		Cart cart = new Cart();
		for (TradeItem t : tradeItems) {
			dish = dishdao.findById(t.getDishId());

			for (int i = 0; i < t.getQuantity(); i++) {
				if (dish != null) {
					cart.addDish(dish);
				} else {
					cart.addDish(dish2);
				}
			}

		}

		return cart;
	}

	@Override
	public String changeState(Long id) {
		Trade trade = tradeDao.findById(id);
		if(trade.getState() < 4)
		trade.setState(trade.getState() + 1);
		tradeDao.update(trade);
		
		Integer state = trade.getState();
		return TradeStateDaoImpl.getById(state).getStr();
	}

	@Override
	public List<DateSale> getDSales() {

		List<DateSale> dateSales = new ArrayList<DateSale>();
		Calendar ca = Calendar.getInstance();
		// ca.set(Calendar.DAY_OF_MONTH, 12);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		String pat_time = "yyyy年MM月dd日";
		SimpleDateFormat aFormat = new SimpleDateFormat(pat_time);
		ca.add(Calendar.DAY_OF_MONTH, -6);
		for (int i = 0; i <= 6; i++) {
			DateSale dateSale = new DateSale();
			// ca.set(Calendar.DAY_OF_MONTH, i);
			// ca.add(Calendar.DAY_OF_MONTH, 0);
			java.util.Date date1 = ca.getTime();
			ca.add(Calendar.DAY_OF_MONTH, 1);
			java.util.Date date2 = ca.getTime();
			double dayS = 0;
			try {
				dayS = tradeDao.getUserDaySalary(
						new Timestamp(date1.getTime()),
						new Timestamp(date2.getTime()));
			} catch (Exception e) {
			}
			String dateNow = aFormat.format(date1);
			dateSale.setDate(dateNow);
			dateSale.setMoney(dayS);
			dateSales.add(dateSale);
		}

		return dateSales;
	}

	@Override
	public List<DateSale> getMSales() {
		List<DateSale> dateSales = new ArrayList<DateSale>();
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.SECOND, 0);
		// ca.set(Calendar.MINUTE, 0);
		String pat_time = "HH时mm分";
		SimpleDateFormat aFormat = new SimpleDateFormat(pat_time);
		ca.add(Calendar.MINUTE, -6);
		for (int i = 0; i <= 6; i++) {
			DateSale dateSale = new DateSale();
			// ca.set(Calendar.MINUTE, i);
			// ca.add(Calendar.MINUTE, 0);
			java.util.Date date1 = ca.getTime();
			ca.add(Calendar.MINUTE, 1);
			java.util.Date date2 = ca.getTime();
			// System.out.println(date1+"\n"+date2);
			double dayS = 0;
			try {
				dayS = tradeDao.getUserDaySalary(
						new Timestamp(date1.getTime()),
						new Timestamp(date2.getTime()));
			} catch (Exception e) {
			}
			String dateNow = aFormat.format(date1);
			dateSale.setDate(dateNow);
			dateSale.setMoney(dayS);
			dateSales.add(dateSale);
		}

		return dateSales;
	}

	// public static void main(String[] args) {
	// System.out.println(new TradeServiceImpl().getMSales());
	// }
}
