package com.java.cargonam.bean;

import com.java.cargonam.bean.Addres;
import com.java.cargonam.bean.PersonAddres;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(AddressesTypes.class)
public class AddressesTypes_ { 

    public static volatile SetAttribute<AddressesTypes, PersonAddres> personAddresSet;
    public static volatile SetAttribute<AddressesTypes, Addres> addresSet;
    public static volatile SingularAttribute<AddressesTypes, Integer> addressesTypeId;
    public static volatile SingularAttribute<AddressesTypes, String> addressTypeDescription;

}