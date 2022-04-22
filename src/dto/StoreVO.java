package dto;

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
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStore_photo() {
		return store_photo;
	}
	public void setStore_photo(String store_photo) {
		this.store_photo = store_photo;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_type() {
		return store_type;
	}
	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}
	public String getStore_time() {
		return store_time;
	}
	public void setStore_time(String store_time) {
		this.store_time = store_time;
	}
	public String getStore_time_w() {
		return store_time_w;
	}
	public void setStore_time_w(String store_time_w) {
		this.store_time_w = store_time_w;
	}
	public String getStore_addr() {
		return store_addr;
	}
	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}
	public String getStore_addr_detail() {
		return store_addr_detail;
	}
	public void setStore_addr_detail(String store_addr_detail) {
		this.store_addr_detail = store_addr_detail;
	}
	public String getMemu_info() {
		return memu_info;
	}
	public void setMemu_info(String memu_info) {
		this.memu_info = memu_info;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getParking_detail() {
		return parking_detail;
	}
	public void setParking_detail(String parking_detail) {
		this.parking_detail = parking_detail;
	}
	
	@Override
	public String toString() {
		return "storeDAO [userid=" + userid + ", store_photo=" + store_photo + ", store_name=" + store_name
				+ ", store_type=" + store_type + ", store_time=" + store_time + ", store_time_w=" + store_time_w
				+ ", store_addr=" + store_addr + ", store_addr_detail=" + store_addr_detail + ", memu_info=" + memu_info
				+ ", parking=" + parking + ", parking_detail=" + parking_detail + "]";
	}


}
