package kr.co.itcen.bookmall.test;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.ConnectionPool;
import kr.co.itcen.bookmall.vo.CartVo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;





public class CartDaoTest {
	private CartDao cart = null;
	private Connection conn = null;
	
	private CartDaoTest()
	{
		try {
			connectDB();
			cart = new CartDao(conn);
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
	
	//카트 담기
	private void cart_Insert(CartVo vo) {
		cart.cart_Insert(vo);	
	}
	
	//전체 카트리스트 출력(유저이름, 책이름, 구매수)
	private void cart_GetList() {
		
		ArrayList list =  cart.cart_GetList();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	//카트 수량 변경
	private void cart_Update(CartVo vo) {
		cart.cart_Update(vo);
	}
	
	
	
	
	public static void main(String[] args) {
		CartDaoTest cart = new CartDaoTest();
		//cart.cart_Insert(new CartVo(1,2,5));
		//cart.cart_Update(new CartVo(1, 2, 10));
		cart.cart_GetList();
		
		
	}
}
