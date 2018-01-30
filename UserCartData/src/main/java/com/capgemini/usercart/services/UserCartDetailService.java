package com.capgemini.usercart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.repository.MongoRepositoryDataBaseOperations;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class UserCartDetailService {

	@Autowired
	MongoRepositoryDataBaseOperations mongoRepositoryDataBaseOperations;

	
	
	public UserCartModel getData(String userId) {

		try {

			if (mongoRepositoryDataBaseOperations.exists(userId)) {
				return mongoRepositoryDataBaseOperations.findOne(userId);
			} else {
				return new UserCartModel(userId,null);
			}

		} catch (Exception e) {
			throw new RuntimeException("Error in retrieving data" + e.getMessage());
		}

	}

}
