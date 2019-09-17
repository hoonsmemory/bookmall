package kr.co.itcen.bookmall.test;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderBookDaoTest {
	private OrderBookDao orderBook = null;
	private Connection conn = null;
	
	private OrderBookDaoTest()
	{
		try {
			connectDB();
			orderBook = new OrderBookDao(conn);
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
	
	// 주문한 책 저장(책번호, 책수량, 유저번호)
	private void orderBook_Insert(OrderBookVo vo) {
		orderBook.orderBook_Insert(vo);	
	}
	
	// 주문한 책 목록
	private void orderBook_GetList() {
		
		ArrayList list = orderBook.orderBook_GetList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		OrderBookDaoTest orderBook = new OrderBookDaoTest();
		//orderBook.orderBook_Insert(new OrderBookVo(18, 7, 1));
		orderBook.orderBook_GetList();

	}
}
