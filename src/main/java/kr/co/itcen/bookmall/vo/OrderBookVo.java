package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private int odlist_no;
	private int book_no;
	private int book_count;
	private int order_no;
	
	public OrderBookVo() {}
	
	public OrderBookVo(int book_no, int book_count, int order_no) {
		this.book_no = book_no;
		this.book_count = book_count;
		this.order_no = order_no;
	}
	
	public int getOdlist_no() {
		return odlist_no;
	}
	public void setOdlist_no(int odlist_no) {
		this.odlist_no = odlist_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getBook_count() {
		return book_count;
	}
	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	
	@Override
	public String toString() {
		return "OrderBookVo [odlist_no=" + odlist_no + ", book_no=" + book_no + ", book_count=" + book_count
				+ ", order_no=" + order_no + "]";
	}
	
	
}
