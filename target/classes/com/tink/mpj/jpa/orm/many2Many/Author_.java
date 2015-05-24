package com.tink.mpj.jpa.orm.many2Many;

import com.tink.mpj.jpa.orm.many2Many.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:07:41")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, Long> id;
    public static volatile ListAttribute<Author, Book> bookList;
    public static volatile SingularAttribute<Author, String> name;

}