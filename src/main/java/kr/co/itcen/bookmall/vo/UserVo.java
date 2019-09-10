package kr.co.itcen.bookmall.vo;

public class UserVo {
	private int user_no;
	private String user_name;
	private String user_sex;
	private String user_pno;
	private String user_email;
	private String user_pw;
	private int rate_no;
	private String user_state;
	private String user_fromdd;
	private String user_todd;
	
	public UserVo() {}
	
	// 유저회원가입
	public UserVo(String user_name, String user_sex, String user_pno, String user_email, String user_pw) {
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_pno = user_pno;
		this.user_email = user_email;
		this.user_pw = user_pw;
	}
	
	// 폰넘버 변경
	public UserVo(String user_pno, int user_no, String user_pw) {
		this.user_pno = user_pno;
		this.user_no  = user_no;
		this.user_pw  = user_pw;
	}
	
	public UserVo(int user_no, String user_pw) {
		this.user_no = user_no;
		this.user_pw = user_pw;	
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_pno() {
		return user_pno;
	}
	public void setUser_pno(String user_pno) {
		this.user_pno = user_pno;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public int getRate_no() {
		return rate_no;
	}
	public void setRate_no(int rate_no) {
		this.rate_no = rate_no;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_fromdd() {
		return user_fromdd;
	}
	public void setUser_fromdd(String user_fromdd) {
		this.user_fromdd = user_fromdd;
	}
	public String getUser_todd() {
		return user_todd;
	}
	public void setUser_todd(String user_todd) {
		this.user_todd = user_todd;
	}
	
	@Override
	public String toString() {
		return "UserVo [user_no=" + user_no + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_pno="
				+ user_pno + ", user_email=" + user_email + ", user_pw=" + user_pw + ", rate_no=" + rate_no
				+ ", user_state=" + user_state + ", user_fromdd=" + user_fromdd + ", user_todd=" + user_todd + "]";
	}
	
}
