package com.java.cargonam.bean;

import com.java.cargonam.bean.MenuTrace;
import com.java.cargonam.bean.SubActionTrace;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(ActionTrace.class)
public class ActionTrace_ { 

    public static volatile SingularAttribute<ActionTrace, String> stActionTrace;
    public static volatile SingularAttribute<ActionTrace, String> txActionTrace;
    public static volatile SetAttribute<ActionTrace, SubActionTrace> subActionTraceSet;
    public static volatile SingularAttribute<ActionTrace, MenuTrace> nuMenuTrace;
    public static volatile SingularAttribute<ActionTrace, Integer> nuActionTrace;

}