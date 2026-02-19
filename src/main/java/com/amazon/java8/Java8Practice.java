package com.amazon.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Practice {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "bob", "Charlie", "Apple", "banana", "cherry");
		names.forEach(name -> System.out.println(name));
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
		List<String> sorts = names.stream().filter(name -> name.startsWith("b")).collect(Collectors.toList());
		System.out.println(sorts);
		List<String> uppercaseLettors = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(uppercaseLettors);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.stream().reduce(0, Integer::sum);
		Optional<String> optional = Optional.of("Hello, Optional!");
		optional.isPresent();
		// System.out.println(optional.ifPresent(value->value.indexOf(2, 7)));
		browserOptions();

	}

	public static void browserOptions() {
		Predicate<Integer> isExpensive = price -> price > 10000;
		int productPrice = 1200;
		if (isExpensive.test(productPrice)) {
			System.out.println("Premium Product");
		} else {
			System.out.println("Not Premium Product");
		}
		List<Order> orders = new ArrayList<>();
		Order odr = new Order("Delivered", 700);
		Order odr1 = new Order("Cancled", 600);
		Order odr2 = new Order("Placed", 700);
		Order odr3 = new Order("Delivered", 400);
		orders.add(odr);
		orders.add(odr1);
		orders.add(odr2);
		orders.add(odr3);
		Predicate<Order> isDelivered = order -> order.getStatus().equals("Delivered");
		Predicate<Order> isHighValue = order -> order.getAmount() > 500 && order.getAmount() < 100;
		;

		orders.stream().filter(isDelivered.and(isHighValue)).forEach(System.out::println);
		// isExpensive.
		Predicate<String> emailValidation = email -> email.contains("@") && email.contains(".com");
		System.out.println(emailValidation.test("test@gmail.com"));
		// emailValidation.and(emailValidation);
		// int a=9;
		Sqare sq = (x) -> 4 * 5;
		System.out.println(sq.Calculate(8));
		List<String> n = Arrays.asList("Geek", "GeeksQuiz", "g1", "QA", "Geek2","test@gmail.com");
		System.out.println(" This is the streeming api :"+n.stream().anyMatch(emailValidation));
		Predicate<String> p = (s) -> s.startsWith("G");
		for (String s : n) {
			if (p.test(s))
				System.out.println(s);

		}
		Function<Integer,Integer>div=a->a/2;
		System.out.println(div.apply(8));
		div=div.andThen(a->3*6);
		System.out.println(div);
		div=div.compose(b->b*3);
		//System.out.println(div.apply(div));
		div.apply(23);
		System.out.println(div);

	}

}

class Order {
	public Order(String sts, int price) {
		this.status = sts;
		this.Amount = price;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	private int Amount;
}

interface Sqare {
	int Calculate(int x);
}
