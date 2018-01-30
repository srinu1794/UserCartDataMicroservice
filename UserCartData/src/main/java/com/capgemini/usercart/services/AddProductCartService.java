package com.capgemini.usercart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.usercart.model.ProductCartModel;
import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.repository.MongoRepositoryDataBaseOperations;

import lombok.Data;

@Data
@Service
public class AddProductCartService {

	@Autowired
	MongoRepositoryDataBaseOperations mongoRepositoryDataBaseOperations;


	public UserCartModel addProduct(String userId, String productId, String quantity) {
		try {
			final ProductCartModel pcart = new ProductCartModel();
			pcart.setProductId(productId);
			pcart.setQuantity(quantity);
			if (mongoRepositoryDataBaseOperations.exists(userId)) {
				UserCartModel user = mongoRepositoryDataBaseOperations.findOne(userId);
				int index = CheckProductInList.getUserDetail(user.getCartItemList(), productId);
				if (index < user.getCartItemList().size()) {
					user.getCartItemList().remove(index);
				}
				user.getCartItemList().add(pcart);
				return mongoRepositoryDataBaseOperations.save(user);
			} else {
				List<ProductCartModel> newUserProductAdditionList = new ArrayList<>();
				newUserProductAdditionList.add(pcart);
				UserCartModel user = new UserCartModel();
				user.setUserId(userId);
				user.setCartItemList(newUserProductAdditionList);
				return mongoRepositoryDataBaseOperations.save(user);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Error Performing operation!!!" + e.getMessage());
		}
		
	

	}

}
