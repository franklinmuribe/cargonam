/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "audit_trace", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditTrace.findAll", query = "SELECT a FROM AuditTrace a")
    , @NamedQuery(name = "AuditTrace.findByNuTraceAud", query = "SELECT a FROM AuditTrace a WHERE a.nuTraceAud = :nuTraceAud")
    , @NamedQuery(name = "AuditTrace.findBySessionHcode", query = "SELECT a FROM AuditTrace a WHERE a.sessionHcode = :sessionHcode")
    , @NamedQuery(name = "AuditTrace.findByNbUserAud", query = "SELECT a FROM AuditTrace a WHERE a.nbUserAud = :nbUserAud")
    , @NamedQuery(name = "AuditTrace.findByNuActionTrace", query = "SELECT a FROM AuditTrace a WHERE a.nuActionTrace = :nuActionTrace")
    , @NamedQuery(name = "AuditTrace.findByDateAudTrace", query = "SELECT a FROM AuditTrace a WHERE a.dateAudTrace = :dateAudTrace")
    , @NamedQuery(name = "AuditTrace.findByNuSubAction", query = "SELECT a FROM AuditTrace a WHERE a.nuSubAction = :nuSubAction")
    , @NamedQuery(name = "AuditTrace.findByActionEspecif", query = "SELECT a FROM AuditTrace a WHERE a.actionEspecif = :actionEspecif")})
public class AuditTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nu_trace_aud", nullable = false)
    private Integer nuTraceAud;
    @Size(max = 50)
    @Column(name = "session_hcode", length = 50)
    private String sessionHcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nb_user_aud", nullable = false, length = 20)
    private String nbUserAud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nu_action_trace", nullable = false)
    private short nuActionTrace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_aud_trace", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateAudTrace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nu_sub_action", nullable = false)
    private short nuSubAction;
    @Size(max = 200)
    @Column(name = "action_especif", length = 200)
    private String actionEspecif;
    @JoinColumn(name = "nu_id_sys", referencedColumnName = "nu_id_sys", nullable = false)
    @ManyToOne(optional = false)
    private Systems nuIdSys;

    public AuditTrace() {
    }

    public AuditTrace(Integer nuTraceAud) {
        this.nuTraceAud = nuTraceAud;
    }

    public AuditTrace(Integer nuTraceAud, String nbUserAud, short nuActionTrace, Date dateAudTrace, short nuSubAction) {
        this.nuTraceAud = nuTraceAud;
        this.nbUserAud = nbUserAud;
        this.nuActionTrace = nuActionTrace;
        this.dateAudTrace = dateAudTrace;
        this.nuSubAction = nuSubAction;
    }

    public Integer getNuTraceAud() {
        return nuTraceAud;
    }

    public void setNuTraceAud(Integer nuTraceAud) {
        this.nuTraceAud = nuTraceAud;
    }

    public String getSessionHcode() {
        return sessionHcode;
    }

    public void setSessionHcode(String sessionHcode) {
        this.sessionHcode = sessionHcode;
    }

    public String getNbUserAud() {
        return nbUserAud;
    }

    public void setNbUserAud(String nbUserAud) {
        this.nbUserAud = nbUserAud;
    }

    public short getNuActionTrace() {
        return nuActionTrace;
    }

    public void setNuActionTrace(short nuActionTrace) {
        this.nuActionTrace = nuActionTrace;
    }

    public Date getDateAudTrace() {
        return dateAudTrace;
    }

    public void setDateAudTrace(Date dateAudTrace) {
        this.dateAudTrace = dateAudTrace;
    }

    public short getNuSubAction() {
        return nuSubAction;
    }

    public void setNuSubAction(short nuSubAction) {
        this.nuSubAction = nuSubAction;
    }

    public String getActionEspecif() {
        return actionEspecif;
    }

    public void setActionEspecif(String actionEspecif) {
        this.actionEspecif = actionEspecif;
    }

    public Systems getNuIdSys() {
        return nuIdSys;
    }

    public void setNuIdSys(Systems nuIdSys) {
        this.nuIdSys = nuIdSys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nuTraceAud != null ? nuTraceAud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditTrace)) {
            return false;
        }
        AuditTrace other = (AuditTrace) object;
        if ((this.nuTraceAud == null && other.nuTraceAud != null) || (this.nuTraceAud != null && !this.nuTraceAud.equals(other.nuTraceAud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.AuditTrace[ nuTraceAud=" + nuTraceAud + " ]";
    }
    
}
