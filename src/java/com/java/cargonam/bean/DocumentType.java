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
@Table(name = "document_type", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d")
    , @NamedQuery(name = "DocumentType.findByDocumentTypeId", query = "SELECT d FROM DocumentType d WHERE d.documentTypeId = :documentTypeId")
    , @NamedQuery(name = "DocumentType.findByDocumentTypeName", query = "SELECT d FROM DocumentType d WHERE d.documentTypeName = :documentTypeName")})
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "document_type_id", nullable = false)
    private Integer documentTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "document_type_name", nullable = false, length = 50)
    private String documentTypeName;
    @OneToMany(mappedBy = "documentTypeId")
    private Set<Person> personSet;

    public DocumentType() {
    }

    public DocumentType(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public DocumentType(Integer documentTypeId, String documentTypeName) {
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    @XmlTransient
    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentTypeId != null ? documentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentType)) {
            return false;
        }
        DocumentType other = (DocumentType) object;
        if ((this.documentTypeId == null && other.documentTypeId != null) || (this.documentTypeId != null && !this.documentTypeId.equals(other.documentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.DocumentType[ documentTypeId=" + documentTypeId + " ]";
    }
    
}
