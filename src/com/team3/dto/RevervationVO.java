package com.team3.dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class RevervationVO {
	private String user_id;
	private int resr_number;
	private String resr_user_name;
	private String resr_user_tel;
	private int resr_user_degree;
	private String store;
	private Date resr_date;
	private Date resr_time;
	private String resr_store_need;
	private Date resr_usingtime;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getResr_number() {
		return resr_number;
	}
	public void setResr_number(int resr_number) {
		this.resr_number = resr_number;
	}
	public String getResr_user_name() {
		return resr_user_name;
	}
	public void setResr_user_name(String resr_user_name) {
		this.resr_user_name = resr_user_name;
	}
	public String getResr_user_tel() {
		return resr_user_tel;
	}
	public void setResr_user_tel(String resr_user_tel) {
		this.resr_user_tel = resr_user_tel;
	}
	public int getResr_user_degree() {
		return resr_user_degree;
	}
	public void setResr_user_degree(int resr_user_degree) {
		this.resr_user_degree = resr_user_degree;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public Date getResr_date() {
		return resr_date;
	}
	public void setResr_date(Date resr_date) {
		this.resr_date = resr_date;
	}
	public Date getResr_time() {
		return resr_time;
	}
	public void setResr_time(Date resr_time) {
		this.resr_time = resr_time;
	}
	public String getResr_store_need() {
		return resr_store_need;
	}
	public void setResr_store_need(String resr_store_need) {
		this.resr_store_need = resr_store_need;
	}
	public Date getResr_usingtime() {
		return resr_usingtime;
	}
	public void setResr_usingtime(Date resr_usingtime) {
		this.resr_usingtime = resr_usingtime;
	}
	
	@Override
	public String toString() {
		return "RevervationVO [user_id=" + user_id + ", resr_number=" + resr_number + ", resr_user_name="
				+ resr_user_name + ", resr_user_tel=" + resr_user_tel + ", resr_user_degree=" + resr_user_degree
				+ ", store=" + store + ", resr_date=" + resr_date + ", resr_time=" + resr_time + ", resr_store_need="
				+ resr_store_need + ", resr_usingtime=" + resr_usingtime + "]";
	}
	

	
	
}
