package com.team3.dto;

import java.util.Date;

public class ProductVO {
	private int code;
	private String name;
	private int price;
	private String pictureurl;
	private String description;
	private Date col_date;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCol_date() {
		return col_date;
	}
	public void setCol_date(Date col_date) {
		this.col_date = col_date;
	}
	
	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", pictureurl=" + pictureurl
				+ ", description=" + description + ", col_date=" + col_date + "]";
	}
	
}
