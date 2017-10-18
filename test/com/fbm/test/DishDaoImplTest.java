package com.fbm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fbm.dao.DishTypeDao;
import com.fbm.dao.impl.DishDaoImpl;
import com.fbm.dao.impl.DishTypeDaoImpl;
import com.fbm.vo.Dish;

public class DishDaoImplTest {

	DishDaoImpl dishdao = new DishDaoImpl();
	DishTypeDao dishTypeDao = new DishTypeDaoImpl();
	@Test
	public void testFindById() {
		System.out.println(dishdao.findById(1l));
	}

	@Test
	public void testFindByName() {
		System.out.println(dishTypeDao.getDishTypeSale(1));
	}

	@Test
	public void testUpdateDish() {
		Dish dish = new Dish();
		dish.setType_id(1);
		dish.setName("111");
		dish.setId(2l);
		dish.setPrice(200f);
		dishdao.update(dish);
	}

	@Test
	public void testDelete() {
		dishdao.delete(3l);
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 25; i++) {
			Dish dish = new Dish();
			dish.setName("test" + i);
			dish.setType_id(1);
			dish.setPicture("images/gbjd.jpg");
			dish.setPrice(78.5F);
			dish.setSale(10l);
			dish.setStock(50);
			dish.setDescription("产品说明！");
			dishdao.add(dish);
		}
	}

	@Test
	public void testGetList() {
		System.out.println(dishdao.getList());
	}

	@Test
	public void testGetTotalStudentNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPageList() {
		System.out.println(dishdao.getPageList(1, 10, "price desc","3123"));
	}

	@Test
	public void testGetPage() {
		System.out.println(dishdao.getPage(1,"price desc","2"));
	}

}


