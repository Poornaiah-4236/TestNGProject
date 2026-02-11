package com.common.Utils;

public class SamplePrograms {
	public static void main(String[] args) {
        String input = "aaabbccdaa";
        System.out.println(removeDuplicate(input));
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
