package com.pw.basic.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface FruitColor {
	public enum Color {
		BLUE, RED, GREEN
	};

	Color fruitColor() default Color.GREEN;
}
