package com.java.cargonam.bean;

import com.java.cargonam.bean.AddressesTypes;
import com.java.cargonam.bean.Cities;
import com.java.cargonam.bean.Person;
import com.java.cargonam.bean.Sectors2;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Addres.class)
public class Addres_ { 

    public static volatile SingularAttribute<Addres, String> reference;
    public static volatile SingularAttribute<Addres, Integer> zipCode;
    public static volatile SingularAttribute<Addres, String> address;
    public static volatile SingularAttribute<Addres, Cities> cityCode;
    public static volatile SetAttribute<Addres, Person> personSet;
    public static volatile SingularAttribute<Addres, Integer> personAddresId;
    public static volatile SingularAttribute<Addres, String> userModify;
    public static volatile SingularAttribute<Addres, AddressesTypes> addressesTypeId;
    public static volatile SingularAttribute<Addres, Sectors2> sector2Code;

}