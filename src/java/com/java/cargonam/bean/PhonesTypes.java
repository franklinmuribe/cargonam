/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "phones_types", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhonesTypes.findAll", query = "SELECT p FROM PhonesTypes p")
    , @NamedQuery(name = "PhonesTypes.findByPhonesTypeId", query = "SELECT p FROM PhonesTypes p WHERE p.phonesTypeId = :phonesTypeId")
    , @NamedQuery(name = "PhonesTypes.findByPhonesTypeDescription", query = "SELECT p FROM PhonesTypes p WHERE p.phonesTypeDescription = :phonesTypeDescription")})
public class PhonesTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phones_type_id", nullable = false)
    private Integer phonesTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phones_type_description", nullable = false, length = 50)
    private String phonesTypeDescription;
    @OneToMany(mappedBy = "phonesTypeId")
    private Set<Phones> phonesSet;

    public PhonesTypes() {
    }

    public PhonesTypes(Integer phonesTypeId) {
        this.phonesTypeId = phonesTypeId;
    }

    public PhonesTypes(Integer phonesTypeId, String phonesTypeDescription) {
        this.phonesTypeId = phonesTypeId;
        this.phonesTypeDescription = phonesTypeDescription;
    }

    public Integer getPhonesTypeId() {
        return phonesTypeId;
    }

    public void setPhonesTypeId(Integer phonesTypeId) {
        this.phonesTypeId = phonesTypeId;
    }

    public String getPhonesTypeDescription() {
        return phonesTypeDescription;
    }

    public void setPhonesTypeDescription(String phonesTypeDescription) {
        this.phonesTypeDescription = phonesTypeDescription;
    }

    @XmlTransient
    public Set<Phones> getPhonesSet() {
        return phonesSet;
    }

    public void setPhonesSet(Set<Phones> phonesSet) {
        this.phonesSet = phonesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phonesTypeId != null ? phonesTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhonesTypes)) {
            return false;
        }
        PhonesTypes other = (PhonesTypes) object;
        if ((this.phonesTypeId == null && other.phonesTypeId != null) || (this.phonesTypeId != null && !this.phonesTypeId.equals(other.phonesTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.PhonesTypes[ phonesTypeId=" + phonesTypeId + " ]";
    }
    
}
