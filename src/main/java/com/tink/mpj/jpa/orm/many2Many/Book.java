/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tink.mpj.jpa.orm.many2Many;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author shearer
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    public Book() {
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME", nullable = false, length = 50)
    private String tittle;
    
    // book is the relationship owner
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "T_BOOK_AUTHOR",
            joinColumns = {@JoinColumn(name = "AUTHOR_NM")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")}
            )
    private List<Author> authorList;
    
    public Long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public Book(String tittle) {
        this.tittle = tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tink.mpj.jpa.orm.many2Many.Book[ id=" + id + " ]";
    }
    
}
