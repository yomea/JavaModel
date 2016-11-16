package com.builderModel;

public class Test {
	
	
	public static void main(String[] args) {
		
		Builder builder = new ArticleBuilder();
		
		Director director = new Director(builder);
		
		Article article = (Article) director.getProduct();
		
		System.out.println(article.toString());
		
	}

}
