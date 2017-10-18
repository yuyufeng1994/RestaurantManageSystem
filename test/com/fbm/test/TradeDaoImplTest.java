package com.fbm.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;
import com.fbm.dao.impl.TradeDaoImpl;
import com.fbm.vo.Trade;

public class TradeDaoImplTest {
	TradeDaoImpl tradeDao = new TradeDaoImpl();

	@Test
	public void testFindById() {
		Trade trade = tradeDao.findById(1l);
		System.out.println(trade);
	}

	@Test
	public void testFindByDish_num() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Trade trade = new Trade();
		trade.setDish_num(5);
		trade.setPrice(120.5F);
		trade.setUserId(1l);
		trade.setCustomer_table(1101);
		trade.setDate(new Timestamp(new java.util.Date().getTime()));
		trade.setState(1);
		tradeDao.add(trade);
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalStudentNumber() {
		System.out.println(tradeDao.getTotalStudentNumber(1));
	}

	@Test
	public void testGetPageList() {
		System.out.println(tradeDao.getPageList(1, 10, 1));
	}

	@Test
	public void testGetPage() {
		System.out.println(tradeDao.getPage(1, 1));
	}

	
	@Test
	public void testGeUserSsalay() {
		// = 	new java.util.Date(); 
		//date1.setMonth();
		Calendar ca = Calendar.getInstance(); 

		ca.set(Calendar.YEAR, 2015); 

		ca.set(Calendar.MONTH, 5); 

		ca.set(Calendar.DAY_OF_MONTH, 10); 

		ca.set(Calendar.HOUR_OF_DAY, 0); 

		ca.set(Calendar.MINUTE,0); 

		ca.set(Calendar.SECOND, 0); 

		java.util.Date date1 = ca.getTime(); 
		ca.set(Calendar.YEAR, 2015); 

		ca.set(Calendar.MONTH, 1); 

		ca.set(Calendar.DAY_OF_MONTH, 0); 
		java.util.Date date2 = ca.getTime(); 
		System.out.println(date2);
		//System.out.println(tradeDao.getUserMonthSalary(100l, new Date(date1.getTime()),new Date(date2.getTime())));
	}

}
