package com.capgemini.usercart.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ComponentScan
@Document(collection = "CartDetails")
public class UserCartModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3715031506442555230L;
	@Id
	private String userId;
	private List<ProductCartModel> cartItemList;

}
