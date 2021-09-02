package com.makolet.Streams;

import java.math.BigDecimal;

public class Product {
private String code;
private String currency;
private BigDecimal value;
private double discount;


public Product(String code, String currency, BigDecimal value, double discount) {
	super();
	this.code = code;
	this.currency = currency;
	this.value = value;
	this.discount = discount;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public BigDecimal getValue() {
	return value;
}
public void setValue(BigDecimal value) {
	this.value = value;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}

@Override
public String toString() {
	return "Product [code=" + code + ", currency=" + currency + ", value=" + value + ", discount=" + discount + "]";
}



}
