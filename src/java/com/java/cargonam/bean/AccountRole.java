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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furibe
 */
@Entity
@Table(name = "account_role", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountRole.findAll", query = "SELECT a FROM AccountRole a")
    , @NamedQuery(name = "AccountRole.findByAccountRoleId", query = "SELECT a FROM AccountRole a WHERE a.accountRoleId = :accountRoleId")})
public class AccountRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_role_id", nullable = false)
    private Integer accountRoleId;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne
    private Account accountId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;

    public AccountRole() {
    }

    public AccountRole(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Integer getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountRoleId != null ? accountRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountRole)) {
            return false;
        }
        AccountRole other = (AccountRole) object;
        if ((this.accountRoleId == null && other.accountRoleId != null) || (this.accountRoleId != null && !this.accountRoleId.equals(other.accountRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.AccountRole[ accountRoleId=" + accountRoleId + " ]";
    }
    
}
