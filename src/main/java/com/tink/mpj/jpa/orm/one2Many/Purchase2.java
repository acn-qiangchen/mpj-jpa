/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.one2Many;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author shearer
 */
@Entity
@Table(name="T_PURCHASE")
public class Purchase2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // scale not work...
    @Column(name="AMOUNT", precision = 8, scale = 2 )
    private double amout;
    
    // add a Member field to change to bydirectional
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="MEMBER_ID")
//    private Member2 member2;
//
//    public Member2 getMember2() {
//        return member2;
//    }
//
//    public void setMember2(Member2 member2) {
//        this.member2 = member2;
//    }
    
    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
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
        if (!(object instanceof Purchase2)) {
            return false;
        }
        Purchase2 other = (Purchase2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tink.mpj.jpa.orm.one2Many.Purchase2[ id=" + id + " ]";
    }
    
}
