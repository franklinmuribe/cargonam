package com.java.cargonam.bean;

import com.java.cargonam.bean.Countries;
import com.java.cargonam.bean.Person;
import com.java.cargonam.bean.PhonesTypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Phones.class)
public class Phones_ { 

    public static volatile SingularAttribute<Phones, String> phoneType;
    public static volatile SingularAttribute<Phones, Short> areaCode;
    public static volatile SingularAttribute<Phones, PhonesTypes> phonesTypeId;
    public static volatile SingularAttribute<Phones, Integer> phoneNumber;
    public static volatile SingularAttribute<Phones, Countries> countryCode;
    public static volatile SetAttribute<Phones, Person> personSet;
    public static volatile SingularAttribute<Phones, Integer> personPhonesId;

}