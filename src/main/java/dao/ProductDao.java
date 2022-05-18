package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Product;

public class ProductDao {
	
	private Connection connection;
	private static final String SQL_SELECT_ID = "SELECT product_id, product_name, price FROM products WHERE product_id = ?";

	public ProductDao(Connection connection) {
	    this.connection = connection;
	}
	
	public Product findById(String id) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
            stmt.setInt(1, Integer.parseInt(id));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            } else {
                return null;
            }
         
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
