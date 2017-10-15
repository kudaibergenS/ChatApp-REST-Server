package com.sanzhar.chatappserver.repository;

import com.sanzhar.chatappserver.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Message> listDialogMessages(int userId, int senderId) {
        Session session = sessionFactory.getCurrentSession();

        List<Message> messages = session.createQuery("from Message "
                + "where (user_id=:userId or user_id=:senderId) "
                + "and (sender_id=:userId or sender_id=:senderId) "
                + "order by sent_date asc")
                .setParameter("userId", userId)
                .setParameter("senderId", senderId)
                .list();

        return messages;
    }

    public void createMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(message);
    }
}
