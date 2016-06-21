package com.egfavre;

import javax.persistence.*;

/**
 * Created by user on 6/21/16.
 */
@Entity
@Table (name="users")
public class User {
    @GeneratedValue
    @Id
    int id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }
}
