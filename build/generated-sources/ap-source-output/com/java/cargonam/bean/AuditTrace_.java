package com.java.cargonam.bean;

import com.java.cargonam.bean.Systems;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(AuditTrace.class)
public class AuditTrace_ { 

    public static volatile SingularAttribute<AuditTrace, Date> dateAudTrace;
    public static volatile SingularAttribute<AuditTrace, String> sessionHcode;
    public static volatile SingularAttribute<AuditTrace, Integer> nuTraceAud;
    public static volatile SingularAttribute<AuditTrace, Short> nuActionTrace;
    public static volatile SingularAttribute<AuditTrace, Short> nuSubAction;
    public static volatile SingularAttribute<AuditTrace, String> nbUserAud;
    public static volatile SingularAttribute<AuditTrace, String> actionEspecif;
    public static volatile SingularAttribute<AuditTrace, Systems> nuIdSys;

}