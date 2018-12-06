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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "cities", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c")
    , @NamedQuery(name = "Cities.findByCityCode", query = "SELECT c FROM Cities c WHERE c.cityCode = :cityCode")
    , @NamedQuery(name = "Cities.findByCityName", query = "SELECT c FROM Cities c WHERE c.cityName = :cityName")})
public class Cities implements Serializable {

    @OneToMany(mappedBy = "cityCode")
    private Set<Addres> addresSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "city_code", nullable = false, length = 4)
    private String cityCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city_name", nullable = false, length = 50)
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityCode")
    private Set<Sectors1> sectors1Set;
    @OneToMany(mappedBy = "cityCode")
    private Set<PersonAddres> personAddresSet;
    @JoinColumn(name = "country_code", referencedColumnName = "country_code", nullable = false)
    @ManyToOne(optional = false)
    private Countries countryCode;

    public Cities() {
    }

    public Cities(String cityCode) {
        this.cityCode = cityCode;
    }

    public Cities(String cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Set<Sectors1> getSectors1Set() {
        return sectors1Set;
    }

    public void setSectors1Set(Set<Sectors1> sectors1Set) {
        this.sectors1Set = sectors1Set;
    }

    @XmlTransient
    public Set<PersonAddres> getPersonAddresSet() {
        return personAddresSet;
    }

    public void setPersonAddresSet(Set<PersonAddres> personAddresSet) {
        this.personAddresSet = personAddresSet;
    }

    public Countries getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Countries countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityCode != null ? cityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.cityCode == null && other.cityCode != null) || (this.cityCode != null && !this.cityCode.equals(other.cityCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Cities[ cityCode=" + cityCode + " ]";
    }

    @XmlTransient
    public Set<Addres> getAddresSet() {
        return addresSet;
    }

    public void setAddresSet(Set<Addres> addresSet) {
        this.addresSet = addresSet;
    }
    
}
