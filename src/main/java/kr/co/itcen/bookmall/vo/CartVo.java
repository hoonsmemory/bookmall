package kr.co.itcen.bookmall.vo;

public class CartVo {

	private int cart_no;
	private int book_no;
	private int book_count;
	private int user_no;
	private String cart_state;
	
	public CartVo() {}
	
	//카트 담기
	public CartVo(int user_no, int book_no, int book_count) {
		this.user_no    = user_no;
		this.book_no    = book_no;
		this.book_count = book_count;		
	}
	

	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
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
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getCart_state() {
		return cart_state;
	}
	public void setCart_state(String cart_state) {
		this.cart_state = cart_state;
	}
	
	@Override
	public String toString() {
		return "CartVo [cart_no=" + cart_no + ", book_no=" + book_no + ", book_count=" + book_count + ", user_no="
				+ user_no + ", cart_state=" + cart_state + "]";
	}
	
	
}
