package com.java.cargonam.bean;

import com.java.cargonam.bean.Emails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(EmailTypes.class)
public class EmailTypes_ { 

    public static volatile SingularAttribute<EmailTypes, Integer> emailTypesId;
    public static volatile SingularAttribute<EmailTypes, String> emailTypesDescription;
    public static volatile SetAttribute<EmailTypes, Emails> emailsSet;

}