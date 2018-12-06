package com.java.cargonam.bean;

import com.java.cargonam.bean.EmailTypes;
import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Emails.class)
public class Emails_ { 

    public static volatile SingularAttribute<Emails, EmailTypes> emailTypesId;
    public static volatile SetAttribute<Emails, Person> personSet;
    public static volatile SingularAttribute<Emails, Integer> personEmailsId;
    public static volatile SingularAttribute<Emails, String> email;

}