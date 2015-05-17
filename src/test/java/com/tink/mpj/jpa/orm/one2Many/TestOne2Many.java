/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.one2Many;

import com.tink.mpj.jpa.orm.one2one.AbstractPersistentTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shearer
 */
public class TestOne2Many extends AbstractPersistentTest {
    
    public TestOne2Many() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestPersistPurchase() {
         Purchase2 pur = new Purchase2();
         pur.setAmout(2001);
         
         tx.begin();
         em.persist(pur);
         tx.commit();
         
         assertNotNull(pur.getId());
     }
     
     @Test
     public void TestOne2ManyUnidirectional(){
         List<Purchase2> purList = new ArrayList<Purchase2>();
         Purchase2 pur = new Purchase2();
         pur.setAmout(10000);
         purList.add(pur);
         
         pur=new Purchase2();
         pur.setAmout(30010);
         purList.add(pur);
         
         Member2 mem = new Member2();
         mem.setName("駐車００１");
         mem.setCarNo("1122");
         mem.setPurchaseList(purList);

         tx.begin();
         // note that since the Purchase is cascade.persist
         // we don't have to persist Member
         em.persist(mem);
         tx.commit();
         
         assertNotNull(mem.getId());
         assertEquals(2, mem.getPurchaseList().size());
         assertEquals("30010.0", String.valueOf(mem.getPurchaseList().get(1).getAmout()));
         
     }
     
     @Test
     public void TestOneToManyBydirectional(){
//         Purchase2 pur = em.find(Purchase2.class, 1102L);
//         assertNotNull(pur);
//         assertEquals(pur.getMember2().getId().toString(), "1101");
     }
}