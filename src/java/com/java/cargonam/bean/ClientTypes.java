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
@Table(name = "client_types", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientTypes.findAll", query = "SELECT c FROM ClientTypes c")
    , @NamedQuery(name = "ClientTypes.findByClientTypeId", query = "SELECT c FROM ClientTypes c WHERE c.clientTypeId = :clientTypeId")
    , @NamedQuery(name = "ClientTypes.findByClientTypesDescription", query = "SELECT c FROM ClientTypes c WHERE c.clientTypesDescription = :clientTypesDescription")})
public class ClientTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_type_id", nullable = false)
    private Integer clientTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "client_types_description", nullable = false, length = 50)
    private String clientTypesDescription;
    @OneToMany(mappedBy = "clientTypeId")
    private Set<Client> clientSet;

    public ClientTypes() {
    }

    public ClientTypes(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public ClientTypes(Integer clientTypeId, String clientTypesDescription) {
        this.clientTypeId = clientTypeId;
        this.clientTypesDescription = clientTypesDescription;
    }

    public Integer getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public String getClientTypesDescription() {
        return clientTypesDescription;
    }

    public void setClientTypesDescription(String clientTypesDescription) {
        this.clientTypesDescription = clientTypesDescription;
    }

    @XmlTransient
    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientTypeId != null ? clientTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientTypes)) {
            return false;
        }
        ClientTypes other = (ClientTypes) object;
        if ((this.clientTypeId == null && other.clientTypeId != null) || (this.clientTypeId != null && !this.clientTypeId.equals(other.clientTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.ClientTypes[ clientTypeId=" + clientTypeId + " ]";
    }
    
}
