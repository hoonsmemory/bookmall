package kr.co.itcen.bookmall.dao;

import kr.co.itcen.bookmall.vo.BookVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public BookDao(Connection _conn) {
		conn = _conn;
	}

	public boolean book_Insert(BookVo book) {
		Boolean result = false;

		try {
			String sql = "insert into book(book_no, book_name, book_price, ctgr_no, dsct_no, book_state, book_fromdd, book_todd) "
					+ "values(null, ?, ?, ?, ?, 'Y', now(), now())";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBook_name());
			pstmt.setInt(2, book.getBook_price());
			pstmt.setInt(3, book.getCtgr_no());
			pstmt.setInt(4, book.getDsct_no());

			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				book.setBook_no(rs.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					//conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList book_GetList() {
		ArrayList result = new ArrayList();
	
		try {
			String sql = "select book_name, book_price, ctgr_name" + 
						 " from book, category" + 
						 " where book_state = 'Y'" + 
						 " and book.ctgr_no = category.ctgr_no" + 
						 " order by book_no asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				String ctgr_name = rs.getString(3);

				ArrayList tmp =  new ArrayList();

				tmp.add("책이름 = " + name);
				tmp.add("가격 = " + price + "원");
				tmp.add("카테고리 = " + ctgr_name);

				result.add(tmp);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					//conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean book_Update(BookVo book) {
		Boolean result = false;

		try {

			String sql = "update book set book_name = ? where book_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, book.getBook_name());
			pstmt.setLong(2, book.getBook_no());

			// 5. SQL문 실행
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException :  " + e);
		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					//conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	public boolean book_Delete(int book_no){
		Boolean result = false;

		try {

			String sql = "update book set book_state = 'N' , book_todd = now() where book_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setLong(1, book_no);

			// 5. SQL문 실행
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException :  " + e);
		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					//conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
}
