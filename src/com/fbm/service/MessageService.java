package com.fbm.service;


import com.fbm.vo.Message;
import com.fbm.web.Page;

public interface MessageService {
	Page<Message> getMessageList(int n, Long to);

	Message getMessage(Long to);
	Message getMessageById(Long id);
	Message getMessage(Long to, Long from);

	Long sendMessage(Long id, Long id2, String context);

	Message getBackMessageById(Long id);

	long getMessageNum(Long id);

	long  sendMessageToAll(Long id, String context);
}
