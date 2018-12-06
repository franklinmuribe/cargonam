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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "countries", catalog = "cargonam", schema = "common", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"phone_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryCode", query = "SELECT c FROM Countries c WHERE c.countryCode = :countryCode")
    , @NamedQuery(name = "Countries.findByPhoneCode", query = "SELECT c FROM Countries c WHERE c.phoneCode = :phoneCode")
    , @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone_code", nullable = false)
    private short phoneCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private Set<Phones> phonesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private Set<Cities> citiesSet;
    @JoinColumn(name = "region_code", referencedColumnName = "region_code", nullable = false)
    @ManyToOne(optional = false)
    private Regions regionCode;

    public Countries() {
    }

    public Countries(String countryCode) {
        this.countryCode = countryCode;
    }

    public Countries(String countryCode, short phoneCode, String countryName) {
        this.countryCode = countryCode;
        this.phoneCode = phoneCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public short getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(short phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public Set<Phones> getPhonesSet() {
        return phonesSet;
    }

    public void setPhonesSet(Set<Phones> phonesSet) {
        this.phonesSet = phonesSet;
    }

    @XmlTransient
    public Set<Cities> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<Cities> citiesSet) {
        this.citiesSet = citiesSet;
    }

    public Regions getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Regions regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryCode != null ? countryCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryCode == null && other.countryCode != null) || (this.countryCode != null && !this.countryCode.equals(other.countryCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Countries[ countryCode=" + countryCode + " ]";
    }
    
}
