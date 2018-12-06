/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "sub_action_trace", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubActionTrace.findAll", query = "SELECT s FROM SubActionTrace s")
    , @NamedQuery(name = "SubActionTrace.findByNuSubAction", query = "SELECT s FROM SubActionTrace s WHERE s.nuSubAction = :nuSubAction")
    , @NamedQuery(name = "SubActionTrace.findBySubAction", query = "SELECT s FROM SubActionTrace s WHERE s.subAction = :subAction")})
public class SubActionTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nu_sub_action", nullable = false)
    private Integer nuSubAction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "sub_action", nullable = false, length = 200)
    private String subAction;
    @JoinColumn(name = "nu_action_trace", referencedColumnName = "nu_action_trace", nullable = false)
    @ManyToOne(optional = false)
    private ActionTrace nuActionTrace;

    public SubActionTrace() {
    }

    public SubActionTrace(Integer nuSubAction) {
        this.nuSubAction = nuSubAction;
    }

    public SubActionTrace(Integer nuSubAction, String subAction) {
        this.nuSubAction = nuSubAction;
        this.subAction = subAction;
    }

    public Integer getNuSubAction() {
        return nuSubAction;
    }

    public void setNuSubAction(Integer nuSubAction) {
        this.nuSubAction = nuSubAction;
    }

    public String getSubAction() {
        return subAction;
    }

    public void setSubAction(String subAction) {
        this.subAction = subAction;
    }

    public ActionTrace getNuActionTrace() {
        return nuActionTrace;
    }

    public void setNuActionTrace(ActionTrace nuActionTrace) {
        this.nuActionTrace = nuActionTrace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuSubAction != null ? nuSubAction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubActionTrace)) {
            return false;
        }
        SubActionTrace other = (SubActionTrace) object;
        if ((this.nuSubAction == null && other.nuSubAction != null) || (this.nuSubAction != null && !this.nuSubAction.equals(other.nuSubAction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.SubActionTrace[ nuSubAction=" + nuSubAction + " ]";
    }
    
}
