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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "agent_person", catalog = "cargonam", schema = "common", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"agent_id", "person_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentPerson.findAll", query = "SELECT a FROM AgentPerson a")
    , @NamedQuery(name = "AgentPerson.findByAgentPersonId", query = "SELECT a FROM AgentPerson a WHERE a.agentPersonId = :agentPersonId")})
public class AgentPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agent_person_id", nullable = false)
    private Integer agentPersonId;
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id", nullable = false)
    @ManyToOne(optional = false)
    private Agent agentId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;

    public AgentPerson() {
    }

    public AgentPerson(Integer agentPersonId) {
        this.agentPersonId = agentPersonId;
    }

    public Integer getAgentPersonId() {
        return agentPersonId;
    }

    public void setAgentPersonId(Integer agentPersonId) {
        this.agentPersonId = agentPersonId;
    }

    public Agent getAgentId() {
        return agentId;
    }

    public void setAgentId(Agent agentId) {
        this.agentId = agentId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentPersonId != null ? agentPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentPerson)) {
            return false;
        }
        AgentPerson other = (AgentPerson) object;
        if ((this.agentPersonId == null && other.agentPersonId != null) || (this.agentPersonId != null && !this.agentPersonId.equals(other.agentPersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.AgentPerson[ agentPersonId=" + agentPersonId + " ]";
    }
    
}
