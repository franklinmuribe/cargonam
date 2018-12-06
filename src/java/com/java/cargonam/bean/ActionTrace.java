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
@Table(name = "action_trace", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActionTrace.findAll", query = "SELECT a FROM ActionTrace a")
    , @NamedQuery(name = "ActionTrace.findByNuActionTrace", query = "SELECT a FROM ActionTrace a WHERE a.nuActionTrace = :nuActionTrace")
    , @NamedQuery(name = "ActionTrace.findByTxActionTrace", query = "SELECT a FROM ActionTrace a WHERE a.txActionTrace = :txActionTrace")
    , @NamedQuery(name = "ActionTrace.findByStActionTrace", query = "SELECT a FROM ActionTrace a WHERE a.stActionTrace = :stActionTrace")})
public class ActionTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nu_action_trace", nullable = false)
    private Integer nuActionTrace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tx_action_trace", nullable = false, length = 60)
    private String txActionTrace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "st_action_trace", nullable = false, length = 1)
    private String stActionTrace;
    @JoinColumn(name = "nu_menu_trace", referencedColumnName = "nu_menu_trace", nullable = false)
    @ManyToOne(optional = false)
    private MenuTrace nuMenuTrace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nuActionTrace")
    private Set<SubActionTrace> subActionTraceSet;

    public ActionTrace() {
    }

    public ActionTrace(Integer nuActionTrace) {
        this.nuActionTrace = nuActionTrace;
    }

    public ActionTrace(Integer nuActionTrace, String txActionTrace, String stActionTrace) {
        this.nuActionTrace = nuActionTrace;
        this.txActionTrace = txActionTrace;
        this.stActionTrace = stActionTrace;
    }

    public Integer getNuActionTrace() {
        return nuActionTrace;
    }

    public void setNuActionTrace(Integer nuActionTrace) {
        this.nuActionTrace = nuActionTrace;
    }

    public String getTxActionTrace() {
        return txActionTrace;
    }

    public void setTxActionTrace(String txActionTrace) {
        this.txActionTrace = txActionTrace;
    }

    public String getStActionTrace() {
        return stActionTrace;
    }

    public void setStActionTrace(String stActionTrace) {
        this.stActionTrace = stActionTrace;
    }

    public MenuTrace getNuMenuTrace() {
        return nuMenuTrace;
    }

    public void setNuMenuTrace(MenuTrace nuMenuTrace) {
        this.nuMenuTrace = nuMenuTrace;
    }

    @XmlTransient
    public Set<SubActionTrace> getSubActionTraceSet() {
        return subActionTraceSet;
    }

    public void setSubActionTraceSet(Set<SubActionTrace> subActionTraceSet) {
        this.subActionTraceSet = subActionTraceSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuActionTrace != null ? nuActionTrace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActionTrace)) {
            return false;
        }
        ActionTrace other = (ActionTrace) object;
        if ((this.nuActionTrace == null && other.nuActionTrace != null) || (this.nuActionTrace != null && !this.nuActionTrace.equals(other.nuActionTrace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.ActionTrace[ nuActionTrace=" + nuActionTrace + " ]";
    }
    
}
