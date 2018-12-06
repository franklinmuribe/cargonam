package com.java.cargonam.bean;

import com.java.cargonam.bean.Agent;
import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(AgentPerson.class)
public class AgentPerson_ { 

    public static volatile SingularAttribute<AgentPerson, Agent> agentId;
    public static volatile SingularAttribute<AgentPerson, Person> personId;
    public static volatile SingularAttribute<AgentPerson, Integer> agentPersonId;

}