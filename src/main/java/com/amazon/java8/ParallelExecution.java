package com.amazon.java8;

import java.awt.Robot;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParallelExecution {
	private final static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	private WebDriver getDriver;

	public void setup() {
		WebDriver driver = new ChromeDriver();
		threadLocalDriver.set(driver);
	}

	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public void tearDown() {
		getDriver.quit();

	}

	public static void main(String[] args) {
		// ParallelExecution.evenOrodd("56");
		System.out.println(ParallelExecution.evenOrodd("13"));
		VowelConsonantCounter("poornaiahmadipallihyderabsd");
		String str = "Java powerful is great and Java is powerful and Java powerful is popular powerful";
		MostRepeatedWord(str);
		try {
			Robot robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(finalBlock());
		A obj=new A() {
			void Method() {
				System.out.println("Anamous method : obj");
			}
		};
		obj.Method();
		A b=new A() {
			void Method() {
				System.out.println("Anamous method :  b");
			}
		};
		Thread t=new Thread() {
			public void run() {
				 System.out.println("Child Thread");
			}
		};
		t.run();
		Runnable r=new Runnable() {
			public void run() {
				 System.out.println("Child Thread");
			}
		};
		Thread tr=new Thread(r);

	}

	public static int finalBlock() {
		int a = 90;
		try {
			// int a=90;
			return a;
		} finally {
			a = 9;
			return a;
		}
	}

	public static void MostRepeatedWord(String str) {
		String[] word = str.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		for (String s : word) {
			if (!s.contains(str))
				map.put(s, map.getOrDefault(s, 0) + 1);
			else
				map.put(s, 0);
		}
		String mostRepeated = "";
		int maxCount = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostRepeated = entry.getKey();
			}
		}
		System.out.println(mostRepeated + " most repeated times :" + maxCount);
	}

	public static void VowelConsonantCounter(String input) {
		int vovels = 0;
		int conents = 0;
		char[] ch = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			char c = Character.toLowerCase(input.charAt(i));
			if (c >= 'a' && c <= 'z') {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vovels++;
				} else {
					conents++;
				}
			}
		}
		System.out.println(conents + " : " + vovels);
	}

	public static String evenOrodd(String args) {
		String str = "45";
		String result = "";
		StringBuilder sbl = new StringBuilder();
		sbl.append(str);
		sbl.reverse();
		int num = Integer.parseInt(sbl.toString());
		if (num % 2 == 0) {
			result = "even";
		} else {
			result = "odd";
		}
		return result;
	}
}

class MoveComparable implements Comparable<MoveComparable> {
	String name;
	int rating;

	public MoveComparable(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Move [name=" + name + ", rating=" + rating + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(MoveComparable o) {
		// TODO Auto-generated method stub
		return this.rating - o.getRating();
	}

}

class MoveComparator implements Comparator<MoveComparator> {
	String name;
	int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public MoveComparator(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	@Override
	public int compare(MoveComparator o1, MoveComparator o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.rating, o2.rating);
	}
}
abstract class A{
	abstract void Method();
	
}

