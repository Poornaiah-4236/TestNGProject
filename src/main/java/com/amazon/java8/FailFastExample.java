package com.amazon.java8;
import java.util.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FailFastExample {
	public static void main(String[]args) {
		CopyOnWriteArrayList<Integer>list= new CopyOnWriteArrayList(new Integer[] {2,6,8,4,90,30,29});
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()) {
			int ss=itr.next();
			list.add(67);
		}
		System.out.println(list);
		threadPool();
		FailSafeItr();
	
	}
	public static void FailSafeItr() {
		Map<Integer,String>map=new HashMap<Integer,String>();
		map.put(3, "Banana7");
		map.put(4, "Banana9");
		map.put(1, "Banana0");
		map.put(8, "Banana2");
		 Iterator it = map.keySet().iterator();
		 Iterator its = map.values().iterator();
		 while(it.hasNext()) {
			 int val=(int) it.next();
			 map.put(4, "Apple");
		 }
		 System.out.println(map);
	}
	
	public static void threadPool() {
		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++) {
			int taskId=i;
			service.execute(()->{
				 System.out.println("Executing task " + taskId + 
			                " by " + Thread.currentThread().getName());
			});
		}
		service.shutdown();
	}
}

