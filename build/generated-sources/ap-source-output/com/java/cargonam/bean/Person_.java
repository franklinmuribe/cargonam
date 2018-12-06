package com.java.cargonam.bean;

import com.java.cargonam.bean.Account;
import com.java.cargonam.bean.Addres;
import com.java.cargonam.bean.Agent;
import com.java.cargonam.bean.AgentPerson;
import com.java.cargonam.bean.Client;
import com.java.cargonam.bean.DocumentType;
import com.java.cargonam.bean.Emails;
import com.java.cargonam.bean.PersonType;
import com.java.cargonam.bean.Phones;
import com.java.cargonam.bean.Seller;
import com.java.cargonam.bean.SellerPerson;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SetAttribute<Person, Addres> addresSet;
    public static volatile SingularAttribute<Person, PersonType> personTypeId;
    public static volatile SingularAttribute<Person, Character> gender;
    public static volatile SetAttribute<Person, Phones> phonesSet;
    public static volatile SingularAttribute<Person, String> specialNotes;
    public static volatile SetAttribute<Person, Seller> sellerSet;
    public static volatile SetAttribute<Person, AgentPerson> agentPersonSet;
    public static volatile SingularAttribute<Person, DocumentType> documentTypeId;
    public static volatile SetAttribute<Person, Account> accountSet;
    public static volatile SetAttribute<Person, SellerPerson> sellerPersonSet;
    public static volatile SetAttribute<Person, Agent> agentSet;
    public static volatile SingularAttribute<Person, String> personName;
    public static volatile SetAttribute<Person, Client> clientSet;
    public static volatile SingularAttribute<Person, Date> registrationDate;
    public static volatile SingularAttribute<Person, String> docIdentificationNumber;
    public static volatile SingularAttribute<Person, Integer> personId;
    public static volatile SetAttribute<Person, Emails> emailsSet;

}