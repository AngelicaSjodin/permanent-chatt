package com.example.permanent_chatt;

import jakarta.persistence.*;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String text;


    //set and get ^
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //tom constructor
    public Chat(){
    }

    //koppling till channels
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    //get set^
    public Channel getChannel() {
        return channel;
    }
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }

}
