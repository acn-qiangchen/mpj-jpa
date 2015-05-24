package com.tink.mpj.jpa.orm.one2one;

import com.tink.mpj.jpa.orm.one2one.Member1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-24T00:07:41")
@StaticMetamodel(Ticket1.class)
public class Ticket1_ { 

    public static volatile SingularAttribute<Ticket1, Long> id;
    public static volatile SingularAttribute<Ticket1, Member1> member;
    public static volatile SingularAttribute<Ticket1, Date> inTime;
    public static volatile SingularAttribute<Ticket1, Date> outTime;

}