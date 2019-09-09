package kr.co.itcen.bookmall.vo;

import java.sql.Date;

public class BookVo {
	private int book_no;
	private String book_name;
	private int book_price;
	private int ctgr_no;
	private int dsct_no;
	private String book_state;
	private Date book_fromdd;
	private Date book_todd;
	
	public BookVo() {}
	
	public BookVo(String book_name, int book_price, int ctgr_no, int dsct_no, String book_state, Date book_fromdd, Date book_todd) {
		this.book_name   = book_name;
		this.book_price  = book_price;
		this.ctgr_no     = ctgr_no;
		this.dsct_no     = dsct_no;
		this.book_state  = book_state;
		this.book_fromdd = book_fromdd;
		this.book_todd   = book_todd;
	}
	
	public BookVo(String book_name, int book_no) {
		this.book_name   = book_name;
		this.book_no  = book_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getCtgr_no() {
		return ctgr_no;
	}
	public void setCtgr_no(int ctgr_no) {
		this.ctgr_no = ctgr_no;
	}
	public int getDsct_no() {
		return dsct_no;
	}
	public void setDsct_no(int dsct_no) {
		this.dsct_no = dsct_no;
	}
	public String getBook_state() {
		return book_state;
	}
	public void setBook_state(String book_state) {
		this.book_state = book_state;
	}
	public Date getBook_fromdd() {
		return book_fromdd;
	}
	public void setBook_fromdd(Date book_fromdd) {
		this.book_fromdd = book_fromdd;
	}
	public Date getBook_todd() {
		return book_todd;
	}
	public void setBook_todd(Date book_todd) {
		this.book_todd = book_todd;
	}
	
	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", book_name=" + book_name + ", book_price=" + book_price + ", ctgr_no="
				+ ctgr_no + ", dsct_no=" + dsct_no + ", book_state=" + book_state + ", book_fromdd=" + book_fromdd
				+ ", book_todd=" + book_todd + "]";
	}

}
