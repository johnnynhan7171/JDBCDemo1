package dao;

import configuration.Database;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    public static Database database = new Database();
    
    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbProduct";
            Statement statement = database.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Price"),
                        resultSet.getInt("QOH")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * " +
                    "FROM tbProduct " +
                    "WHERE " +
                    "Name LIKE ?";
            PreparedStatement statement = database.getConn().prepareStatement(sql);
            statement.setString(1,"%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Price"),
                        resultSet.getInt("QOH")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public int insProduct(List<Product> products) {
        int results = -1;
        try {
            String sql = "INSERT INTO " +
                    "tbProduct " +
                    "(Name, Price, QOH) " +
                    "VALUES " +
                    "(?,?,?)";
            PreparedStatement statement = database.getConn().prepareStatement(sql);
            for (int i = 0; i<products.size(); i++) {
                statement.setString(1, products.get(i).getName());
                statement.setInt(2, products.get(i).getPrice());
                statement.setInt(3, products.get(i).getQOH());
                statement.addBatch();
                results++;
            }
            statement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }
}
