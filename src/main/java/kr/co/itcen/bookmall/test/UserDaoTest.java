package kr.co.itcen.bookmall.test;
import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.UserVo;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;




public class UserDaoTest {
	
	private UserDao user = null;
	private Connection conn = null;
	
	private UserDaoTest()
	{
		try {
			connectDB();
			user = new UserDao(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("디비연결 실패:"+e.getMessage());
		} 
	}
	
	private void connectDB() throws Exception
	{
		conn = ConnectionPool.getInstance();

	}
	
	//유저 저장
	private void user_Insert(UserVo vo) {
		user.user_Insert(vo);	
	}
	
	//유저리스트 출력
	private void user_GetList() {
		
		List<UserVo> list = user.user_GetList();
		
		for(UserVo vo : list) {
			System.out.println(vo);
		}
	}
	
	//유저 핸드폰번호 변경
	private void user_Update(UserVo vo) {
		user.user_Update(vo);
	}
	
	//유저 삭제 
	private void user_Delete(UserVo vo) {
		user.user_Delete(vo);
	}
	
	
	public static void main(String[] args) {
		UserDaoTest user = new UserDaoTest();
		//user.user_Insert(new UserVo("김성훈", "W", "01039173386", "dltjdgnsok1@naver.com", "1234"));
		//user.user_Update(new UserVo("01012345678",1,"1234"));
		//user.user_Delete(new UserVo(1,"1234"));
		user.user_GetList();
	}
}
