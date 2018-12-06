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
@Table(name = "sectors1", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectors1.findAll", query = "SELECT s FROM Sectors1 s")
    , @NamedQuery(name = "Sectors1.findBySector1Code", query = "SELECT s FROM Sectors1 s WHERE s.sector1Code = :sector1Code")
    , @NamedQuery(name = "Sectors1.findBySector1Name", query = "SELECT s FROM Sectors1 s WHERE s.sector1Name = :sector1Name")})
public class Sectors1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sector1_code", nullable = false, length = 3)
    private String sector1Code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sector1_name", nullable = false, length = 50)
    private String sector1Name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector1Code")
    private Set<Sectors2> sectors2Set;
    @JoinColumn(name = "city_code", referencedColumnName = "city_code", nullable = false)
    @ManyToOne(optional = false)
    private Cities cityCode;

    public Sectors1() {
    }

    public Sectors1(String sector1Code) {
        this.sector1Code = sector1Code;
    }

    public Sectors1(String sector1Code, String sector1Name) {
        this.sector1Code = sector1Code;
        this.sector1Name = sector1Name;
    }

    public String getSector1Code() {
        return sector1Code;
    }

    public void setSector1Code(String sector1Code) {
        this.sector1Code = sector1Code;
    }

    public String getSector1Name() {
        return sector1Name;
    }

    public void setSector1Name(String sector1Name) {
        this.sector1Name = sector1Name;
    }

    @XmlTransient
    public Set<Sectors2> getSectors2Set() {
        return sectors2Set;
    }

    public void setSectors2Set(Set<Sectors2> sectors2Set) {
        this.sectors2Set = sectors2Set;
    }

    public Cities getCityCode() {
        return cityCode;
    }

    public void setCityCode(Cities cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sector1Code != null ? sector1Code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectors1)) {
            return false;
        }
        Sectors1 other = (Sectors1) object;
        if ((this.sector1Code == null && other.sector1Code != null) || (this.sector1Code != null && !this.sector1Code.equals(other.sector1Code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Sectors1[ sector1Code=" + sector1Code + " ]";
    }
    
}
