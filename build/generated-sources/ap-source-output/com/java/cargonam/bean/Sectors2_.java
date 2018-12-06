package com.java.cargonam.bean;

import com.java.cargonam.bean.Addres;
import com.java.cargonam.bean.PersonAddres;
import com.java.cargonam.bean.Sectors1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Sectors2.class)
public class Sectors2_ { 

    public static volatile SingularAttribute<Sectors2, String> sector2Name;
    public static volatile SetAttribute<Sectors2, PersonAddres> personAddresSet;
    public static volatile SetAttribute<Sectors2, Addres> addresSet;
    public static volatile SingularAttribute<Sectors2, String> sector2Code;
    public static volatile SingularAttribute<Sectors2, Sectors1> sector1Code;

}