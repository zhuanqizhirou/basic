package com.pw.basic.annotation;

import java.text.MessageFormat;

import com.pw.basic.annotation.FruitColor.Color;

public class Apple {
	@FruitName("Apple")
	private String appleName;

	@FruitColor(fruitColor = Color.RED)
	private String appleColor;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String toString() {
		return MessageFormat.format("name:{0},color:{1}", this.appleName, this.appleColor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Apple();
		System.out.println(a);
	}

}
