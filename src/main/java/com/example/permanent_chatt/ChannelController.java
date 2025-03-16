package com.example.permanent_chatt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/channel")
public class ChannelController {
    //ref till channel service
    private ChannelService channelService;

    //const
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    //da methods
    //hämta
    @GetMapping
    public ResponseEntity<List<Channel>> getAllChannels(){
        return ResponseEntity.ok(channelService.getAllChannels());
}
    //skapa
    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel){
        return ResponseEntity.ok(channelService.createChannel(channel));
    }

    //tar bort
    @DeleteMapping("/{id}")
    public void deleteChannelById(@PathVariable Long id){
        channelService.deleteChannel(id);
    }

}


















