package com.sanzhar.chatappserver.service;


import com.sanzhar.chatappserver.model.Message;

import java.util.List;

public interface MessageService {

    public List<Message> listDialogMessages(int userId, int senderId);
    public void createMessage(int user_id, int sender_id, String text);

}
