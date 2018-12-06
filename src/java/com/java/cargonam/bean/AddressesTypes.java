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
@Table(name = "addresses_types", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressesTypes.findAll", query = "SELECT a FROM AddressesTypes a")
    , @NamedQuery(name = "AddressesTypes.findByAddressesTypeId", query = "SELECT a FROM AddressesTypes a WHERE a.addressesTypeId = :addressesTypeId")
    , @NamedQuery(name = "AddressesTypes.findByAddressTypeDescription", query = "SELECT a FROM AddressesTypes a WHERE a.addressTypeDescription = :addressTypeDescription")})
public class AddressesTypes implements Serializable {

    @OneToMany(mappedBy = "addressesTypeId")
    private Set<Addres> addresSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addresses_type_id", nullable = false)
    private Integer addressesTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address_type_description", nullable = false, length = 50)
    private String addressTypeDescription;
    @OneToMany(mappedBy = "addressesTypeId")
    private Set<PersonAddres> personAddresSet;

    public AddressesTypes() {
    }

    public AddressesTypes(Integer addressesTypeId) {
        this.addressesTypeId = addressesTypeId;
    }

    public AddressesTypes(Integer addressesTypeId, String addressTypeDescription) {
        this.addressesTypeId = addressesTypeId;
        this.addressTypeDescription = addressTypeDescription;
    }

    public Integer getAddressesTypeId() {
        return addressesTypeId;
    }

    public void setAddressesTypeId(Integer addressesTypeId) {
        this.addressesTypeId = addressesTypeId;
    }

    public String getAddressTypeDescription() {
        return addressTypeDescription;
    }

    public void setAddressTypeDescription(String addressTypeDescription) {
        this.addressTypeDescription = addressTypeDescription;
    }

    @XmlTransient
    public Set<PersonAddres> getPersonAddresSet() {
        return personAddresSet;
    }

    public void setPersonAddresSet(Set<PersonAddres> personAddresSet) {
        this.personAddresSet = personAddresSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressesTypeId != null ? addressesTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressesTypes)) {
            return false;
        }
        AddressesTypes other = (AddressesTypes) object;
        if ((this.addressesTypeId == null && other.addressesTypeId != null) || (this.addressesTypeId != null && !this.addressesTypeId.equals(other.addressesTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.AddressesTypes[ addressesTypeId=" + addressesTypeId + " ]";
    }

    @XmlTransient
    public Set<Addres> getAddresSet() {
        return addresSet;
    }

    public void setAddresSet(Set<Addres> addresSet) {
        this.addresSet = addresSet;
    }
    
}
