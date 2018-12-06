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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "phones", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phones.findAll", query = "SELECT p FROM Phones p")
    , @NamedQuery(name = "Phones.findByPersonPhonesId", query = "SELECT p FROM Phones p WHERE p.personPhonesId = :personPhonesId")
    , @NamedQuery(name = "Phones.findByPhoneType", query = "SELECT p FROM Phones p WHERE p.phoneType = :phoneType")
    , @NamedQuery(name = "Phones.findByAreaCode", query = "SELECT p FROM Phones p WHERE p.areaCode = :areaCode")
    , @NamedQuery(name = "Phones.findByPhoneNumber", query = "SELECT p FROM Phones p WHERE p.phoneNumber = :phoneNumber")})
public class Phones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "common.person_phones_id_seq",sequenceName= "common.person_phones_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "common.person_phones_id_seq")
    @Basic(optional = false)
    @Column(name = "person_phones_id", nullable = false)
    private Integer personPhonesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phone_type", nullable = false, length = 50)
    private String phoneType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area_code", nullable = false)
    private short areaCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;
    @ManyToMany(mappedBy = "phonesSet", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Person> personSet;
    @JoinColumn(name = "country_code", referencedColumnName = "country_code", nullable = false)
    @ManyToOne(optional = false)
    private Countries countryCode;
    @JoinColumn(name = "phones_type_id", referencedColumnName = "phones_type_id")
    @ManyToOne
    private PhonesTypes phonesTypeId;

    public Phones() {
    }

    public Phones(Integer personPhonesId) {
        this.personPhonesId = personPhonesId;
    }

    public Phones(Integer personPhonesId, String phoneType, short areaCode, int phoneNumber) {
        this.personPhonesId = personPhonesId;
        this.phoneType = phoneType;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPersonPhonesId() {
        return personPhonesId;
    }

    public void setPersonPhonesId(Integer personPhonesId) {
        this.personPhonesId = personPhonesId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(short areaCode) {
        this.areaCode = areaCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Countries getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Countries countryCode) {
        this.countryCode = countryCode;
    }

    public PhonesTypes getPhonesTypeId() {
        return phonesTypeId;
    }

    public void setPhonesTypeId(PhonesTypes phonesTypeId) {
        this.phonesTypeId = phonesTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPhonesId != null ? personPhonesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phones)) {
            return false;
        }
        Phones other = (Phones) object;
        if ((this.personPhonesId == null && other.personPhonesId != null) || (this.personPhonesId != null && !this.personPhonesId.equals(other.personPhonesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Phones[ personPhonesId=" + personPhonesId + " ]";
    }

}
