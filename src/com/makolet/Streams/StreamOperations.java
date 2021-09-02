package com.makolet.Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamOperations {
	
	private static	List<Product> products = new ArrayList<>();
	static {
		products.add(new Product("Orange","Rupee",new BigDecimal("2000.75"),0.05));
		products.add(new Product("Apple","Rupee",new BigDecimal("100.25"),0.30));
		products.add(new Product("Mongo","Rupee",new BigDecimal("200.15"),0.15));
		products.add(new Product("Banana","Rupee",new BigDecimal("3000.75"),0.20));
		products.add(new Product("PineApple","Rupee",new BigDecimal("3000.25"),0.02));
	}

	public static void main (String args[]) {
		
		Comparator<Product> comparator =(p1,p2)->{
			double productValue1 = p1.getValue().doubleValue() * p1.getDiscount();
			double productValue2 = p2.getValue().doubleValue() * p2.getDiscount();
			return (productValue1>productValue2)?1:-1;
		};
		
		//Find the highest amount
		Product maxProduct = products.stream().max(comparator).get();
		System.out.println("Highest Amount : "+maxProduct.getValue().doubleValue());
		
		//Find the Lowest amount
		Product minProduct = products.stream().min(comparator).get();
		System.out.println("Lowest Amount : "+minProduct.getValue().doubleValue());
		
		//Find average Amount
		List<Double> productValue = products.stream().map(product-> product.getValue().doubleValue() * product.getDiscount()).collect(Collectors.toList());
		double sum= productValue.stream().reduce(0.0,(acc,product)->acc + product);
		double average= sum/productValue.size()-1;
		System.out.println("Average Amount : "+average);
		
		//Find the highest amount and convert bigDecimal to double
		Comparator<Product> conversion =(p1,p2)->(p1.getValue().doubleValue()> p2.getValue().doubleValue())?1:-1;
		Double maxAmount = products.stream().max(conversion).get().getValue().doubleValue();
		System.out.println("highest amount and convert bigDecimal to double "+maxAmount);
		
		//Print currency and amount in descending order
		Comparator<Product> descendingComparator =(p1,p2)->{
			double productValue1 = p1.getValue().doubleValue() * p1.getDiscount();
			double productValue2 = p2.getValue().doubleValue() * p2.getDiscount();
			return (productValue1>productValue2)?-1:1;
		};
		products.sort(descendingComparator);
		System.out.println("currency and amount in descending order :");
		products.stream().forEach(product->{
			System.out.println(product.getCurrency()+" "+product.getValue());
		});
		
		//Lowest Discount
		Comparator<Product> discountComparator =(p1,p2)-> p1.getDiscount()>p2.getDiscount()?1:-1;
		double lowestDiscount= products.stream().min(discountComparator).get().getDiscount();
		System.out.println("Lowest Discount : "+lowestDiscount);
		
		//Print products in alphabetical order
		Comparator<Product> sortAlphabetically =(p1,p2)-> p1.getCode().charAt(0)>p2.getCode().charAt(0)?1:-1;
		products.sort(sortAlphabetically);
		System.out.println("Print products in alphabetical order : ");
		products.stream().forEach(product->System.out.println(product));
		
	}
	
}
