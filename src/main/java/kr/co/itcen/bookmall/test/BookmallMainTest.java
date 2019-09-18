package kr.co.itcen.bookmall.test;
public class BookmallMainTest {

	public static void main(String[] args) {
		
		System.out.println("유저 리스트");
		UserDaoTest user = new UserDaoTest();
		user.user_GetList();
		
		System.out.println("\n카테고리 리스트");
		CategoryDaoTest category = new CategoryDaoTest();
		category.category_GetList();
		
		System.out.println("\n상품 리스트");
		BookDaoTest book = new BookDaoTest();
		book.book_GetList();
	
		System.out.println("\n카트 리스트");
		CartDaoTest cart = new CartDaoTest();		
		cart.cart_GetList();
		
		System.out.println("\n주문 리스트");
		OrderDaoTest order = new OrderDaoTest();
		order.order_GetList();
		
		System.out.println("\n주문 도서 리스트");
		OrderBookDaoTest orderBook = new OrderBookDaoTest();
		orderBook.orderBook_GetList();
	}

}
