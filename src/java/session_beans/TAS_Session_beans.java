/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import database.Order;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.xml.ws.BindingProvider;
import database.OrdersQ;
import java.util.ArrayList;

/**
 *
 * @author enter
 */
@Stateless(mappedName= "TAS_Session_beans")
//@SessionScoped
@LocalBean
public class TAS_Session_beans {

  Logger logger = Logger.getLogger(TAS_Session_beans.class.getName());
  BindingProvider bindingProvider;

  public TAS_Session_beans() {
    logger.log(Level.SEVERE, "bean constructed");
//    try {
//      ds = service.getDataServicePort();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

//    try {
//      ds = service.getDataServicePort();
//      bindingProvider = (BindingProvider) ds;
//      bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/pl_tts/DataService?wsdl");

//      Service s = Service.create(new URL("http://localhost:8080/pl_tts/DataService?wsdl"), new QName("http://ws/", "DataService"));
//      ds = s.getPort(DataService.class);
//      System.out.println("ds is " + ds.toString());
//    } catch (Exception e) {
//      logger.log(Level.SEVERE, "e: " + e.getMessage());
//      e.printStackTrace();
//    }
  }
  
  public boolean insert_new_order(Order o) {
    return OrdersQ.newOrder(o);
  }
  
  public ArrayList<Order> getsOrder() {
    return OrdersQ.selectAll();
  }
  
  public boolean erase(int id) {
    return OrdersQ.delete(id);
  }
}
