package com.java.cargonam.bean;

import com.java.cargonam.bean.Countries;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Regions.class)
public class Regions_ { 

    public static volatile SingularAttribute<Regions, String> regionCode;
    public static volatile SingularAttribute<Regions, String> regionName;
    public static volatile SetAttribute<Regions, Countries> countriesSet;

}