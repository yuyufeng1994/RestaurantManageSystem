package com.fbm.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.DishTypeDao;
import com.fbm.vo.DishType;

public class DishTypeDaoImpl extends BaseDAOImpl<DishType> implements
		DishTypeDao {

	@Override
	public DishType getById(Integer id) {
		String sql = "select id,name from dish_type where id = ?";
		return query(sql, id);
	}

	@Override
	public void add(DishType dishType) {
		String sql = "insert into dish_type(name) values(?)";
		Long id = insert(sql, dishType.getName());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from dish_type where id = ?";
		update(sql, id);
	}

	@Override
	public List<DishType> getList() {
		String sql = "SELECT id,name FROM dish_type";
		return queryForList(sql);
	}

	@Override
	public BigDecimal getDishTypeSale(Integer id) {
		String sql="SELECT sum(sale) from dish where type_id = ?";
		return getSingleVal(sql, id);
	}

	

}
