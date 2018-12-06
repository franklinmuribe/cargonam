package com.java.cargonam.bean;

import com.java.cargonam.bean.AuditTrace;
import com.java.cargonam.bean.MenuTrace;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Systems.class)
public class Systems_ { 

    public static volatile SetAttribute<Systems, AuditTrace> auditTraceSet;
    public static volatile SetAttribute<Systems, MenuTrace> menuTraceSet;
    public static volatile SingularAttribute<Systems, String> sysAcronym;
    public static volatile SingularAttribute<Systems, Integer> nuIdSys;
    public static volatile SingularAttribute<Systems, String> sys;

}