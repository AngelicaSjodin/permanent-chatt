package com.example.permanent_chatt;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ChatMapper {

    //skapar upp singelton åt oss
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    @Mapping(source = "channel.name",target ="channelName")

    public ChatDTO chatToChatDTO(Chat chat);
//    public Chat chatDTOToChat(ChatDTO chatDTO);

}
