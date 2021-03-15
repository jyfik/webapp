package ru.jyfik.springtest.webapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "text_message")
    private String textMessage;

    @Column(name = "tag")
    private String tag;

    public Message(String textMessage, String tag) {
        this.textMessage = textMessage;
        this.tag = tag;
    }

    public Message() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return id + " " + textMessage + " " + tag;
    }
}
