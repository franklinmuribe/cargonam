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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "person", catalog = "cargonam", schema = "common",uniqueConstraints={
    @UniqueConstraint(columnNames = {"doc_identification_number"})})
@XmlRootElement(name="Person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId")
    , @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName")
    , @NamedQuery(name = "Person.findByRegistrationDate", query = "SELECT p FROM Person p WHERE p.registrationDate = :registrationDate")
    , @NamedQuery(name = "Person.findBySpecialNotes", query = "SELECT p FROM Person p WHERE p.specialNotes = :specialNotes")
    , @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender")
    , @NamedQuery(name = "Person.findByDocIdentificationNumber", query = "SELECT p FROM Person p WHERE p.docIdentificationNumber = :docIdentificationNumber")})
public class Person implements Serializable {

    @ManyToMany(mappedBy = "personSet", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Addres> addresSet;

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "common.person_id_seq",sequenceName= "common.person_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "common.person_id_seq")
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Integer personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "person_name", nullable = false, length = 50)
    private String personName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Size(max = 4000)
    @Column(name = "special_notes", length = 4000)
    private String specialNotes;
    @Column(name = "gender")
    private Character gender;
    @Size(max = 50)
    @Column(name = "doc_identification_number", length = 50)
    private String docIdentificationNumber;
    @JoinTable(schema = "common",
            name = "person_phones", joinColumns = {
                @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)}, inverseJoinColumns = {
                @JoinColumn(name = "phones_id", referencedColumnName = "person_phones_id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Phones> phonesSet;
    @ManyToMany(mappedBy = "personSet", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Emails> emailsSet;
    @OneToMany(mappedBy = "personId")
    private Set<Seller> sellerSet;
    @OneToMany(mappedBy = "personId")
    private Set<Agent> agentSet;
    @OneToMany(mappedBy = "personId")
    private Set<SellerPerson> sellerPersonSet;
    @OneToMany(mappedBy = "personId")
    private Set<Client> clientSet;

    @OneToMany( mappedBy = "personId")
    private Set<AgentPerson> agentPersonSet;
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    @ManyToOne
    private DocumentType documentTypeId;
    @JoinColumn(name = "person_type_id", referencedColumnName = "person_type_id")
    @ManyToOne
    private PersonType personTypeId;
    @OneToMany(mappedBy = "personId")
    private Set<Account> accountSet;

    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Person(Integer personId, String personName, Date registrationDate) {
        this.personId = personId;
        this.personName = personName;
        this.registrationDate = registrationDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getDocIdentificationNumber() {
        return docIdentificationNumber;
    }

    public void setDocIdentificationNumber(String docIdentificationNumber) {
        this.docIdentificationNumber = docIdentificationNumber;
    }

    @XmlElement
    public Set<Phones> getPhonesSet() {
        return phonesSet;
    }

    public void setPhonesSet(Set<Phones> phonesSet) {
        this.phonesSet = phonesSet;
    }

    @XmlElement
    public Set<Emails> getEmailsSet() {
        return emailsSet;
    }

    public void setEmailsSet(Set<Emails> emailsSet) {
        this.emailsSet = emailsSet;
    }

    @XmlTransient
    public Set<Seller> getSellerSet() {
        return sellerSet;
    }

    public void setSellerSet(Set<Seller> sellerSet) {
        this.sellerSet = sellerSet;
    }

    @XmlTransient
    public Set<Agent> getAgentSet() {
        return agentSet;
    }

    public void setAgentSet(Set<Agent> agentSet) {
        this.agentSet = agentSet;
    }

    @XmlTransient
    public Set<SellerPerson> getSellerPersonSet() {
        return sellerPersonSet;
    }

    public void setSellerPersonSet(Set<SellerPerson> sellerPersonSet) {
        this.sellerPersonSet = sellerPersonSet;
    }

    @XmlTransient
    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    @XmlTransient
    public Set<AgentPerson> getAgentPersonSet() {
        return agentPersonSet;
    }

    public void setAgentPersonSet(Set<AgentPerson> agentPersonSet) {
        this.agentPersonSet = agentPersonSet;
    }

    public DocumentType getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentType documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public PersonType getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(PersonType personTypeId) {
        this.personTypeId = personTypeId;
    }

    @XmlTransient
    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @XmlElement
    public Set<Addres> getAddresSet() {
        return addresSet;
    }

    public void setAddresSet(Set<Addres> addresSet) {
        this.addresSet = addresSet;
    }

    @Override
    public String toString() {
        return "Person{" + "addresSet=" + addresSet + ", personId=" + personId + ", personName=" + personName + ", registrationDate=" + registrationDate + ", specialNotes=" + specialNotes + ", gender=" + gender + ", docIdentificationNumber=" + docIdentificationNumber + ", phonesSet=" + phonesSet + ", emailsSet=" + emailsSet + ", sellerSet=" + sellerSet + ", agentSet=" + agentSet + ", sellerPersonSet=" + sellerPersonSet + ", clientSet=" + clientSet + ", agentPersonSet=" + agentPersonSet + ", documentTypeId=" + documentTypeId + ", personTypeId=" + personTypeId + ", accountSet=" + accountSet + '}';
    }

}
