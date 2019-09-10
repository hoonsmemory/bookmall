package kr.co.itcen.bookmall.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement csmt = null;
	private ResultSet rs = null;

	public CategoryDao(Connection _conn) {
		conn = _conn;
	}
	
	public boolean category_Insert(CategoryVo category) {
		Boolean result = false;

		try {
			String sql = "insert into category(ctgr_no, ctgr_name) "
					+ "values(null, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getCtgr_name());


			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");

			if (rs.next()) {
				category.setCtgr_no(rs.getInt(1));
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

	public List<CategoryVo> category_GetList() {
		List<CategoryVo> result = new ArrayList<CategoryVo>();

		try {
			String sql = "select * from category order by ctgr_no asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);

				CategoryVo category = new CategoryVo();

				category.setCtgr_no(no);
				category.setCtgr_name(name);
			

				result.add(category);
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

	public boolean category_Update(CategoryVo category) {
		Boolean result = false;

		try {

			String sql = "update category set ctgr_name = ? where ctgr_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, category.getCtgr_name());
			pstmt.setLong(2, category.getCtgr_no());

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

	public boolean category_Delete(int category_no){
		Boolean result = false;

		try {

			String sql = "delete from category where ctgr_no = ?";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setLong(1, category_no);

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
