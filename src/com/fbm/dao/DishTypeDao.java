package com.fbm.dao;

import java.math.BigDecimal;
import java.util.List;

import com.fbm.vo.DishType;

public interface DishTypeDao {
	
	DishType getById(Integer id);

	void add(DishType dishType);
	
	void delete(Integer id);
	
	List<DishType> getList();
	
	BigDecimal getDishTypeSale(Integer id);
	
}
