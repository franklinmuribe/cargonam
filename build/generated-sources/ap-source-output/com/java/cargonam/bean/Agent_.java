package com.java.cargonam.bean;

import com.java.cargonam.bean.AgentPerson;
import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(Agent.class)
public class Agent_ { 

    public static volatile SingularAttribute<Agent, Integer> agentId;
    public static volatile SetAttribute<Agent, AgentPerson> agentPersonSet;
    public static volatile SingularAttribute<Agent, Person> personId;

}