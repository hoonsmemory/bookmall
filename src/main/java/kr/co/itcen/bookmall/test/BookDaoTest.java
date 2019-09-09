package kr.co.itcen.bookmall.test;
import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.vo.BookVo;


import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


public class BookDaoTest {
	
	private BookDao book = null;
	private Connection conn = null;
	
	private BookDaoTest()
	{
		try {
			connectDB();
			book = new BookDao(conn);
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

	//도서 저장
	private void book_Insert(BookVo vo) {
		book.book_Insert(vo);	
	}
	
	//도서리스트 출력
	private void book_GetList() {
		
		List<BookVo> list = book.book_GetList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	//도서 변경
	private void book_Update(BookVo vo) {
		book.book_Update(vo);
	}
	
	//도서 삭제
	private void book_Delete(int book_no) {
		book.book_Delete(book_no);
	}

	public static void main(String[] args) {
		BookDaoTest book = new BookDaoTest();
		//book.book_Update(new BookVo("데이터베이스책",2));
		//book.book_Insert(new BookVo("book_name", 10000, 1, 1, "Y", time1, new Date(0)));
		book.book_Delete(2);
		book.book_GetList();
		
		
	}

}
