package com.egfavre;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 6/21/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer>{
    public Message findById(int id);
}
