package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jp2";
    static final String USER = "root";
    static final String PASSWORD = "";

    private Connection connection;

    public Database(){
        this.init();
    }

    public void init(){
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return connection;
    }
    public void setConn(Connection conn){
        this.connection = conn;
    }
}
