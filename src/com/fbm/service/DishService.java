package com.fbm.service;

import java.util.List;

import com.fbm.vo.Dish;
import com.fbm.vo.DishType;
import com.fbm.web.DishTypeSale;
import com.fbm.web.Page;

public interface DishService {
	Page<Dish> getPage(int n, String condition,String likeStr);
	
	List<DishType> getDishList();

	void addBook(String name, Integer type_id, Float price, String picture,
			Long sale, Integer stock, String description);

	Dish getDishById(Long id);

	void eidtBook(Long id, String name, Integer type_id, Float price,
			String picture, Long sale, Integer stock, String description);

	void deleteBook(Long id);

	Integer changeStock(Long id, Integer stock);

	Boolean checkStock(Long id, Integer stockNum);
	List<DishTypeSale> getDishTypeSales();

	List<Dish> getAllDishList();

	List<Dish> getAllDishList(String keyword); 
}
