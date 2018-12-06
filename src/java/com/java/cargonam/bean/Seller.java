/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "seller", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
    , @NamedQuery(name = "Seller.findBySellerId", query = "SELECT s FROM Seller s WHERE s.sellerId = :sellerId")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seller_id", nullable = false)
    private Integer sellerId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerId")
    private Set<SellerPerson> sellerPersonSet;

    public Seller() {
    }

    public Seller(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Set<SellerPerson> getSellerPersonSet() {
        return sellerPersonSet;
    }

    public void setSellerPersonSet(Set<SellerPerson> sellerPersonSet) {
        this.sellerPersonSet = sellerPersonSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerId != null ? sellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.sellerId == null && other.sellerId != null) || (this.sellerId != null && !this.sellerId.equals(other.sellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Seller[ sellerId=" + sellerId + " ]";
    }
    
}
