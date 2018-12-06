package com.java.cargonam.bean;

import com.java.cargonam.bean.Cities;
import com.java.cargonam.bean.Phones;
import com.java.cargonam.bean.Regions;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Countries.class)
public class Countries_ { 

    public static volatile SingularAttribute<Countries, Regions> regionCode;
    public static volatile SetAttribute<Countries, Phones> phonesSet;
    public static volatile SingularAttribute<Countries, String> countryCode;
    public static volatile SingularAttribute<Countries, Short> phoneCode;
    public static volatile SingularAttribute<Countries, String> countryName;
    public static volatile SetAttribute<Countries, Cities> citiesSet;

}