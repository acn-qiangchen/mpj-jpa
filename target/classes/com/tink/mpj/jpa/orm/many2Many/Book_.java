package com.tink.mpj.jpa.orm.many2Many;

import com.tink.mpj.jpa.orm.many2Many.Author;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:07:41")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> tittle;
    public static volatile ListAttribute<Book, Author> authorList;

}