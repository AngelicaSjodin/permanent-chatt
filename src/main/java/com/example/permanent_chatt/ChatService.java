package com.example.permanent_chatt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    @PersistenceContext
    private EntityManager entityManager;
    ChatRepository repo;
    ChannelRepository channelRepo;

    public ChatService(ChatRepository repo, ChannelRepository channelRepo){
        this.repo = repo;
        this.channelRepo = channelRepo;
    }

    //hämta chat med channel id
    public List<ChatDTO> getChatByChannelId(Long channelId){
        //kollar om kanalen finns
        Channel channel = channelRepo.findById(channelId).orElse(null);
        if(channel==null){
            return Collections.emptyList();//hitta inte ge tom lista
        }
        List<Chat> chats = repo.findByChannelId(channelId);
        return chats.stream().map(c -> ChatMapper.INSTANCE.chatToChatDTO(c)).collect(Collectors.toList());
    }

    //lägg till chat
    public Chat addChat(Chat chat){
        //EntityManager.clear();
        return repo.save(chat);
    }

    //se all chat
    public List<ChatDTO> getAllChat(){
        List<Chat> chats=repo.findAll();
        //för varje c/chat i listan använder vi mappen
        return chats.stream().map(c -> ChatMapper.INSTANCE.chatToChatDTO(c)).collect(Collectors.toList());
    }

    //ta bort en chat
    public void deleteChat(Long id){
        repo.deleteById(id);
    }
}


