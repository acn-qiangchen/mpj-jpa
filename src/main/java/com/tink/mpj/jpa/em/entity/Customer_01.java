/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.em.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shearer
 */
@Entity(name = "CUSTOMER_PROFILE01")
public class Customer_01 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CustomEmbeddedPK id; 
    // firstName | lastName 
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthday;
    
    @Column(length = 200)
    private String address;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomEmbeddedPK getId() {
        return id;
    }

    public void setId(CustomEmbeddedPK id) {
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
        if (!(object instanceof Customer_01)) {
            return false;
        }
        Customer_01 other = (Customer_01) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tink.mpj.jpa.em.entity.Customer_01[ id=" + id + " ]";
    }
    
}
