package com.builderModel;

/**
 * 装配者
 * @author may
 *
 */
public class Director {
	private Builder builder = null;
	
	public Director(Builder builder) {
		this.builder = builder;
		
	}
	
	public Product getProduct() {
		
		Product product = new Article();
		String title = builder.BuildPart1();
		String content = builder.BuildPart2();
		product.setTitle(title);
		product.setContent(content);
		
		return product;
	}		
}
