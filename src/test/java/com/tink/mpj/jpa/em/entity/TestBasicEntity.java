/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.em.entity;

import com.tink.mpj.jpa.orm.one2one.AbstractPersistentTest;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shearer
 */
public class TestBasicEntity extends AbstractPersistentTest{
    
    public TestBasicEntity() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void entityWithEmbeddedId() {
         CustomEmbeddedPK pk = new CustomEmbeddedPK();
         pk.setLastName("chen");
         pk.setFirstName("qiang");
         
         Customer_01 customer = new Customer_01();
         Calendar calendar = new GregorianCalendar();
         calendar.set(2001, 01, 02);
         
         customer.setId(pk);
         customer.setBirthday(calendar.getTime());
         customer.setAddress("東京都港区");
         
//         tx.begin();
//         em.persist(customer);
//         tx.commit();
         
         Customer_01 c = em.find(Customer_01.class, pk);
         assertEquals(c.getId().getFirstName(), "qiang");
     }

     @Test
     public void entityWithClassId() {        
         Customer_02 customer = new Customer_02();
         Calendar calendar = new GregorianCalendar();
         calendar.set(2001, 01, 02);
         
         customer.setFirstName("qiang");
         customer.setLastName("chen");
         customer.setBirthday(calendar.getTime());
         customer.setAddress("東京都港区");
         
//         tx.begin();
//         em.persist(customer);
//         tx.commit();     
         
         Customer_02  c = em.find(Customer_02.class, new CustomPK("qiang", "chen"));
         assertEquals(c.getFirstName(), "qiang");
     }
     
     @Test
     public void entityBasic(){
         Customer customer = new Customer();
         Calendar calendar = new GregorianCalendar();
         calendar.set(2001, 01, 02);
         
         customer.setFirstName("qiang");
         customer.setLastName("chen");
         customer.setBirthday(calendar.getTime());
         customer.setAddress("東京都港区");
         
         tx.begin();
         em.persist(customer);
         tx.commit();  
         
         assertNotNull(customer.getId());
     }
     
     @Test
     public void testFindAndUpdate(){
         Customer_02  cust = em.find(Customer_02.class, new CustomPK("qiang", "chen"));
         
         tx.begin();
         //update customer
         cust.setAddress("new address1");
         tx.commit();

         Customer_02  c = em.find(Customer_02.class, new CustomPK("qiang", "chen"));
         assertEquals(c.getAddress(), "new address1");
     }
     
     @Test 
     public void testMerge(){
         // find Customer
         Customer_02  cust = em.find(Customer_02.class, new CustomPK("qiang", "chen"));
  
         //customerがEM管理対象外にする
         em.clear();
         cust.setAddress("new address2");

         tx.begin();
         //update customer
         em.merge(cust);
         tx.commit();

         Customer_02  c = em.find(Customer_02.class, new CustomPK("qiang", "chen"));
         assertEquals(c.getAddress(), "new address2");
         
     }
     
     @Test
     public void testJpqlQuery(){
         String jpql = "select c from com.tink.mpj.jpa.em.entity.Customer c";
         TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
         //query.setParameter("firstName", "qiang");
         query.setMaxResults(10);        
         List<Customer> customerList = query.getResultList();
         
         assertTrue(customerList.size() > 0);
         
     }

     
}