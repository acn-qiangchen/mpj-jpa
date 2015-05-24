package com.tink.mpj.jpa.em.entity;

import com.tink.mpj.jpa.em.entity.CustomEmbeddedPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:37:45")
@StaticMetamodel(Customer_01.class)
public class Customer_01_ { 

    public static volatile SingularAttribute<Customer_01, CustomEmbeddedPK> id;
    public static volatile SingularAttribute<Customer_01, Date> birthday;
    public static volatile SingularAttribute<Customer_01, String> address;

}