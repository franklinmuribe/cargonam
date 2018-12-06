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
@Table(name = "sectors2", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectors2.findAll", query = "SELECT s FROM Sectors2 s")
    , @NamedQuery(name = "Sectors2.findBySector2Code", query = "SELECT s FROM Sectors2 s WHERE s.sector2Code = :sector2Code")
    , @NamedQuery(name = "Sectors2.findBySector2Name", query = "SELECT s FROM Sectors2 s WHERE s.sector2Name = :sector2Name")})
public class Sectors2 implements Serializable {

    @OneToMany(mappedBy = "sector2Code")
    private Set<Addres> addresSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sector2_code", nullable = false, length = 3)
    private String sector2Code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sector2_name", nullable = false, length = 50)
    private String sector2Name;
    @JoinColumn(name = "sector1_code", referencedColumnName = "sector1_code", nullable = false)
    @ManyToOne(optional = false)
    private Sectors1 sector1Code;
    @OneToMany(mappedBy = "sector2Code")
    private Set<PersonAddres> personAddresSet;

    public Sectors2() {
    }

    public Sectors2(String sector2Code) {
        this.sector2Code = sector2Code;
    }

    public Sectors2(String sector2Code, String sector2Name) {
        this.sector2Code = sector2Code;
        this.sector2Name = sector2Name;
    }

    public String getSector2Code() {
        return sector2Code;
    }

    public void setSector2Code(String sector2Code) {
        this.sector2Code = sector2Code;
    }

    public String getSector2Name() {
        return sector2Name;
    }

    public void setSector2Name(String sector2Name) {
        this.sector2Name = sector2Name;
    }

    public Sectors1 getSector1Code() {
        return sector1Code;
    }

    public void setSector1Code(Sectors1 sector1Code) {
        this.sector1Code = sector1Code;
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
        hash += (sector2Code != null ? sector2Code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectors2)) {
            return false;
        }
        Sectors2 other = (Sectors2) object;
        if ((this.sector2Code == null && other.sector2Code != null) || (this.sector2Code != null && !this.sector2Code.equals(other.sector2Code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Sectors2[ sector2Code=" + sector2Code + " ]";
    }

    @XmlTransient
    public Set<Addres> getAddresSet() {
        return addresSet;
    }

    public void setAddresSet(Set<Addres> addresSet) {
        this.addresSet = addresSet;
    }
    
}
