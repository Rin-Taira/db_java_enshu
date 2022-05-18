package service;

import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {

    public Product search(String id) {
        try (Connection conn = DbUtil.getConnection()) {
            ProductDao productDao = new ProductDao(conn);
            Product product = productDao.findById(id);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

