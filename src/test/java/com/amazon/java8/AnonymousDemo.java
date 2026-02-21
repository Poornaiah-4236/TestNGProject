package com.amazon.java8;

public class AnonymousDemo {
	public static void main(String[]args) {
		Age obj=new Age() {

			@Override
			public void getAge() {
				// TODO Auto-generated method stub
				 System.out.print("Age is " + x);
			}
			
		};
		obj.getAge();
		Child p=new Child();
		p.Private();
		
		
		
	}
}
interface Age{
	int x=45;
	void getAge();
	public String str ="private";
	public final int salary=450000;
}
abstract class Parent{
	private int ss=0;
	public String yy="";
	public static double zz=678.90;
	abstract public void Private();
	public void nonAbstract() {}
	private void testMethod() {
		System.out.println("This is private method inside abstract class.");
	}
}
class Child extends Parent{
	@Override
	public void Private() {
		System.out.println("This the child class method");
	}
}
class grandchild extends Child{
	
}
