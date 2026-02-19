package com.common.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class SamplePrograms {
	private double dbl=454.7899;
	public static void main(String[] args) {
        String input = "aaabbccdaafwwrstte";
        System.out.println(removeDuplicate(input));
       // Child pr=new Parent();
		//pr.childMethod();
        int a=569;
        int b=567;
        System.out.println(a%10+" is the a value");
        System.out.println(b/10+" is the b value");
        int[]arr= {1, 2, 0, 4, 3, 0, 5, 0};
        int d=3;
        //Parent.doup(arr,d);
        Parent.moveZerosToBeginning(arr);
        Parent.Performance();
       // generatePattern(5);
        System.out.println(" Expected pattren is: "+generatePattern(5));
    }
	public static List<Integer> generatePattern(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result.add(j);
            }
        }

        return result;
    }
  public static String removeDuplicate(String str) {
	     if(str==null||str.isEmpty()) {
	    	 return "";
	     }
	     StringBuilder result=new StringBuilder();
	     result.append(str.charAt(0));
	     for(int i=1;i<str.length();i++) {
	    	 if(str.charAt(i)!=str.charAt(i-1)) {
	    		 result.append(str.charAt(i));
	    	 }
	     }
	     return result.toString();
  }
}
class Parent{
	public void childMethod() {
		System.out.println("This is the Parent class method");
	}
	public static void doup(int[]arre,int end) {
		System.out.println(Arrays.toString(arre));
		System.out.println("          ");
		int n=arre.length;
		end=end%n;		
		int[] temp=new int[end];
		for(int i=0;i<end;i++) {
			temp[i]=arre[i];			
		}
		for(int i=end;i<n;i++) {
			arre[i-end]=arre[i];
		}
		for(int i=0;i<end;i++) {
			arre[end+i]=temp[i];
		}
		System.out.println(Arrays.toString(arre));
	}
	public static void moveZerosToBeginning(int[]arr) {
		if (arr == null || arr.length == 0) {
            return;
        }
		int writeIndex=arr.length-1;
		for(int readIndex=arr.length-1;readIndex>=0;readIndex--) {
			if(arr[readIndex]!=0) {
				arr[writeIndex]=arr[readIndex];
				writeIndex--;
			}
		}
		while(writeIndex>=0) {
			arr[writeIndex]=0;
			writeIndex--;
		}		
		System.out.println(" ");
		System.out.println(Arrays.toString(arr));
	}
	 public static void Performance() {
	        int iterations = 10000;

	        // Test StringBuffer performance
	        long startTimeBuffer = System.currentTimeMillis();
	        StringBuffer buffer = new StringBuffer();
	        for (int i = 0; i < iterations; i++) {
	            buffer.append("test");
	        }
	        long endTimeBuffer = System.currentTimeMillis();
	        System.out.println("StringBuffer Time: " + (endTimeBuffer - startTimeBuffer) + " ms");

	        // Test StringBuilder performance
	        long startTimeBuilder = System.currentTimeMillis();
	        StringBuilder builder = new StringBuilder();
	        for (int i = 0; i < iterations; i++) {
	            builder.append("test");
	        }
	        long endTimeBuilder = System.currentTimeMillis();
	        System.out.println("StringBuilder Time: " + (endTimeBuilder - startTimeBuilder) + " ms");
	    }
}
class Child extends Parent{
	public void childMethod() {
		System.out.println("This is the Child class method");
	}
	public static void main(int []args) {
		//LinkedHashMap<String,Integrr>hash=new LinkedHashMap<String,Integer>();
	}
}
