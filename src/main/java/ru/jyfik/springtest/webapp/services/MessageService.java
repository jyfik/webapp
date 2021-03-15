package ru.jyfik.springtest.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jyfik.springtest.webapp.domain.Message;
import ru.jyfik.springtest.webapp.repos.MessageRepo;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void saveMessage(Message message) {
        messageRepo.save(message);
    }

    public List<Message> findAll() {
        return messageRepo.findAll();
    }
}
