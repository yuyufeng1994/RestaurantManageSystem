package com.fbm.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fbm.dao.MessageDao;
import com.fbm.dao.UserDao;
import com.fbm.dao.impl.MessageDaoImpl;
import com.fbm.dao.impl.UserDaoImpl;
import com.fbm.service.MessageService;
import com.fbm.vo.Message;
import com.fbm.vo.User;
import com.fbm.web.Page;

public class MessageServiceImpl implements MessageService {
	MessageDao messageDao = new MessageDaoImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public Page<Message> getMessageList(int n, Long to) {

		Page<Message> page = messageDao.getPage(n, to, null);
		if(page.getList() != null){
			for (Message m : page.getList()) {
				m.setUserFrom(userDao.findById(m.getFromUser()));
			}

		}
		
		return page;
	}

	@Override
	public Message getMessage(Long to) {
		Message message = messageDao.findByIdTo(to);
		if(message!=null){
			message.setIsRead(true);
			messageDao.update(message);
			message.setUserFrom(userDao.findById(message.getFromUser()));
		}
		

		return message;
	}

	@Override
	public Message getMessage(Long to, Long from) {
		Message message = messageDao.findByIdByToFrom(to, from);
		if (message != null) {
			message.setIsRead(true);
			messageDao.update(message);
			String pat_time = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat aFormat = new SimpleDateFormat(pat_time);
			String dateNow = aFormat.format(message.getDate());
			message.setDateStr(dateNow);
			message.setUserFrom(userDao.findById(message.getFromUser()));
		}
		return message;
	}

	@Override
	public Message getMessageById(Long id) {
		Message message = messageDao.findById(id);
		message.setIsRead(true);
		messageDao.update(message);
		String pat_time = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat aFormat = new SimpleDateFormat(pat_time);
		String dateNow = aFormat.format(message.getDate());
		message.setDateStr(dateNow);
		message.setUserFrom(userDao.findById(message.getFromUser()));
		return message;
	}

	@Override
	public Long sendMessage(Long id, Long id2, String context) {
		Message message = new Message();
		message.setContext(context);
		message.setFromUser(id2);
		message.setToUser(id);
		message.setDate(new Timestamp(new java.util.Date().getTime()));
		return messageDao.add(message);
	}

	@Override
	public Message getBackMessageById(Long id) {
		Message message = messageDao.findById(id);
		String pat_time = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat aFormat = new SimpleDateFormat(pat_time);
		String dateNow = aFormat.format(message.getDate());
		message.setDateStr(dateNow);
		message.setUserFrom(userDao.findById(message.getFromUser()));
		return message;
	}

	@Override
	public long getMessageNum(Long id) {
		return messageDao.getUnReadMessage(id);
	}

	@Override
	public long sendMessageToAll(Long id, String context) {
		List<User> users = userDao.getList();
		for(User u:users){
			Message message = new Message();
			message.setContext(context);
			message.setFromUser(id);
			message.setToUser(u.getId());
			message.setDate(new Timestamp(new java.util.Date().getTime()));
			messageDao.add(message);
		}
		
		return 0l;
	}

}
