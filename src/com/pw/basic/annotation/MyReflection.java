package com.pw.basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class<MyTest> myTestClass = MyTest.class;
		Method method = myTestClass.getMethod("output", new Class[] {});
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation annotion = method.getAnnotation(MyAnnotation.class);
			System.out.println(annotion.hello());
			System.out.println(annotion.world());

		}
		System.out.println("-----------");
		Annotation[] annotations = method.getAnnotations();
		for (Annotation a : annotations) {
			System.out.println(a.annotationType().getName());
		}
	}

}
