package com.capgemini.usercart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.usercart.model.ConstantValues;
import com.capgemini.usercart.repository.MongoRepositoryDataBaseOperations;

import lombok.Data;

@Data
@Service
public class EmptyProductCartService {
	
	@Autowired
	MongoRepositoryDataBaseOperations mongoRepositoryDataBaseOperations;
	
	public String emptyCart( String userId)
	{


		try {

			if (mongoRepositoryDataBaseOperations.exists(userId)) {

				mongoRepositoryDataBaseOperations.delete(userId);
			}

			return ConstantValues.RESULT_SUCCESS;
		} catch (Exception e) {
			return ConstantValues.RESULT_FAILED;

		}

	
	}

}
