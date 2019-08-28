package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}