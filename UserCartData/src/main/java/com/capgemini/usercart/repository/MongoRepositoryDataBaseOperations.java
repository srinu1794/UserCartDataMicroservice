package com.capgemini.usercart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.usercart.model.UserCartModel;

@Transactional
@Repository
public interface MongoRepositoryDataBaseOperations extends MongoRepository<UserCartModel, String> {

}
