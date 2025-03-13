package com.example.permanent_chatt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Chat> getAllChat(){
        List<Chat> chats=repo.findAll();
        //för varje c/chat i listan använder vi mappen
        return chats.stream().map(c -> ChatMapper.INSTANCE.chatToChat(c)).collect(Collectors.toList());



//        public List<ProductDTO>getAllProducts(){
//            List<Product> products= repo.findAll();
//            //för varje p/prodduct i listan använder vi mapper
//            return products.stream().map(p -> ProductMapper.INSTANCE.productToProductDTO(p)).collect(Collectors.toList());

    }



}
