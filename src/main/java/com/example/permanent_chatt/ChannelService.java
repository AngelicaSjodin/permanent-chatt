package com.example.permanent_chatt;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    //ref till channel repo
    private ChannelRepository channelRepository;
    //const
    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
    }

    //skapar channels
    public Channel createChannel(Channel channel){
        return channelRepository.save(channel);
    }

    //hämtar channels
    public List<Channel> getAllChannels(){
        return channelRepository.findAll();
    }

    //ta bort channel
    public void deleteChannel(Long id){
        channelRepository.deleteById(id);
    }

}






