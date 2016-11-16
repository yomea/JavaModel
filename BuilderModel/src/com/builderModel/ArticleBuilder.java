package com.builderModel;

public class ArticleBuilder implements Builder {
	
	@Override
	public String BuildPart1() {
		return new String("title");
		
	}

	@Override
	public String BuildPart2() {
		return new String("content");
	}


}
