package com.tink.mpj.jpa.orm.one2one;

import com.tink.mpj.jpa.orm.one2one.Ticket1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:07:41")
@StaticMetamodel(Member1.class)
public class Member1_ { 

    public static volatile SingularAttribute<Member1, Long> id;
    public static volatile SingularAttribute<Member1, String> carNo;
    public static volatile SingularAttribute<Member1, Ticket1> ticket;
    public static volatile SingularAttribute<Member1, String> name;

}