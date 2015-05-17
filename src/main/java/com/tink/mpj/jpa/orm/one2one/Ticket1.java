/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.one2one;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shearer
 */
@Entity
@Table(name="T_TICKET")
public class Ticket1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="IN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inTime;
    
    @Column(name="OUT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outTime;

    @OneToOne(
            //cascade = {CascadeType.PERSIST},
            fetch = FetchType.EAGER
            )
    @JoinColumn(name = "MEMBER_ID")
    private Member1 member;

    public Member1 getMember() {
        return member;
    }

    public void setMember(Member1 member) {
        this.member = member;
    }
    
    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Ticket1)) {
            return false;
        }
        Ticket1 other = (Ticket1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tink.mpj.jpa.orm.one2one.Ticket1[ id=" + id + " ]";
    }
    
}
