package com.example.permanent_chatt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @PersistenceContext
    private EntityManager entityManager;
    ChatRepository repo;

    public ChatService(ChatRepository repo){
        this.repo = repo;
    }

    public Chat addChat(Chat chat){
        //EntityManager.clear();
        return repo.save(chat);
    }

}
