package com.tink.mpj.jpa.orm.one2Many;

import com.tink.mpj.jpa.orm.one2Many.Purchase2;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:07:41")
@StaticMetamodel(Member2.class)
public class Member2_ { 

    public static volatile SingularAttribute<Member2, Long> id;
    public static volatile ListAttribute<Member2, Purchase2> purchaseList;
    public static volatile SingularAttribute<Member2, String> carNo;
    public static volatile SingularAttribute<Member2, String> name;

}