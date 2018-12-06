package com.java.cargonam.bean;

import com.java.cargonam.bean.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(PersonType.class)
public class PersonType_ { 

    public static volatile SingularAttribute<PersonType, Integer> personTypeId;
    public static volatile SetAttribute<PersonType, Person> personSet;
    public static volatile SingularAttribute<PersonType, String> name;
    public static volatile SingularAttribute<PersonType, Date> registrationDate;
    public static volatile SingularAttribute<PersonType, String> description;
    public static volatile SingularAttribute<PersonType, Character> status;

}