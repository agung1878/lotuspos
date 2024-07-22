package com.cashier.dao;

import com.cashier.entity.security.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserDao extends CrudRepository<User, String>, PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

}
