package com.java.cargonam.bean;

import com.java.cargonam.bean.Addres;
import com.java.cargonam.bean.Countries;
import com.java.cargonam.bean.PersonAddres;
import com.java.cargonam.bean.Sectors1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Cities.class)
public class Cities_ { 

    public static volatile SetAttribute<Cities, PersonAddres> personAddresSet;
    public static volatile SetAttribute<Cities, Addres> addresSet;
    public static volatile SetAttribute<Cities, Sectors1> sectors1Set;
    public static volatile SingularAttribute<Cities, String> cityName;
    public static volatile SingularAttribute<Cities, String> cityCode;
    public static volatile SingularAttribute<Cities, Countries> countryCode;

}