package com.fbm.test;

import java.util.List;

import com.fbm.dao.impl.DishDaoImpl;
import com.fbm.vo.Dish;
import com.fbm.web.Cart;
import com.fbm.web.CartItem;

public class CartTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DishDaoImpl daoImpl = new DishDaoImpl();
		List<Dish> dishList = daoImpl.getList();
		Cart cart = new Cart();
		for(Dish d:dishList){
			cart.addDish(d);
		}
		Dish dish  = daoImpl.findById(58l);
		//System.out.println(cart.getTotalNumber());
		cart.addDish(dish  );
		for(CartItem d:cart.getItems()){
			System.out.println(d.getQuantity()+" "+d.getDish());
		}

		

	}

}
