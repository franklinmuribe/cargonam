package com.java.cargonam.bean;

import com.java.cargonam.bean.Permission;
import com.java.cargonam.bean.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(PermissionRole.class)
public class PermissionRole_ { 

    public static volatile SingularAttribute<PermissionRole, Permission> permissionId;
    public static volatile SingularAttribute<PermissionRole, Integer> permissionRoleId;
    public static volatile SingularAttribute<PermissionRole, Role> roleId;

}