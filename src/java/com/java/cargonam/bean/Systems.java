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
@Table(name = "systems", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systems.findAll", query = "SELECT s FROM Systems s")
    , @NamedQuery(name = "Systems.findByNuIdSys", query = "SELECT s FROM Systems s WHERE s.nuIdSys = :nuIdSys")
    , @NamedQuery(name = "Systems.findBySysAcronym", query = "SELECT s FROM Systems s WHERE s.sysAcronym = :sysAcronym")
    , @NamedQuery(name = "Systems.findBySys", query = "SELECT s FROM Systems s WHERE s.sys = :sys")})
public class Systems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nu_id_sys", nullable = false)
    private Integer nuIdSys;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sys_acronym", nullable = false, length = 20)
    private String sysAcronym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sys", nullable = false, length = 100)
    private String sys;
    @OneToMany(mappedBy = "nuIdSys")
    private Set<MenuTrace> menuTraceSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nuIdSys")
    private Set<AuditTrace> auditTraceSet;

    public Systems() {
    }

    public Systems(Integer nuIdSys) {
        this.nuIdSys = nuIdSys;
    }

    public Systems(Integer nuIdSys, String sysAcronym, String sys) {
        this.nuIdSys = nuIdSys;
        this.sysAcronym = sysAcronym;
        this.sys = sys;
    }

    public Integer getNuIdSys() {
        return nuIdSys;
    }

    public void setNuIdSys(Integer nuIdSys) {
        this.nuIdSys = nuIdSys;
    }

    public String getSysAcronym() {
        return sysAcronym;
    }

    public void setSysAcronym(String sysAcronym) {
        this.sysAcronym = sysAcronym;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    @XmlTransient
    public Set<MenuTrace> getMenuTraceSet() {
        return menuTraceSet;
    }

    public void setMenuTraceSet(Set<MenuTrace> menuTraceSet) {
        this.menuTraceSet = menuTraceSet;
    }

    @XmlTransient
    public Set<AuditTrace> getAuditTraceSet() {
        return auditTraceSet;
    }

    public void setAuditTraceSet(Set<AuditTrace> auditTraceSet) {
        this.auditTraceSet = auditTraceSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuIdSys != null ? nuIdSys.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systems)) {
            return false;
        }
        Systems other = (Systems) object;
        if ((this.nuIdSys == null && other.nuIdSys != null) || (this.nuIdSys != null && !this.nuIdSys.equals(other.nuIdSys))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Systems[ nuIdSys=" + nuIdSys + " ]";
    }
    
}
