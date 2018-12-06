/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "seller_person", catalog = "cargonam", schema = "common", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"seller_id", "person_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerPerson.findAll", query = "SELECT s FROM SellerPerson s")
    , @NamedQuery(name = "SellerPerson.findBySellerPersonId", query = "SELECT s FROM SellerPerson s WHERE s.sellerPersonId = :sellerPersonId")})
public class SellerPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seller_person_id", nullable = false)
    private Integer sellerPersonId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id", nullable = false)
    @ManyToOne(optional = false)
    private Seller sellerId;

    public SellerPerson() {
    }

    public SellerPerson(Integer sellerPersonId) {
        this.sellerPersonId = sellerPersonId;
    }

    public Integer getSellerPersonId() {
        return sellerPersonId;
    }

    public void setSellerPersonId(Integer sellerPersonId) {
        this.sellerPersonId = sellerPersonId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Seller getSellerId() {
        return sellerId;
    }

    public void setSellerId(Seller sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerPersonId != null ? sellerPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerPerson)) {
            return false;
        }
        SellerPerson other = (SellerPerson) object;
        if ((this.sellerPersonId == null && other.sellerPersonId != null) || (this.sellerPersonId != null && !this.sellerPersonId.equals(other.sellerPersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.SellerPerson[ sellerPersonId=" + sellerPersonId + " ]";
    }
    
}
