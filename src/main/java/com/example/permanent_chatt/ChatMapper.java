package com.example.permanent_chatt;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface ChatMapper {

    //skapar upp singelton åt oss
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    public Chat chatToChat(Chat chat);

}
