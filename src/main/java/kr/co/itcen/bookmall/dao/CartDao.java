package kr.co.itcen.bookmall.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;



public class CartDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public CartDao(Connection _conn) {
		conn = _conn;
	}
	
	public boolean cart_Insert(CartVo cart) {
		Boolean result = false;

		try {
			String sql = "insert into cart(cart_no, user_no, book_no, book_count,  cart_state) "
					   + "values(null, ?, ?, ?, 'Y')";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getUser_no());
			pstmt.setInt(2, cart.getBook_no());
			pstmt.setInt(3, cart.getBook_count());

			
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				cart.setUser_no(rs.getInt(1));
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

	
	public ArrayList cart_GetList() {
		ArrayList result = new ArrayList();
		
		try {
	
			String sql = "select user.user_name, book.book_name, cart.book_count, cart.book_count * book.book_price" + 
					" from user , book, cart" + 
					" where 1 = 1 " + 
					" and user.user_no = cart.user_no"  + 
					" and book.book_no = cart.book_no" + 
					" order by user.user_name asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String user_name = rs.getString(1);
				String book_name = rs.getString(2);
				int book_count   = rs.getInt(3);
				int all_price    = rs.getInt(4);
				ArrayList tmp =  new ArrayList();
				
				tmp.add(user_name);
				tmp.add(book_name);
				tmp.add(book_count);
				tmp.add(all_price);
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

	public boolean cart_Update(CartVo cart) {
		Boolean result = false;

		try {

			String sql = "update cart set book_count = ? where user_no = ? and book_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setInt(1, cart.getBook_count());
			pstmt.setInt(2, cart.getUser_no());
			pstmt.setInt(3, cart.getBook_no());
			

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
