/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "person_type", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonType.findAll", query = "SELECT p FROM PersonType p")
    , @NamedQuery(name = "PersonType.findByPersonTypeId", query = "SELECT p FROM PersonType p WHERE p.personTypeId = :personTypeId")
    , @NamedQuery(name = "PersonType.findByName", query = "SELECT p FROM PersonType p WHERE p.name = :name")
    , @NamedQuery(name = "PersonType.findByDescription", query = "SELECT p FROM PersonType p WHERE p.description = :description")
    , @NamedQuery(name = "PersonType.findByRegistrationDate", query = "SELECT p FROM PersonType p WHERE p.registrationDate = :registrationDate")
    , @NamedQuery(name = "PersonType.findByStatus", query = "SELECT p FROM PersonType p WHERE p.status = :status")})
public class PersonType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_type_id", nullable = false)
    private Integer personTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Column(name = "status")
    private Character status;
    @OneToMany(mappedBy = "personTypeId")
    private Set<Person> personSet;

    public PersonType() {
    }

    public PersonType(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

    public PersonType(Integer personTypeId, String name, String description, Date registrationDate) {
        this.personTypeId = personTypeId;
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
    }

    public Integer getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
        hash += (personTypeId != null ? personTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonType)) {
            return false;
        }
        PersonType other = (PersonType) object;
        if ((this.personTypeId == null && other.personTypeId != null) || (this.personTypeId != null && !this.personTypeId.equals(other.personTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.PersonType[ personTypeId=" + personTypeId + " ]";
    }
    
}
