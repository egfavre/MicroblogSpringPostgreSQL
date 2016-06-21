package com.egfavre;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 6/21/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
}
