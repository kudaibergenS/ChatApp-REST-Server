package com.sanzhar.chatappserver.service;

import com.sanzhar.chatappserver.model.Message;
import com.sanzhar.chatappserver.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public List<Message> listDialogMessages(int userId, int senderId) {

        return messageRepository.listDialogMessages(userId, senderId);
    }

    @Transactional
    public void createMessage(int user_id, int sender_id, String text) {
        Message message = new Message();
        message.setMessage_text(text);
        message.setUser_id(user_id);
        message.setSender_id(sender_id);

        messageRepository.createMessage(message);
    }
}
