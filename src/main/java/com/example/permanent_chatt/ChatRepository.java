package com.example.permanent_chatt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    //chats från channelid
    List<Chat> findByChannelId(Long channelId);
}
