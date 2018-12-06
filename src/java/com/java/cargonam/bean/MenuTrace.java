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
@Table(name = "menu_trace", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuTrace.findAll", query = "SELECT m FROM MenuTrace m")
    , @NamedQuery(name = "MenuTrace.findByNuMenuTrace", query = "SELECT m FROM MenuTrace m WHERE m.nuMenuTrace = :nuMenuTrace")
    , @NamedQuery(name = "MenuTrace.findByTxMenuTrace", query = "SELECT m FROM MenuTrace m WHERE m.txMenuTrace = :txMenuTrace")
    , @NamedQuery(name = "MenuTrace.findByStMenuTrace", query = "SELECT m FROM MenuTrace m WHERE m.stMenuTrace = :stMenuTrace")})
public class MenuTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nu_menu_trace", nullable = false)
    private Integer nuMenuTrace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tx_menu_trace", nullable = false, length = 60)
    private String txMenuTrace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "st_menu_trace", nullable = false, length = 1)
    private String stMenuTrace;
    @JoinColumn(name = "nu_id_sys", referencedColumnName = "nu_id_sys")
    @ManyToOne
    private Systems nuIdSys;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nuMenuTrace")
    private Set<ActionTrace> actionTraceSet;

    public MenuTrace() {
    }

    public MenuTrace(Integer nuMenuTrace) {
        this.nuMenuTrace = nuMenuTrace;
    }

    public MenuTrace(Integer nuMenuTrace, String txMenuTrace, String stMenuTrace) {
        this.nuMenuTrace = nuMenuTrace;
        this.txMenuTrace = txMenuTrace;
        this.stMenuTrace = stMenuTrace;
    }

    public Integer getNuMenuTrace() {
        return nuMenuTrace;
    }

    public void setNuMenuTrace(Integer nuMenuTrace) {
        this.nuMenuTrace = nuMenuTrace;
    }

    public String getTxMenuTrace() {
        return txMenuTrace;
    }

    public void setTxMenuTrace(String txMenuTrace) {
        this.txMenuTrace = txMenuTrace;
    }

    public String getStMenuTrace() {
        return stMenuTrace;
    }

    public void setStMenuTrace(String stMenuTrace) {
        this.stMenuTrace = stMenuTrace;
    }

    public Systems getNuIdSys() {
        return nuIdSys;
    }

    public void setNuIdSys(Systems nuIdSys) {
        this.nuIdSys = nuIdSys;
    }

    @XmlTransient
    public Set<ActionTrace> getActionTraceSet() {
        return actionTraceSet;
    }

    public void setActionTraceSet(Set<ActionTrace> actionTraceSet) {
        this.actionTraceSet = actionTraceSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuMenuTrace != null ? nuMenuTrace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuTrace)) {
            return false;
        }
        MenuTrace other = (MenuTrace) object;
        if ((this.nuMenuTrace == null && other.nuMenuTrace != null) || (this.nuMenuTrace != null && !this.nuMenuTrace.equals(other.nuMenuTrace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.MenuTrace[ nuMenuTrace=" + nuMenuTrace + " ]";
    }
    
}
