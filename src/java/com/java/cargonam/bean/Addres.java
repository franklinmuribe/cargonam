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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "addres", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addres.findAll", query = "SELECT a FROM Addres a")
    , @NamedQuery(name = "Addres.findByPersonAddresId", query = "SELECT a FROM Addres a WHERE a.personAddresId = :personAddresId")
    , @NamedQuery(name = "Addres.findByAddress", query = "SELECT a FROM Addres a WHERE a.address = :address")
    , @NamedQuery(name = "Addres.findByUserModify", query = "SELECT a FROM Addres a WHERE a.userModify = :userModify")
    , @NamedQuery(name = "Addres.findByZipCode", query = "SELECT a FROM Addres a WHERE a.zipCode = :zipCode")
    , @NamedQuery(name = "Addres.findByReference", query = "SELECT a FROM Addres a WHERE a.reference = :reference")})
public class Addres implements Serializable {

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
    @JoinTable(schema = "common",
            name = "person_addres", joinColumns = {
                @JoinColumn(name = "addres_id", referencedColumnName = "person_addres_id", nullable = false)}, inverseJoinColumns = {
                @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Person> personSet;
    @JoinColumn(name = "addresses_type_id", referencedColumnName = "addresses_type_id")
    @ManyToOne
    private AddressesTypes addressesTypeId;
    @JoinColumn(name = "city_code", referencedColumnName = "city_code")
    @ManyToOne
    private Cities cityCode;
    @JoinColumn(name = "sector2_code", referencedColumnName = "sector2_code")
    @ManyToOne
    private Sectors2 sector2Code;

    public Addres() {
    }

    public Addres(Integer personAddresId) {
        this.personAddresId = personAddresId;
    }

    public Addres(Integer personAddresId, String address) {
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

    @XmlTransient
    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
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
        if (!(object instanceof Addres)) {
            return false;
        }
        Addres other = (Addres) object;
        if ((this.personAddresId == null && other.personAddresId != null) || (this.personAddresId != null && !this.personAddresId.equals(other.personAddresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Addres[ personAddresId=" + personAddresId + " ]";
    }

}
