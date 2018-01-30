package com.capgemini;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.usercart.model.ProductCartModel;
import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.services.UserCartDetailService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class FindUserIdTest {

	@Autowired
	UserCartDetailService userCartDetailService;

	

	
	
	
	  @Test
	    public void testFindById()
	    
	    
	    {
		  String userId="nikhil";
	        UserCartModel userCartModel = userCartDetailService.getData(userId);
	        List<ProductCartModel> cartItemList = userCartModel.getCartItemList();
	       
	     
	      
	        
	        for (ProductCartModel productCartModel : cartItemList) {
				
	        	String productId = productCartModel.getProductId();
	        	String quantity = productCartModel.getQuantity();
	        
	        System.out.println("hi"+userCartModel.getUserId());

	        Assert.assertEquals("nikhil", userCartModel.getUserId());
	        Assert.assertEquals("777",productId);
	        Assert.assertEquals("12",quantity);
	        }
	    }

}
