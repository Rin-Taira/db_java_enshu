import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		
		ProductDao productDao;
		Connection connection;
		
		connection = DbUtil.getConnection();
		
		productDao = new ProductDao(connection);

		// レコードを登録
		Product newProduct = new Product(null, "ボールペン", 200);
		productDao.register(newProduct);
		
		// 全レコードを表示
		List<Product> list = productDao.findAll();
		
		for (Product p: list) {
			String message = "";
			message += "product_id:" + p.getProductId();
			message += ", product_name:" + p.getProductName();
			message += ", price:" + p.getPrice();
			System.out.println(message);
		}
        
	}
}