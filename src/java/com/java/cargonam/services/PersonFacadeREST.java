/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.services;

import com.java.cargonam.bean.Person;
import com.java.cargonam.bean.Persons;
import com.java.cargonam.service.persistence.PersonsPersistence;
import com.java.cargonam.util.AlmacenPropiedades;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author furibe
 */
@Path("/person")
public class PersonFacadeREST extends AbstractFacade<Person> {

    private EntityManager em;
    private EntityManagerFactory factory;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @POST
    @Path("/createPerson")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(String entity) {
        try {
            System.out.println("entity ******* = " + entity);
            InputStream stream = new ByteArrayInputStream(entity.getBytes(StandardCharsets.UTF_8));
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person objPerson = (Person) jaxbUnmarshaller.unmarshal(stream);
            PersonsPersistence persistence = new PersonsPersistence();
            persistence.persist(objPerson);
            System.out.println("entity create = " + objPerson.toString());

//        super.create(entity);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    @POST
    @Path("/editPerson")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(String entity) {
        try {
            System.out.println("entity ******* = " + entity);
            InputStream stream = new ByteArrayInputStream(entity.getBytes(StandardCharsets.UTF_8));
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person objPerson = (Person) jaxbUnmarshaller.unmarshal(stream);
            PersonsPersistence persistence = new PersonsPersistence();
            persistence.persist(objPerson);
            System.out.println("entity create = " + objPerson.toString());

//        super.create(entity);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }


    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person find(@PathParam("id") Integer id) {
        Person person = super.find(id);
        String xmlString = "";
        System.out.println("person = " + person);
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Person.class);

            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(person, sw);
            xmlString = sw.toString();
            System.out.println("xmlString = " + xmlString);
//        System.out.println("em  find = " + em);
//        this.em = this.getEntityManager();
//         System.out.println("em  find post = " + em);
//        Query query = em.createNativeQuery("select * from common.person p join common.person_phones pp on p.person_id = pp.person_id where p.person_id= ? ", Person.class);
//        query.setParameter(1, id);
//        Person pesronResult = (Person) query.getSingleResult();
//        System.out.println("pesronResult = " + pesronResult);
        } catch (JAXBException ex) {
            Logger.getLogger(PersonFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @GET
    @Path("findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persons findAllPerson() {
        List<Person> personList = super.findAll();
        Persons persons = new Persons();
        persons.setPersons(personList);;
        System.out.println("persons = " + persons);
        return persons;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        try {

            String PERSISTENCE_UNIT_NAME = AlmacenPropiedades.getPropiedad("PERSISTENCE_UNIT_NAME");

            System.out.println("PERSISTENCE_UNIT_NAME = " + PERSISTENCE_UNIT_NAME);
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("Convenio36OCTDPU");

            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            System.out.println("em = " + em);
            System.out.println("factory = " + factory);
            em = factory.createEntityManager();

            System.out.println("em = " + em);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return em;
    }

}
