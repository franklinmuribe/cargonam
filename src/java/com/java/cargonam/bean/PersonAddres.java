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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "person_addres", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonAddres.findAll", query = "SELECT p FROM PersonAddres p")
    , @NamedQuery(name = "PersonAddres.findByPersonAddresId", query = "SELECT p FROM PersonAddres p WHERE p.personAddresId = :personAddresId")
    , @NamedQuery(name = "PersonAddres.findByAddress", query = "SELECT p FROM PersonAddres p WHERE p.address = :address")
    , @NamedQuery(name = "PersonAddres.findByUserModify", query = "SELECT p FROM PersonAddres p WHERE p.userModify = :userModify")
    , @NamedQuery(name = "PersonAddres.findByZipCode", query = "SELECT p FROM PersonAddres p WHERE p.zipCode = :zipCode")
    , @NamedQuery(name = "PersonAddres.findByReference", query = "SELECT p FROM PersonAddres p WHERE p.reference = :reference")})
public class PersonAddres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_addres_id", nullable = false)
    private Integer personAddresId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Size(max = 50)
    @Column(name = "user_modify", length = 50)
    private String userModify;
    @Column(name = "zip_code")
    private Integer zipCode;
    @Size(max = 1000)
    @Column(name = "reference", length = 1000)
    private String reference;
    @JoinColumn(name = "addresses_type_id", referencedColumnName = "addresses_type_id")
    @ManyToOne
    private AddressesTypes addressesTypeId;
    @JoinColumn(name = "city_code", referencedColumnName = "city_code")
    @ManyToOne
    private Cities cityCode;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;
    @JoinColumn(name = "sector2_code", referencedColumnName = "sector2_code")
    @ManyToOne
    private Sectors2 sector2Code;

    public PersonAddres() {
    }

    public PersonAddres(Integer personAddresId) {
        this.personAddresId = personAddresId;
    }

    public PersonAddres(Integer personAddresId, String address) {
        this.personAddresId = personAddresId;
        this.address = address;
    }

    public Integer getPersonAddresId() {
        return personAddresId;
    }

    public void setPersonAddresId(Integer personAddresId) {
        this.personAddresId = personAddresId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserModify() {
        return userModify;
    }

    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public AddressesTypes getAddressesTypeId() {
        return addressesTypeId;
    }

    public void setAddressesTypeId(AddressesTypes addressesTypeId) {
        this.addressesTypeId = addressesTypeId;
    }

    public Cities getCityCode() {
        return cityCode;
    }

    public void setCityCode(Cities cityCode) {
        this.cityCode = cityCode;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Sectors2 getSector2Code() {
        return sector2Code;
    }

    public void setSector2Code(Sectors2 sector2Code) {
        this.sector2Code = sector2Code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personAddresId != null ? personAddresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonAddres)) {
            return false;
        }
        PersonAddres other = (PersonAddres) object;
        if ((this.personAddresId == null && other.personAddresId != null) || (this.personAddresId != null && !this.personAddresId.equals(other.personAddresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.PersonAddres[ personAddresId=" + personAddresId + " ]";
    }
    
}
