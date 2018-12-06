package com.java.cargonam.bean;

import com.java.cargonam.bean.AccountRole;
import com.java.cargonam.bean.PermissionRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SetAttribute<Role, PermissionRole> permissionRoleSet;
    public static volatile SetAttribute<Role, AccountRole> accountRoleSet;
    public static volatile SingularAttribute<Role, Integer> roleId;
    public static volatile SingularAttribute<Role, String> name;

}