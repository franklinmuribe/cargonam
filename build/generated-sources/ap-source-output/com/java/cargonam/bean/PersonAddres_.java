package com.java.cargonam.bean;

import com.java.cargonam.bean.AddressesTypes;
import com.java.cargonam.bean.Cities;
import com.java.cargonam.bean.Person;
import com.java.cargonam.bean.Sectors2;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(PersonAddres.class)
public class PersonAddres_ { 

    public static volatile SingularAttribute<PersonAddres, String> reference;
    public static volatile SingularAttribute<PersonAddres, Integer> zipCode;
    public static volatile SingularAttribute<PersonAddres, String> address;
    public static volatile SingularAttribute<PersonAddres, Cities> cityCode;
    public static volatile SingularAttribute<PersonAddres, Integer> personAddresId;
    public static volatile SingularAttribute<PersonAddres, String> userModify;
    public static volatile SingularAttribute<PersonAddres, AddressesTypes> addressesTypeId;
    public static volatile SingularAttribute<PersonAddres, Person> personId;
    public static volatile SingularAttribute<PersonAddres, Sectors2> sector2Code;

}