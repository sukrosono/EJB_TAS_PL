/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enter
 */
public class OrdersQ {

  private static Logger logger = Logger.getLogger(OrdersQ.class.getName());
  private static Connection conn = new DbConn().getConnection();

  public static ArrayList<Order> selectAll() {
    ArrayList<Order> data = null;
    Statement statement = null;
    ResultSet rs = null;
    try {
      statement = conn.createStatement();
      rs = statement.executeQuery("SELECT * FROM orders");
      if (!rs.wasNull()) {
        data = new ArrayList<Order>();
      }
      while (rs.next()) {
        Order o = new Order(rs.getString("table_number"), rs.getString("name"));
        data.add(o);
        o.id_order = rs.getInt("id_order");
        o.drinks_order = rs.getString("drinks_order");
        o.foods_order = rs.getString("foods_order");
        o.total_price = rs.getLong("total_price");
      }
    } catch (SQLException e) {
      logger.log(Level.SEVERE, e.toString());
    }
    return data;
  }

  public static Boolean newOrder(Order o) {
    int rowAffected = 0;
    try {
      PreparedStatement statement = conn.prepareStatement(
              "INSERT INTO orders(table_number, name, foods_order, drinks_order, total_price)"
              + "VALUES(?,?,?,?,?)");
      statement.setString(1, o.table_number);
      statement.setString(2, o.name);
      statement.setString(3, o.foods_order);
      statement.setString(4, o.drinks_order);
      statement.setLong(5, o.total_price);
      rowAffected = statement.executeUpdate();
    } catch (SQLException ex) {
      logger.log(Level.SEVERE, null, ex);
      logger.log(Level.SEVERE, ex.getMessage());
      
      ex.printStackTrace();
    }
    return rowAffected != 0;
  }


  public static Order getWhere(int id) {
    Order o = null;
    try {
      PreparedStatement statement = conn.prepareStatement("SELECT * FROM orders WHERE id=?");
      statement.setInt(1, id);
      ResultSet rs = statement.executeQuery();
      if (rs.first()) {
        o = new Order(rs.getString("table_number"), rs.getString("name"));
        o.id_order = id;
        o.foods_order = rs.getString("foods_order");
        o.drinks_order = rs.getString("drinks_order");
        o.total_price = rs.getLong("total_price");
      }
    } catch (SQLException e) {
      logger.log(Level.SEVERE, e.toString());
    }
    return o;
  }

  public static boolean update(int id, Order o) {
    int rowAffected = 0;
    try {
      PreparedStatement statement = conn.prepareStatement("UPDATE orders SET "
              + "id_order=?, table_number=?, name=? , foods_order=?, drinks_order=?, total_price=? "
              + " WHERE id_order=?");
      statement.setInt(1, o.id_order);
      statement.setString(2, o.table_number);
      statement.setString(3, o.name);
      statement.setString(4, o.foods_order);
      statement.setString(5, o.drinks_order);
      statement.setLong(6, o.total_price);
      statement.setInt(7, id);
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) {
      logger.log(Level.SEVERE, e.toString());
    }
    return rowAffected != 0;
  }

  public static boolean delete(int id) {
    int rowAffected = 0;
    try {
      PreparedStatement statement = conn.prepareStatement("DELETE FROM orders WHERE id_order=? ");
      statement.setInt(1, id);
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) {
      logger.log(Level.SEVERE, e.toString());
    }
    return rowAffected != 0;
  }
}
