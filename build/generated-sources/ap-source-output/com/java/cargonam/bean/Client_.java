package com.java.cargonam.bean;

import com.java.cargonam.bean.ClientTypes;
import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> clientId;
    public static volatile SingularAttribute<Client, ClientTypes> clientTypeId;
    public static volatile SingularAttribute<Client, Person> personId;

}