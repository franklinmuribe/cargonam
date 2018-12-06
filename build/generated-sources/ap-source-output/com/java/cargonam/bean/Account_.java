package com.java.cargonam.bean;

import com.java.cargonam.bean.AccountRole;
import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Integer> accountId;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SetAttribute<Account, AccountRole> accountRoleSet;
    public static volatile SingularAttribute<Account, Person> personId;
    public static volatile SingularAttribute<Account, String> username;

}