package com.fbm.dao.impl;

import java.util.List;

import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.MessageDao;
import com.fbm.vo.Message;
import com.fbm.vo.User;
import com.fbm.web.Page;

public class MessageDaoImpl extends BaseDAOImpl<Message> implements MessageDao {

	@Override
	public Message findById(Long id) {
		String sql = "select id,toUser,fromUser,context,date,isRead from message where id = ?";
		return query(sql, id);
	}

	@Override
	public Message findByIdByToFrom(Long to, Long from) {
		String sql = "select id,toUser,fromUser,context,date,isRead from message where toUser = ? and fromUser = ? and isRead = 0 order by id asc";
		return query(sql, to, from);
	}

	@Override
	public Message findByIdTo(Long to) {
		String sql = "select id,toUser,fromUser,context,date,isRead from message where toUser = ? and isRead = 0 order by id desc";
		return query(sql, to);
	}

	@Override
	public void update(Message message) {
		String sql = "update message set toUser=?,fromUser=?,context=?,date=?,isRead=? where id = ?";
		update(sql, message.getToUser(), message.getFromUser(),
				message.getContext(), message.getDate(), message.getIsRead(),message.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from message where id = ?";
		update(sql, id);
	}

	@Override
	public Long add(Message message) {
		String sql = "insert into message(toUser,fromUser,context,date,isRead) "
				+ "values(?,?,?,?,?)";
		Long id = insert(sql, message.getToUser(), message.getFromUser(),
				message.getContext(), message.getDate(), false);
		return id;
	}

	@Override
	public long getUnReadMessage(Long to) {
		String sql = "SELECT count(id) FROM message Where toUser = ? and isRead=0";
		return getSingleVal(sql,to);
	}

	@Override
	public List<Message> getList() {
		String sql = "select id,toUser,fromUser,context,date,isRead from message";
		return queryForList(sql);
	}

	@Override
	public long getTotalStudentNumber(Long to) {
		String sql = "SELECT count(id) FROM message where toUser = ?";
		return getSingleVal(sql,to);
	}

	@Override
	public List<Message> getPageList(int n, int pageSize, Long to, Long from) {
		String sql = "SELECT id,toUser,fromUser,context,date,isRead "
				+ "FROM message WHERE toUser = ? order by id desc LIMIT ?, ?";
		return queryForList(sql, to,(n - 1) * pageSize, pageSize);
	}

	@Override
	public Page<Message> getPage(int n, Long to, Long from) {
		Page<Message> page = new Page<Message>(n);
		page.setTotalItemNumber(getTotalStudentNumber(to));
		// 校验 pageNo 的合法性
		n = page.getPageNo();
		page.setList(getPageList(n, 10,to,from));
		return page;
	}

	@Override
	public void batch(List<Message> list) {
		String sql = "insert into message(toUser,fromUser,context,date,isRead) "
				+ "values(?,?,?,?,?)";
		Object[][] obj = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			obj[i][0] = list.get(i).getToUser();
			obj[i][1] = list.get(i).getFromUser();
			obj[i][2] = list.get(i).getContext();
			obj[i][3] = list.get(i).getDate();
			obj[i][4] = list.get(i).getIsRead();
		}
		batch(sql, obj);
	}
}
