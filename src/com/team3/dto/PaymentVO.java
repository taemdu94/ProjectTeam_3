package com.team3.dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class PaymentVO {

	private int payment_number;
	private String payment_type;
	private Date payment_time;
	private int amount;
	
	
	public int getPayment_number() {
		return payment_number;
	}
	public void setPayment_number(int payment_number) {
		this.payment_number = payment_number;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "PaymentVO [payment_number=" + payment_number + ", payment_type=" + payment_type + ", payment_time="
				+ payment_time + ", amount=" + amount + "]";
	}
	
	


}
