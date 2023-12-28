package data;
import java.util.ArrayList;

import java.util.ArrayList;
import java.sql.Timestamp;
//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Articles;
import model.BlogPosts;
import model.Box;
import model.NFT;
import model.Tweets;
public interface DataReader {
    Connection getConnection() throws SQLException, ClassNotFoundException;
    // Các phương thức khác nếu cần
}