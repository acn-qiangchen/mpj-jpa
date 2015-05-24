/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.em.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shearer
 */
@Entity(name = "CUSTOMER_PROFILE02")
@IdClass(CustomPK.class)
public class Customer_02 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String firstName;
    @Id
    private String lastName;
    
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
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}
