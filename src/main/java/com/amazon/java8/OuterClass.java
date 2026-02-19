package com.amazon.java8;

public class OuterClass {
	private int age=78;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass out=new OuterClass();
		InnerClass inner=out.new InnerClass();
		inner.innerMethod();
				
	}
	public void nonStatic() {
		
	}
	class InnerClass {
		public void innerMethod() {
			System.out.println(age);
		}
	}

}
