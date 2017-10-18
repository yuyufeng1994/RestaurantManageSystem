package com.fbm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fbm.dao.DishDao;
import com.fbm.dao.DishTypeDao;
import com.fbm.dao.MessageDao;
import com.fbm.dao.UserDao;
import com.fbm.dao.impl.DishDaoImpl;
import com.fbm.dao.impl.DishTypeDaoImpl;
import com.fbm.dao.impl.MessageDaoImpl;
import com.fbm.dao.impl.UserDaoImpl;
import com.fbm.service.DishService;
import com.fbm.vo.Dish;
import com.fbm.vo.DishType;
import com.fbm.vo.Message;
import com.fbm.vo.User;
import com.fbm.web.DishTypeSale;
import com.fbm.web.Page;

public class DishServiceImpl implements DishService {

	DishDao dishdao = new DishDaoImpl();
	DishTypeDao dishTypeDao = new DishTypeDaoImpl();
	MessageDao messageDao = new MessageDaoImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public Page<Dish> getPage(int n, String condition, String likeStr) {
		Page<Dish> page = dishdao.getPage(n, condition, likeStr);

		if (page.getList() != null) {
			for (Dish d : page.getList()) {
				d.setDishType(dishTypeDao.getById(d.getType_id()));
			}
		}

		return page;
	}

	@Override
	public List<DishType> getDishList() {
		return dishTypeDao.getList();
	}

	@Override
	public void addBook(String name, Integer type_id, Float price,
			String picture, Long sale, Integer stock, String description) {
		Dish dish = new Dish(name, type_id, price, picture, sale, stock,
				description);
		dishdao.add(dish);
	}

	@Override
	public Dish getDishById(Long id) {
		Dish dish = dishdao.findById(id);
		dish.setDishType(dishTypeDao.getById(dish.getType_id()));
		return dish;
	}

	@Override
	public void eidtBook(Long id, String name, Integer type_id, Float price,
			String picture, Long sale, Integer stock, String description) {
		Dish dish = new Dish(name, type_id, price, picture, sale, stock,
				description);
		dish.setId(id);
		dishdao.update(dish);

	}

	public void deleteBook(Long id) {
		dishdao.delete(id);
	}

	@Override
	public Integer changeStock(Long id, Integer stock) {
		Dish dish = dishdao.findById(id);

		dish.setStock(stock);
		dishdao.update(dish);
		Integer stockNow = dishdao.findById(id).getStock();
		return stockNow;
	}

	@Override
	public Boolean checkStock(Long id, Integer stockNum) {
		Dish dish = dishdao.findById(id);
		int DBscotk = dish.getStock();

		if (DBscotk - stockNum > 0) {
			
			return true;
		}
		return false;

	}

	@Override
	public List<DishTypeSale> getDishTypeSales() {
		List<DishTypeSale> dishTypeSales = new ArrayList<DishTypeSale>();

		for (DishType d : dishTypeDao.getList()) {
			DishTypeSale dishTypeSale = new DishTypeSale();
			dishTypeSale.setDishType(d);
			dishTypeSale.setSale(dishTypeDao.getDishTypeSale(d.getId()));
			dishTypeSales.add(dishTypeSale);
		}
		return dishTypeSales;
	}

	@Override
	public List<Dish> getAllDishList() {
		return dishdao.getList();
	}

	@Override
	public List<Dish> getAllDishList(String keyword) {
		return dishdao.getListByName(keyword);
	}

}
