package com.fbm.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fbm.dao.MessageDao;
import com.fbm.dao.impl.MessageDaoImpl;
import com.fbm.vo.Message;

public class MessageDaoImplTest {
	MessageDao dao = new MessageDaoImpl();

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIdByToFrom() {
		System.out.println(dao.findByIdByToFrom(101l, 99l));
	}

	@Test
	public void testFindByIdTo() {
		System.out.println(dao.findByIdTo(100l));
	}

	@Test
	public void testUpdateMessage() {
		Message message = dao.findById(18l);
		message.setIsRead(false);
		dao.update(message);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Message message = new Message();
		message.setToUser(101l);
		message.setFromUser(100l);
		message.setDate(new Timestamp(new java.util.Date().getTime()));
		message.setContext("你好啊！");
		dao.add(message);
	}

	@Test
	public void testGetUnReadMessage() {
		System.out.println(dao.getUnReadMessage(101l));
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalStudentNumber() {
		System.out.println(dao.getTotalStudentNumber(101l));
	}

	@Test
	public void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPage() {
		System.out.println(dao.getPage(1, 101l, null));
	}

	@Test
	public void testBatchListOfMessage() {
		List<Message> list = new ArrayList<Message>();
		Message message = null;
		for (int i = 0; i < 10; i++) {
			message = new Message();
			message.setToUser(100l);
			message.setIsRead(false);
			message.setFromUser(286l);
			message.setDate(new Timestamp(new java.util.Date().getTime()));
			message.setContext("hello！" + i);
			list.add(message);
		}
		dao.batch(list);
	}

}
