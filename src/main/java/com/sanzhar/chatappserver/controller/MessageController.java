package com.sanzhar.chatappserver.controller;

import com.sanzhar.chatappserver.model.Message;
import com.sanzhar.chatappserver.model.User;
import com.sanzhar.chatappserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public List<Message> listDialogMessages(@RequestAttribute("user") User user, @PathVariable("id") int sender_id){

        return messageService.listDialogMessages(user.getId(), sender_id);
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public void addMessage(@RequestAttribute("user") User user,
                           @PathVariable("id") int reciever_id,
                           @RequestParam("text") String text){

        System.out.println("debug: " + user.getId() + " " + reciever_id + " " + text);

        messageService.createMessage(user.getId(), reciever_id, text);
    }

}
