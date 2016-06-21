package com.egfavre;

import javax.persistence.*;

/**
 * Created by user on 6/21/16.
 */
@Entity
@Table (name="messages")
public class Message {
    @GeneratedValue
    @Id
    int id;

    @Column(nullable = false)
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }
}
