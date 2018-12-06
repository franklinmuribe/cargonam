package com.java.cargonam.bean;

import com.java.cargonam.bean.PermissionRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile SingularAttribute<Permission, Integer> permissionId;
    public static volatile SetAttribute<Permission, PermissionRole> permissionRoleSet;
    public static volatile SingularAttribute<Permission, String> name;

}