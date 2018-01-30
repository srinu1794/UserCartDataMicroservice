package com.capgemini.usercart.model;

import java.io.Serializable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ComponentScan
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5537789757476648851L;
	private String productId;
	private String quantity;
}
