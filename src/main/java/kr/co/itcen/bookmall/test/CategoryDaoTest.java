package kr.co.itcen.bookmall.test;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.vo.CategoryVo;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


public class CategoryDaoTest {
	
	private CategoryDao category = null;
	private Connection conn = null;
	
	public CategoryDaoTest()
	{
		try {
			connectDB();
			category = new CategoryDao(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("디비연결 실패:"+e.getMessage());
		} 
	}
	
	public void connectDB() throws Exception
	{
		conn = ConnectionPool.getInstance();

	}
	
	//카테고리 저장
	public void category_Insert(CategoryVo vo) {
		category.category_Insert(vo);	
	}
	
	//카테고리리스트 출력
	public void category_GetList() {
		
		List<CategoryVo> list = category.category_GetList();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	//카테고리 변경
	public void category_Update(CategoryVo vo) {
		category.category_Update(vo);
	}
	
	//도서 삭제
	public void category_Delete(int category_no) {
		category.category_Delete(category_no);
	}
	
	
	public static void main(String[] args) {
		CategoryDaoTest category = new CategoryDaoTest();
		//category.category_Insert(new CategoryVo("인문"));
		//category.category_Update(new CategoryVo("유아",5));
		//category.category_Delete(7);
		category.category_GetList();
		
	}

}
