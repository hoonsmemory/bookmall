package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private int order_no;
	private int order_price;
	private String order_adress;
	private int order_date;
	private int user_no;
	private int order_state;
	
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_adress() {
		return order_adress;
	}
	public void setOrder_adress(String order_adress) {
		this.order_adress = order_adress;
	}
	public int getOrder_date() {
		return order_date;
	}
	public void setOrder_date(int order_date) {
		this.order_date = order_date;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	
	@Override
	public String toString() {
		return "OrderVo [order_no=" + order_no + ", order_price=" + order_price + ", order_adress=" + order_adress
				+ ", order_date=" + order_date + ", user_no=" + user_no + ", order_state=" + order_state + "]";
	}
	
	
}
