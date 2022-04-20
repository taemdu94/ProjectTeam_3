package com.team3.dto;

public class ReserMngVO {
	
	private int      resr_number;
	private String   resr_user_name;
	private String   resr_date; 
	private String   resr_info;
	private String   resr_user_tel; 
	private int      n_membership;
	
	
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
	public String getResr_date() {
		return resr_date;
	}
	public void setResr_date(String resr_date) {
		this.resr_date = resr_date;
	}
	public String getResr_info() {
		return resr_info;
	}
	public void setResr_info(String resr_info) {
		this.resr_info = resr_info;
	}
	public String getResr_user_tel() {
		return resr_user_tel;
	}
	public void setResr_user_tel(String resr_user_tel) {
		this.resr_user_tel = resr_user_tel;
	}
	public int getN_membership() {
		return n_membership;
	}
	public void setN_membership(int n_membership) {
		this.n_membership = n_membership;
	}
	
	@Override
	public String toString() {
		return "ReserMngVO [resr_number=" + resr_number + ", resr_user_name=" + resr_user_name + ", resr_date="
				+ resr_date + ", resr_info=" + resr_info + ", resr_user_tel=" + resr_user_tel + ", n_membership="
				+ n_membership + "]";
	}
	

	
}
