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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "emails", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emails.findAll", query = "SELECT e FROM Emails e")
    , @NamedQuery(name = "Emails.findByPersonEmailsId", query = "SELECT e FROM Emails e WHERE e.personEmailsId = :personEmailsId")
    , @NamedQuery(name = "Emails.findByEmail", query = "SELECT e FROM Emails e WHERE e.email = :email")})
public class Emails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "common.email_id_seq",sequenceName= "common.email_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "common.email_id_seq")
    @Basic(optional = false)
    @Column(name = "person_emails_id", nullable = false)
    private Integer personEmailsId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @JoinTable(schema = "common",
            name = "person_emails", joinColumns = {
                @JoinColumn(name = "email_id", referencedColumnName = "person_emails_id", nullable = false)}, inverseJoinColumns = {
                @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Person> personSet;
    @JoinColumn(name = "email_types_id", referencedColumnName = "email_types_id", nullable = false)
    @ManyToOne(optional = false)
    private EmailTypes emailTypesId;

    public Emails() {
    }

    public Emails(Integer personEmailsId) {
        this.personEmailsId = personEmailsId;
    }

    public Emails(Integer personEmailsId, String email) {
        this.personEmailsId = personEmailsId;
        this.email = email;
    }

    public Integer getPersonEmailsId() {
        return personEmailsId;
    }

    public void setPersonEmailsId(Integer personEmailsId) {
        this.personEmailsId = personEmailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public EmailTypes getEmailTypesId() {
        return emailTypesId;
    }

    public void setEmailTypesId(EmailTypes emailTypesId) {
        this.emailTypesId = emailTypesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personEmailsId != null ? personEmailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.personEmailsId == null && other.personEmailsId != null) || (this.personEmailsId != null && !this.personEmailsId.equals(other.personEmailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.Emails[ personEmailsId=" + personEmailsId + " ]";
    }

}
