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
@Table(name = "permission_role", catalog = "cargonam", schema = "common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionRole.findAll", query = "SELECT p FROM PermissionRole p")
    , @NamedQuery(name = "PermissionRole.findByPermissionRoleId", query = "SELECT p FROM PermissionRole p WHERE p.permissionRoleId = :permissionRoleId")})
public class PermissionRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permission_role_id", nullable = false)
    private Integer permissionRoleId;
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    @ManyToOne
    private Permission permissionId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;

    public PermissionRole() {
    }

    public PermissionRole(Integer permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public Integer getPermissionRoleId() {
        return permissionRoleId;
    }

    public void setPermissionRoleId(Integer permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
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
        hash += (permissionRoleId != null ? permissionRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionRole)) {
            return false;
        }
        PermissionRole other = (PermissionRole) object;
        if ((this.permissionRoleId == null && other.permissionRoleId != null) || (this.permissionRoleId != null && !this.permissionRoleId.equals(other.permissionRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.cargonam.bean.PermissionRole[ permissionRoleId=" + permissionRoleId + " ]";
    }
    
}
