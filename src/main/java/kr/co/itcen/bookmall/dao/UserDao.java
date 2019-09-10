package kr.co.itcen.bookmall.dao;
import kr.co.itcen.bookmall.vo.UserVo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public UserDao(Connection _conn) {
		conn = _conn;
	}
	
	public boolean user_Insert(UserVo user) {
		Boolean result = false;
		
		try {
			String sql = "insert into user(user_no, user_name, user_sex, user_pno, user_email, user_pw, rate_no, user_state, user_fromdd, user_todd) "
					   + "values(null, ?, ?, ?, ?, ?, 5, 'Y', now() , now())";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_sex());
			pstmt.setString(3, user.getUser_pno());
			pstmt.setString(4, user.getUser_email());
			pstmt.setString(5, user.getUser_pw());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				user.setUser_no(rs.getInt(1));
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

	public List<UserVo> user_GetList() {
		List<UserVo> result = new ArrayList<UserVo>();

		try {
			String sql = "select * from user where user_state = 'Y'order by user_no asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int user_no       = rs.getInt(1);
				String user_name  = rs.getString(2);
				String user_sex   = rs.getString(3);
				String user_pno   = rs.getString(4);
				String user_email = rs.getString(5);
				//String user_pw    = rs.getString(6);
				int rate_no    = rs.getInt(7);
				
				UserVo user = new UserVo();

				user.setUser_no(user_no);
				user.setUser_name(user_name);
				user.setUser_sex(user_sex);
				user.setUser_pno(user_pno);
				user.setUser_email(user_email);
				user.setRate_no(rate_no);		

				result.add(user);
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

	public boolean user_Update(UserVo user) {
		Boolean result = false;

		try {

			String sql = "update user set user_pno = ? where user_no = ? and user_pw = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, user.getUser_pno());
			pstmt.setLong(2, user.getUser_no());
			pstmt.setString(3, user.getUser_pw());

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

	public boolean user_Delete(UserVo user){
		Boolean result = false;

		try {

			String sql = "update user set user_state = 'N' , user_todd = now() where user_no = ? and user_pw = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setInt(1, user.getUser_no());
			pstmt.setString(2, user.getUser_pw());
			
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
