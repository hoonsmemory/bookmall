package kr.co.itcen.bookmall.test;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;


public class OrderDaoTest {
	private OrderDao order = null;
	private Connection conn = null;
	
	public OrderDaoTest()
	{
		try {
			connectDB();
			order = new OrderDao(conn);
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
	
	//주문서 저장(가격,주소,유저번호)
	public void order_Insert(OrderVo vo) {
		order.order_Insert(vo);	
	}
	
	//전체 주문리스트 출력(주문번호, 주문자, 이메일, 결제금액, 배송지)
	public void order_GetList() {
		
		ArrayList list = order.order_GetList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	//주문 취소 
	public void order_Delete(OrderVo vo) {
		order.order_Delete(vo);
	}
	
	public static void main(String[] args) {
		OrderDaoTest order = new OrderDaoTest();
		//order.order_Insert(new OrderVo(200000, "서울비트교육센터", 1));
		//order.order_Delete(new OrderVo(1,1));
		
		order.order_GetList();
	}
}
