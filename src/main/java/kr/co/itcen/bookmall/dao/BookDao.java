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
					+ "values(null, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBook_name());
			pstmt.setInt(2, book.getBook_price());
			pstmt.setInt(3, book.getCtgr_no());
			pstmt.setInt(4, book.getDsct_no());
			pstmt.setString(5, book.getBook_state());
			pstmt.setDate(6, book.getBook_fromdd());
			pstmt.setDate(7, book.getBook_todd());

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
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<BookVo> book_GetList() {
		List<BookVo> result = new ArrayList<BookVo>();

		try {
			// book_no, book_name, book_price, ctgr_no, dsct_no, book_state, book_fromdd,
			// book_todd
			String sql = "select * from book where book_state = 'Y'  order by book_no asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int ctgr_no = rs.getInt(4);
				int dsct_no = rs.getInt(5);
				String state = rs.getString(6);
				Date fromdd = rs.getDate(7);
				Date todd = rs.getDate(8);

				BookVo book = new BookVo();

				book.setBook_no(no);
				book.setBook_name(name);
				book.setBook_price(price);
				book.setCtgr_no(ctgr_no);
				book.setDsct_no(dsct_no);
				book.setBook_state(state);
				book.setBook_fromdd(fromdd);
				book.setBook_todd(todd);

				result.add(book);
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
					conn.close();
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
					conn.close();
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
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
}
