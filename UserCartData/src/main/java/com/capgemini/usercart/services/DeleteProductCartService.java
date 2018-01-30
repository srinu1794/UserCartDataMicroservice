package com.capgemini.usercart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.repository.MongoRepositoryDataBaseOperations;

@Service
public class DeleteProductCartService {

	@Autowired
	MongoRepositoryDataBaseOperations mongoRepositoryDataBaseOperations;
	
	
	public UserCartModel deleteProduct(String userId, String productId){
		try {
			//List<ProductCartModel> list = new ArrayList<>();
			if (mongoRepositoryDataBaseOperations.exists(userId)) {

				UserCartModel user = mongoRepositoryDataBaseOperations.findOne(userId);
				
				int index = CheckProductInList.getUserDetail(user.getCartItemList(), productId);
				if (index < user.getCartItemList().size()-1) {
					user.getCartItemList().remove(index);
				}
				
				return mongoRepositoryDataBaseOperations.save(user);
			}
			
		} catch (Exception e) {
			

		}
		return null;

	
	}
}
