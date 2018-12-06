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
@Table(name = "email_types", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailTypes.findAll", query = "SELECT e FROM EmailTypes e")
    , @NamedQuery(name = "EmailTypes.findByEmailTypesId", query = "SELECT e FROM EmailTypes e WHERE e.emailTypesId = :emailTypesId")
    , @NamedQuery(name = "EmailTypes.findByEmailTypesDescription", query = "SELECT e FROM EmailTypes e WHERE e.emailTypesDescription = :emailTypesDescription")})
public class EmailTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_types_id", nullable = false)
    private Integer emailTypesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_types_description", nullable = false, length = 50)
    private String emailTypesDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailTypesId")
    private Set<Emails> emailsSet;

    public EmailTypes() {
    }

    public EmailTypes(Integer emailTypesId) {
        this.emailTypesId = emailTypesId;
    }

    public EmailTypes(Integer emailTypesId, String emailTypesDescription) {
        this.emailTypesId = emailTypesId;
        this.emailTypesDescription = emailTypesDescription;
    }

    public Integer getEmailTypesId() {
        return emailTypesId;
    }

    public void setEmailTypesId(Integer emailTypesId) {
        this.emailTypesId = emailTypesId;
    }

    public String getEmailTypesDescription() {
        return emailTypesDescription;
    }

    public void setEmailTypesDescription(String emailTypesDescription) {
        this.emailTypesDescription = emailTypesDescription;
    }

    @XmlTransient
    public Set<Emails> getEmailsSet() {
        return emailsSet;
    }

    public void setEmailsSet(Set<Emails> emailsSet) {
        this.emailsSet = emailsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailTypesId != null ? emailTypesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailTypes)) {
            return false;
        }
        EmailTypes other = (EmailTypes) object;
        if ((this.emailTypesId == null && other.emailTypesId != null) || (this.emailTypesId != null && !this.emailTypesId.equals(other.emailTypesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.EmailTypes[ emailTypesId=" + emailTypesId + " ]";
    }
    
}
