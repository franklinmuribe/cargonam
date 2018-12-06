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
@Table(name = "regions", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r")
    , @NamedQuery(name = "Regions.findByRegionCode", query = "SELECT r FROM Regions r WHERE r.regionCode = :regionCode")
    , @NamedQuery(name = "Regions.findByRegionName", query = "SELECT r FROM Regions r WHERE r.regionName = :regionName")})
public class Regions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "region_code", nullable = false, length = 3)
    private String regionCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "region_name", nullable = false, length = 50)
    private String regionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionCode")
    private Set<Countries> countriesSet;

    public Regions() {
    }

    public Regions(String regionCode) {
        this.regionCode = regionCode;
    }

    public Regions(String regionCode, String regionName) {
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @XmlTransient
    public Set<Countries> getCountriesSet() {
        return countriesSet;
    }

    public void setCountriesSet(Set<Countries> countriesSet) {
        this.countriesSet = countriesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionCode != null ? regionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regions)) {
            return false;
        }
        Regions other = (Regions) object;
        if ((this.regionCode == null && other.regionCode != null) || (this.regionCode != null && !this.regionCode.equals(other.regionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Regions[ regionCode=" + regionCode + " ]";
    }
    
}
