/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author enter
 */
public class Order {
//  id auto increment

  public int id_order;
  public String table_number;
  public String name;
  public String foods_order;
  public String drinks_order;
  public Long total_price;
  Logger logger = Logger.getLogger(Order.class.getName());

  public Order(String table_number, String name) {
    this.table_number = table_number;
    this.name = name;
  }

  public Order() {
  }

//  public Long Calculate_price(String f_o, String d_o) {
//    Long returnVal = 0L;
//    try {
//      //    drinks_order + foods_oder use dataService
//      JSONParser parser = new JSONParser();
//      JSONArray drinks = (JSONArray) parser.parse(d_o);
//      JSONArray foods = (JSONArray) parser.parse(f_o);
//      if (!drinks.isEmpty()) {
//        for (Object drink : drinks) {
//          JSONObject d = (JSONObject) parser.parse(drink.toString());
//          Long current_price = 0L;
////        menggunakan web service
////          int price = getData("drink", d.get("name").toString());
////          current_price = new Long(price * Integer.parseInt(d.get("qty").toString()));
//          returnVal += current_price;
//          logger.log(Level.SEVERE, "drink is " + drink.toString());
//          logger.log(Level.SEVERE, "current p  " + current_price);
//        }
//      }
//      if (!foods.isEmpty()) {
//        for (Object food : foods) {
//          JSONObject f = (JSONObject) parser.parse(food.toString());
//          Long current_price = 0L;
////        menggunakan web service
////          int price = getData("drink", f.get("name").toString());
////          current_price = new Long(price * Integer.parseInt(f.get("qty").toString()));
//          returnVal += current_price;
//        }
//      }
//    } catch (ParseException ex) {
//      Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return returnVal;
//  }
  
}
