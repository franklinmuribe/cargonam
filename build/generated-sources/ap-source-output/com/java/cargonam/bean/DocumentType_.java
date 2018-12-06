package com.java.cargonam.bean;

import com.java.cargonam.bean.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T18:32:03")
@StaticMetamodel(DocumentType.class)
public class DocumentType_ { 

    public static volatile SetAttribute<DocumentType, Person> personSet;
    public static volatile SingularAttribute<DocumentType, Integer> documentTypeId;
    public static volatile SingularAttribute<DocumentType, String> documentTypeName;

}