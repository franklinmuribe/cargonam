package com.java.cargonam.bean;

import com.java.cargonam.bean.Person;
import com.java.cargonam.bean.SellerPerson;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Seller.class)
public class Seller_ { 

    public static volatile SingularAttribute<Seller, Integer> sellerId;
    public static volatile SingularAttribute<Seller, Person> personId;
    public static volatile SetAttribute<Seller, SellerPerson> sellerPersonSet;

}