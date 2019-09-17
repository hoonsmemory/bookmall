package kr.co.itcen.bookmall.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.OrderVo;


public class OrderDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public OrderDao(Connection _conn) {
		conn = _conn;
	}
	
	public boolean order_Insert(OrderVo order) {
		Boolean result = false;

		try {

			String sql = "insert into orders(order_no, order_price, order_adress, order_date,  user_no, order_state) "
					   + "values(null, ?, ?,now() ,?, 'Y')";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_price());
			pstmt.setString(2, order.getOrder_adress());
			pstmt.setInt(3, order.getUser_no());

			
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				order.setUser_no(rs.getInt(1));
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
	
	public ArrayList order_GetList() {
		ArrayList result = new ArrayList();
		
		try {
	
			String sql = "select orders.order_no, user.user_name, user.user_email, orders.order_price, orders.order_adress" + 
						 " from user, orders" + 
						 " where order_state = 'Y'" + 
					 	 " and user.user_no = orders.user_no" + 
						 " order by orders.order_date";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int order_no        = rs.getInt(1);
				String user_name    = rs.getString(2);
				String user_email   = rs.getString(3);
				int order_price     = rs.getInt(4);
				String order_adress = rs.getString(5);
				ArrayList tmp =  new ArrayList();
				
				tmp.add("주문 번호 = " + order_no);
				tmp.add("주문자 이름 = " + user_name);
				tmp.add("주문자 이메일 = " + user_email);
				tmp.add("주문 가격 = " + order_price);
				tmp.add("주문자 주소 = " + order_adress);
				
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
	
	public boolean order_Delete(OrderVo order) {
		Boolean result = false;

		try {

			String sql = "update orders set order_state = 'N' where user_no = ? and order_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setInt(1, order.getUser_no());
			pstmt.setInt(2, order.getOrder_no());

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
