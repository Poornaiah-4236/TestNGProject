package com.amazon.home;

import java.util.Map;
import java.util.*;
public class ExcepTest {
	public static void main(String args[]) {
		
		//finallyblock();
		Map<Integer,String>map=new HashMap<>();
	      map.put(2, "Poorna2");
	      map.put(0, "Poorna0");
	      map.put(3, "Poorna3");
	      map.put(1, "Poorna1");
	      System.out.println(map);
	}
	public static void finallyblock() {
		 int a[] = new int[2];
		 a[0] = 5;
		 a[1] = 4;
	      try {
	         System.out.println("Access element three :" + a[3]);
	      } catch (Exception e) {
	         System.out.println("Exception thrown  :" + e);
	      }finally {
	         a[0] = 6;
	         System.out.println("First element value: " + a[0]);
	         System.out.println("The finally statement is executed");
	      }
	      
	      
		
	}
	

}
class Person{
	String name="Poornaiah";
	int age=42;
	@Override
	public String toString() {
		return "Name : "+name+"-> Age :"+age;
	}
	
}
