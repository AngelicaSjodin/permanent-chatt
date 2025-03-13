package com.example.permanent_chatt;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Chat")
@RestController


public class ChatController {
    ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService){
        this.chatService=chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChatByRequestBody(@Valid @RequestBody Chat chat){
        Chat result = chatService.addChat(chat);
        return ResponseEntity.ok(result);
    }


}
