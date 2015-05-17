/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.many2Many;

import com.tink.mpj.jpa.orm.one2one.AbstractPersistentTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shearer
 */
public class TestMany2Many extends AbstractPersistentTest{
    
    public TestMany2Many() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testMany2ManyPersist() {
         List<Book> bookList = new ArrayList<Book>();
         bookList.add(new Book("JAVA Beginner"));
         bookList.add(new Book("JPA Developer"));
         bookList.add(new Book("JEE7 Master"));
         
         Author author = new Author("GuyABC");
         author.setBookList(bookList);
         
         tx.begin();
         em.persist(author);
         for(Book book : author.getBookList()){
             em.persist(book);
         }
         tx.commit();
         
         assertNotNull(author.getId());
         assertNotNull(author.getBookList().get(0).getId());
     }
}