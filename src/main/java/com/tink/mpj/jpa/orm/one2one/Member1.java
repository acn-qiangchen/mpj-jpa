/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.one2one;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

/**
 *
 * @author shearer
 */
@Entity
@Table(name="T_MEMBER")
public class Member1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 30, name = "NAME")
    private String name;
    
    @Column(length=4, name = "CAR_NO")
    private String carNo;
    
    // without the ticket field, relationship is unidirectional (ticket -> member)
    // with the ticket field, relationship is bidirectional, 
    //      while oneToOne(mappedBy ...) is required.
    // DB structure is the same (IMPORTANT!)
    // oneToOne bidirectional. owner is Ticket.
     @OneToOne(mappedBy = "member")
    private Ticket1 ticket;

//    public Ticket1 getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Ticket1 ticket) {
//        this.ticket = ticket;
//    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tink.mpj.jpa.orm.one2one.Member1[ id=" + id + " ]";
    }
    
}
