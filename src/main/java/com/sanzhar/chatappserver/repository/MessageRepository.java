package com.sanzhar.chatappserver.repository;


import com.sanzhar.chatappserver.model.Message;

import java.util.List;

public interface MessageRepository {

    public List<Message> listDialogMessages(int userId, int senderId);
    public void createMessage(Message message);

}
