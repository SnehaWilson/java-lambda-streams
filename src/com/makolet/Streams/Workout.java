package com.makolet.Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
	
	
	private static	List<Product> products = new ArrayList<>();
	static {
		products.add(new Product("Orange","Rupee",new BigDecimal("2000.75"),0.05));
		products.add(new Product("Apple","Pound",new BigDecimal("100.25"),0.30));
		products.add(new Product("Mongo","Riyal",new BigDecimal("200.15"),0.15));
		products.add(new Product("Banana","Rupee",new BigDecimal("3000.75"),0.20));
		products.add(new Product("PineApple","Rupee",new BigDecimal("3000.25"),0.02));
	}

	public static void main (String args[]) {
		
		Comparator<Product> comparator =(p1,p2)->p1.getValue().doubleValue()*p1.getDiscount() > p2.getValue().doubleValue()*p2.getDiscount() ? 1 :-1;
		
		//Find the highest Amount
		Product maxProduct = products.stream().max(comparator).get();
		System.out.println("Highest Product : "+maxProduct);
		System.out.println("Highest Amount : "+maxProduct.getValue().doubleValue() * maxProduct.getDiscount());
		
		//Find the lowest Amount
		Product minProduct = products.stream().min(comparator).get();
		System.out.println("Lowest Product : "+minProduct);
		System.out.println("Lowest Amount : "+minProduct.getValue().doubleValue()* minProduct.getDiscount());
		
		//Find Average Amount
		List<Double> productValue= products.stream().map(product->product.getValue().doubleValue()*product.getDiscount()).collect(Collectors.toList());
		double averageAmount = (productValue.stream().reduce(0.0,(acc,amount)->acc+amount))/productValue.size()-1;
		System.out.println("Average Amount : "+averageAmount);
		
		//Find the highest value and convert bigDecimal to double
		List<BigDecimal> valueList = products.stream().map(product->product.getValue()).collect(Collectors.toList());
		valueList.sort((p1,p2)->p1.compareTo(p2) < 0 ? 1: -1);
		System.out.println("Highest Value : "+valueList.get(0)+" double value "+valueList.get(0).doubleValue());
		
		//Print currency and amount in descending order
		
	}
}
