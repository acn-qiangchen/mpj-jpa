/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.one2one;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;



/**
 *
 * @author shearer
 */
public class TestOne2One extends AbstractPersistentTest{

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testPersistMember1() {
         Member1 member = new Member1();
         member.setName("陳　強 31");
         member.setCarNo("1234");
         tx.begin();
         em.persist(member);
         tx.commit();
         
         assertNotNull(member.getId());
     }
     
     @Test
     public void testMerge(){
         Member1 member = em.find(Member1.class, 1L);
         
         member.setName("Shearer1");
         
         tx.begin();
         em.merge(member);
         tx.commit();
         
         Member1 mem = em.find(Member1.class, 1L);
         assertEquals(mem.getName(), "Shearer1");
         
         
     }
     
     @Test
     public void testFetchTicketWithMember(){
         Member1 member = new Member1();
         Ticket1 ticket = new Ticket1();
         member.setName("陳２");
         member.setCarNo("1111");
         ticket.setMember(member);
         ticket.setInTime(new Date());
         
         tx.begin();
         em.persist(ticket);
         em.persist(member);
         tx.commit();
         
         assertNotNull(member.getId());
         assertNotNull(ticket.getId());         
     }
     
     @Test
     public void testHello(){
         assertTrue(true);
     }
}