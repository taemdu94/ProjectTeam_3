package com.team3.dto;

import lombok.Data;

@Data
public class StoreVO {
	private String userid;
	private String store_photo;
	private String store_name;
	private String store_type;
	private String store_time;
	private String store_time_w;
	private String store_addr;
	private String store_addr_detail;
	private String memu_info;
	private String parking;
	private String parking_detail;
}