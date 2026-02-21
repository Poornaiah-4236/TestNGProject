package com.amazon.java8;

import java.io.*;
public class Serialize {
		public static void main(String[]args) throws FileNotFoundException {
			FileOutputStream fso=new FileOutputStream("Testing.text");
		}
}
class active implements Serializable{
	int x=30;
	int y=90;
	public void Active(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
