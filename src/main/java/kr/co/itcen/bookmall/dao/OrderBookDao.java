package kr.co.itcen.bookmall.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public OrderBookDao(Connection _conn) {
		conn = _conn;
	}

	public boolean orderBook_Insert(OrderBookVo orderBook) {
		Boolean result = false;

		try {

			String sql = "insert into orderlist(odlist_no, book_no, book_count, order_no) " + "values(null, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderBook.getBook_no());
			pstmt.setInt(2, orderBook.getBook_count());
			pstmt.setInt(3, orderBook.getOrder_no());

			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				orderBook.setOdlist_no(rs.getInt(1));
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
					// conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList orderBook_GetList() {
		ArrayList result = new ArrayList();

		try {

			String sql = "select orders.order_no, user.user_name, book.book_no, book.book_name, orderlist.book_count" + 
						"  from user, orders, book, orderlist" + 
						" where orders.order_no = orderlist.order_no" + 
						"   and orders.order_state = 'Y'" + 
						"   and orders.user_no  = user.user_no" + 
						"   and orderlist.book_no = book.book_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int order_no = rs.getInt(1);
				String user_name = rs.getString(2);
				int book_no = rs.getInt(3);
				String book_name = rs.getString(4);
				int book_count = rs.getInt(5);

				ArrayList tmp = new ArrayList();

				tmp.add("주문 번호 = " + order_no);
				tmp.add("유저 네임 = " + user_name);
				tmp.add("책 번호 = " + book_no);
				tmp.add("책 이름 = " + book_name);
				tmp.add("주문 갯수 = " + book_count);

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
					// conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
