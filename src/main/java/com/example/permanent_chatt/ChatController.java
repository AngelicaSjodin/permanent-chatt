package com.example.permanent_chatt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chat")
@RestController


public class ChatController {
    private ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService){
        this.chatService=chatService;
    }

    //hämtar chat från channel id
    // http://localhost:8080/chat/channel/*idSiffra* i postman
    @GetMapping("/channel/{channelId}")
    public ResponseEntity<List<ChatDTO>> getChatByChannelId(@PathVariable Long channelId){
        List<ChatDTO> chatDTOs = chatService.getChatByChannelId(channelId);
        if (chatDTOs.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(chatDTOs);
    }

    //skickar upp chat till kanal
    // http://localhost:8080/chat i postman
    //{
    //  "text": "...",
    //  "sender":"...",
    //  "channel": {
    //    "id": ...
    //  }
    //}

    @PostMapping()
    public ResponseEntity<Chat> createChatByRequestBody(@Valid @RequestBody Chat chat){
        Chat result = chatService.addChat(chat);
        return ResponseEntity.ok(result);
    }


    //för att hämta all chatt som skrivits
    //hämtar ut all chat // http://localhost:8080/chat
    @GetMapping()
    public List<ChatDTO> getAllChat(){
        return chatService.getAllChat();
    }

    //tar bort en chat
    //http://localhost:8080/chat/*idSiffra*
    @DeleteMapping("/{id}")
    public void deleteChatById(@PathVariable Long id){
        chatService.deleteChat(id);
    }

}
