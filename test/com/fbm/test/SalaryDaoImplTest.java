package com.fbm.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.fbm.dao.impl.SalaryDaoImpl;
import com.fbm.vo.Salary;

public class SalaryDaoImplTest {
	SalaryDaoImpl salaryDao = new SalaryDaoImpl();

	@Test
	public void testFindById() {
		System.out.println(salaryDao.findById(1l));
	}

	@Test
	public void testFindByUserId() {
		System.out.println(salaryDao.findByUserId("5"));
	}

	@Test
	public void testUpdateSalary() {
		Salary salary = new Salary();
		salary.setId(1l);
		salary.setUserId(100l);
		salary.setSalary(222.2f);
		salary.setDate(new Date(new java.util.Date().getTime()));

		salaryDao.update(salary);
		System.out.println(salaryDao.findById(1l));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Salary salary = new Salary();
		// salary.setId(1l);
		salary.setUserId(100l);
		salary.setSalary(252.2f);
		salary.setDate(new Date(new java.util.Date().getTime()));
		salaryDao.add(salary);
	}

	@Test
	public void testGetList() {
		System.out.println(salaryDao.getList());
	}

	@Test
	public void testgetTotalStudentNumber() {
		System.out.println(salaryDao.getTotalSalaryNumber());
	}

	@Test
	public void testgetPageList() {
		System.out.println();
	}

	@Test
	public void testgetPage() {
		System.out.println(salaryDao.getPage(2));
	}

}
