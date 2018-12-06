/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.service.persistence;


import com.java.cargonam.bean.Person;
import com.java.cargonam.util.Conexbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author furibe
 */
public class PersonsPersistence extends JpaDao<Integer, Person>{

    public PersonsPersistence() {
        super();
    }
//    private Connection conn = null;
//    private PreparedStatement stm = null;
//    private ResultSet rs = null;

//    public PersonView getPersonById(Integer id) throws Exception {
//
//        PersonView personView = new PersonView();
//        PersonView personViewChild;
//        List<RelationshipsView> relationshipses = new ArrayList<>();
//
//        RelationshipsView relationshipsView;
//        String sql = "select per.*,pe.* from person pe right join (SELECT p.person_id as person_fa_id , p.First_Name as person_fa_first_Name "
//                + "  ,p.last_Name as person_fa_last_Name, p.age as person_fa_age , rt.name as name_relationship_types_id, rt.id as relationship_types_id , r.person_id_child from  PERSON p "
//                + " left JOIN relationships r on p.person_id = r.person_id "
//                + " left JOIN relationship_types rt on r.relationship_types_id = rt.id) per "
//                + "on pe.person_id = per.person_id_child "
//                + "WHERE person_fa_id = ? ";
//
//        try {
//            conn = Conexbd.getConnectionDirecta();
//            stm = conn.prepareStatement(sql);
//            stm.setInt(1, id);
//
//            stm.execute();
//            rs = stm.getResultSet();
//
//            while (rs.next()) {
//                if (personView.getPersonId() != null) {
//                    if (!personView.getPersonId().equals(rs.getInt("person_fa_id"))) {
//                        personView.setPersonId(rs.getInt("person_fa_id"));
//                        personView.setFirstName(rs.getString("person_fa_first_Name"));
//                        personView.setLastName(rs.getString("person_fa_last_Name"));
//                        personView.setAge(rs.getInt("person_fa_age"));
//                    }
//                } else {
//                    personView.setPersonId(rs.getInt("person_fa_id"));
//                    personView.setFirstName(rs.getString("person_fa_first_Name"));
//                    personView.setLastName(rs.getString("person_fa_last_Name"));
//                    personView.setAge(rs.getInt("person_fa_age"));
//                }
//                if (!relationshipses.isEmpty()) {
//                    personView.setRelationshipses(relationshipses);
//                }
//                relationshipses = getchildByPerson(personView.getPersonId());
//                System.out.println("relationshipses = " + relationshipses);
//                if (!relationshipses.isEmpty()) {
//                    personView.setRelationshipses(relationshipses);
//                }
////                relationshipsView = new RelationshipsView();
////                relationshipsView.setRelationshipTypesView(new RelationshipTypesView(rs.getInt("relationship_types_id"), rs.getString("name_relationship_types_id")));
////                personViewChild = new PersonView();
////                personViewChild.setPersonId(rs.getInt("person_id"));
////                personViewChild.setFirstName(rs.getString("first_Name"));
////                personViewChild.setLastName(rs.getString("last_Name"));
////                personViewChild.setAge(rs.getInt("age"));
////                relationshipsView.setPersonView(personViewChild);
////                relationshipses.add(relationshipsView);
////                personView.setRelationshipses(relationshipses);
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(conn, stm, rs);
//        }
//        return personView;
//
//    }
//
//    public List<RelationshipsView> getchildByPerson(Integer personId) throws Exception {
//        Connection connChildByPerson = null;
//        PreparedStatement stmChildByPerson = null;
//        ResultSet rsChildByPerson = null;
//        PersonView personView;
//        List<RelationshipsView> relationshipses = new ArrayList<>();
//        RelationshipsView relationshipsView;
//
//        String sql = "SELECT P.*,rt.* FROM relationships r JOIN PERSON P ON P.PERSON_ID = R.PERSON_ID_CHILD  JOIN  relationship_types rt on r.relationship_types_id = rt.id \n"
//                + "WHERE R.PERSON_ID = ? ";
//
//        try {
//            connChildByPerson = Conexbd.getConnectionDirecta();
//            stmChildByPerson = connChildByPerson.prepareStatement(sql);
//            stmChildByPerson.setInt(1, personId);
//
//            stmChildByPerson.execute();
//            rsChildByPerson = stmChildByPerson.getResultSet();
//
//            while (rsChildByPerson.next()) {
//                personView = new PersonView();
//
//                personView.setPersonId(rsChildByPerson.getInt("person_id"));
//                personView.setFirstName(rsChildByPerson.getString("first_Name"));
//                personView.setLastName(rsChildByPerson.getString("last_Name"));
//                personView.setAge(rsChildByPerson.getInt("age"));
//                relationshipsView = new RelationshipsView();
//                relationshipsView.setRelationshipTypesView(new RelationshipTypesView(rsChildByPerson.getInt("id"), rsChildByPerson.getString("name")));
//                relationshipsView.setPersonView(personView);
//                relationshipses.add(relationshipsView);
//
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(connChildByPerson, stmChildByPerson, rsChildByPerson);
//        }
//        return relationshipses;
//    }
//
//    public Boolean isChildPerson(Integer personId) throws Exception {
//
//        Boolean flag = false;
//
//        String sql = "SELECT count(*) FROM relationships "
//                + "WHERE person_id_child = ? ";
//
//        try {
//            conn = Conexbd.getConnectionDirecta();
//            stm = conn.prepareStatement(sql);
//            stm.setInt(1, personId);
//
//            stm.execute();
//            rs = stm.getResultSet();
//
//            if (rs.next()) {
//
//                flag = true;
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(conn, stm, rs);
//        }
//        return flag;
//
//    }
//
//    public List<PersonView> findAll() throws Exception {
//        Connection connFindAll = null;
//        PreparedStatement stmFindAll = null;
//        ResultSet rsFindAll = null;
//        PersonView personView = null;
//        PersonView personViewChild;
//        List<RelationshipsView> relationshipses = new ArrayList<>();
//        List<PersonView> personViews = new ArrayList<>();
//
//        RelationshipsView relationshipsView;
//        String sql = "select per.*,pe.* from person pe right join (SELECT p.person_id as person_fa_id , p.First_Name as person_fa_first_Name "
//                + "  ,p.last_Name as person_fa_last_Name, p.age as person_fa_age , rt.name as name_relationship_types_id, rt.id as relationship_types_id , r.person_id_child from  PERSON p "
//                + " left JOIN relationships r on p.person_id = r.person_id "
//                + " left JOIN relationship_types rt on r.relationship_types_id = rt.id) per "
//                + "on pe.person_id = per.person_id_child ";
//
//        try {
//            connFindAll = Conexbd.getConnectionDirecta();
//            stmFindAll = connFindAll.prepareStatement(sql);
//
//            stmFindAll.execute();
//            rsFindAll = stmFindAll.getResultSet();
//            Integer idPerson = 0;
//            while (rsFindAll.next()) {
//                personView = new PersonView();
//
//                if (!idPerson.equals(rsFindAll.getInt("person_fa_id"))) {
//                    idPerson = rsFindAll.getInt("person_fa_id");
//                    personView.setPersonId(rsFindAll.getInt("person_fa_id"));
//                    personView.setFirstName(rsFindAll.getString("person_fa_first_Name"));
//                    personView.setLastName(rsFindAll.getString("person_fa_last_Name"));
//                    personView.setAge(rsFindAll.getInt("person_fa_age"));
//                    relationshipses = getchildByPerson(personView.getPersonId());
//                    System.out.println("relationshipses = " + relationshipses);
//                    if (!relationshipses.isEmpty()) {
//                        personView.setRelationshipses(relationshipses);
//                    }
//                    personViews.add(personView);
//                }
//
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(connFindAll, stmFindAll, rsFindAll);
//        }
//        return personViews;
//
//    }
//
//    public List<RelationshipTypesView> findRelationshipsType() throws Exception {
//        Connection connFindAll = null;
//        PreparedStatement stmFindAll = null;
//        ResultSet rsFindAll = null;
//        RelationshipTypesView relationshipTypesView = null;
//
//        List<RelationshipTypesView> relationshipTypesViews = new ArrayList<>();
//
//        RelationshipsView relationshipsView;
//        String sql = "SELECT * FROM relationship_types "
//                + "ORDER BY 2 ASC ";
//
//        try {
//            connFindAll = Conexbd.getConnectionDirecta();
//            stmFindAll = connFindAll.prepareStatement(sql);
//
//            stmFindAll.execute();
//            rsFindAll = stmFindAll.getResultSet();
//            Integer idPerson = 0;
//            while (rsFindAll.next()) {
//                relationshipTypesView = new RelationshipTypesView();
//                relationshipTypesView.setId(rsFindAll.getInt("id"));
//                relationshipTypesView.setName(rsFindAll.getString("name"));
//                relationshipTypesViews.add(relationshipTypesView);
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(connFindAll, stmFindAll, rsFindAll);
//        }
//        return relationshipTypesViews;
//
//    }
//
//    public Boolean isUserValid(String username, String password) throws Exception {
//
//        String sql = "SELECT username, password "
//                + "	FROM users "
//                + "	where username = ? and password = ?";
//        Boolean flag = false;
//        System.out.println("sql = " + sql);
//
//        try {
//            conn = Conexbd.getConnectionDirecta();
//            stm = conn.prepareStatement(sql);
//            stm.setString(1, username);
//            stm.setString(2, password);
//
//            stm.execute();
//            rs = stm.getResultSet();
//
//            if (rs.next()) {
//                System.out.println("user = " + rs.getString("username"));
//                System.out.println("password = " + rs.getString("password"));
//                flag = true;
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            Conexbd.closeConnection(conn, stm, rs);
//        }
//        return flag;
//
//    }
//
//    public Boolean insertPerson(PersonView personView) throws Exception {
//        Boolean bSuccess = false;
//        Connection connInsertPerson = null;
//        PreparedStatement stmRelationships = null;
//        PreparedStatement insertPersonChild = null;
//        PreparedStatement insertPersonFa = null;
//        PreparedStatement selctRelationship = null;
//        PreparedStatement stmDeleteRelationChildships = null;
//        ResultSet rsRelationship = null;
//        String sql = "INSERT INTO person (person_ID,Last_Name, First_Name, Age) VALUES "
//                + "(?,?, ?, ?)";
//
//        String sqlRelationships = "INSERT INTO relationships (person_id, person_id_child,relationship_types_id) VALUES "
//                + "(?, ?, ?)";
//
//        String sqlUpdatePerson = "UPDATE person "
//                + "	SET first_name=?, last_name=?, age=? "
//                + "	WHERE person_id = ? ";
//
//        String selctRelationships = "SELECT person_id, person_id_child, relationship_types_id "
//                + "	FROM relationships "
//                + "	WHERE person_id = ? AND person_id_child = ?";
//        String sqlDeleteRelationChildships = "DELETE FROM relationships WHERE person_id = ? ";
//        try {
//
//            connInsertPerson = Conexbd.getConnectionDirecta();
//            connInsertPerson.setAutoCommit(false);
//            PersonView personViewfa = getPersonById(personView.getPersonId());
//            if (personViewfa.getPersonId() == null) {
//                insertPersonFa = connInsertPerson.prepareStatement(sql);
//                insertPersonFa.setInt(1, personView.getPersonId());
//                insertPersonFa.setString(2, personView.getLastName());
//                insertPersonFa.setString(3, personView.getFirstName());
//                insertPersonFa.setInt(4, personView.getAge());
//                insertPersonFa.executeUpdate();
//            } else {
//                insertPersonFa = connInsertPerson.prepareStatement(sqlUpdatePerson);
//                insertPersonFa.setString(1, personView.getFirstName());
//                insertPersonFa.setString(2, personView.getLastName());
//                insertPersonFa.setInt(3, personView.getAge());
//                insertPersonFa.setInt(4, personView.getPersonId());
//                insertPersonFa.executeUpdate();
//            }
//
//            List<RelationshipsView> relationshipsViews = personView.getRelationshipses();
//
//            if (relationshipsViews != null) {
//                stmDeleteRelationChildships = connInsertPerson.prepareStatement(sqlDeleteRelationChildships);
//                stmDeleteRelationChildships.setInt(1, personView.getPersonId());
//                stmDeleteRelationChildships.execute();
//                for (RelationshipsView relationshipsView : relationshipsViews) {
//                    stmRelationships = connInsertPerson.prepareStatement(sqlRelationships);
//                    PersonView personViewChild = getPersonById(relationshipsView.getPersonView().getPersonId());
//                    if (personViewChild.getPersonId() != null) {
//                        insertPersonFa = connInsertPerson.prepareStatement(sqlUpdatePerson);
//                        insertPersonFa.setString(1, relationshipsView.getPersonView().getFirstName());
//                        insertPersonFa.setString(2, relationshipsView.getPersonView().getFirstName());
//                        insertPersonFa.setInt(3, relationshipsView.getPersonView().getAge());
//                        insertPersonFa.setInt(4, relationshipsView.getPersonView().getPersonId());
//                        insertPersonFa.executeUpdate();
//                        
//                        selctRelationship = connInsertPerson.prepareStatement(selctRelationships);
//                        selctRelationship.setInt(1, personView.getPersonId());
//                        selctRelationship.setInt(2, relationshipsView.getPersonView().getPersonId());
//                        selctRelationship.execute();
//
//                        stmRelationships.setInt(1, personView.getPersonId());
//                        stmRelationships.setInt(2, relationshipsView.getPersonView().getPersonId());
//                        stmRelationships.setInt(3, relationshipsView.getRelationshipTypesView().getId());
//                        stmRelationships.executeUpdate();
//
//                    } else {
//
//                        insertPersonChild = connInsertPerson.prepareStatement(sql);
//                        insertPersonChild.setInt(1, relationshipsView.getPersonView().getPersonId());
//                        insertPersonChild.setString(2, relationshipsView.getPersonView().getLastName());
//                        insertPersonChild.setString(3, relationshipsView.getPersonView().getFirstName());
//                        insertPersonChild.setInt(4, relationshipsView.getPersonView().getAge());
//                        insertPersonChild.executeUpdate();
//
//                        stmRelationships.setInt(1, personView.getPersonId());
//                        stmRelationships.setInt(2, relationshipsView.getPersonView().getPersonId());
//                        stmRelationships.setInt(3, relationshipsView.getRelationshipTypesView().getId());
//                        stmRelationships.executeUpdate();
//                    }
//                }
//            }
//            bSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            if (connInsertPerson != null) {
//                if (bSuccess) {
//                    connInsertPerson.commit();
//                } else {
//                    connInsertPerson.rollback();
//                }
//                Conexbd.closeConnection(connInsertPerson, stmRelationships, rsRelationship);
//                Conexbd.closeConnection(null, selctRelationship, null);
//                Conexbd.closeConnection(null, insertPersonChild, null);
//                Conexbd.closeConnection(null, insertPersonFa, null);
//                Conexbd.closeConnection(null, stmDeleteRelationChildships, null);
//            }
//
//        }
//        return bSuccess;
//
//    }
//
//    public Boolean deletePersonById(Integer personId) throws Exception {
//        Boolean bSuccess = false;
//        Connection connDeletePerson = null;
//        PreparedStatement stmDeletePerson = null;
//        PreparedStatement stmDeletePersonChild = null;
//        PreparedStatement stmDeleteChild = null;
//
//        String sqlDeletePerson = "DELETE FROM person WHERE  person_id = ? ";
//
//        String sqlDeleteRelationships = "DELETE FROM relationships WHERE person_id = ? ";
//
//        String sqlDeleteRelationChildships = "DELETE FROM relationships WHERE person_id_child = ? ";
//
//        try {
//
//            connDeletePerson = Conexbd.getConnectionDirecta();
//            connDeletePerson.setAutoCommit(false);
//            List<RelationshipsView> relationshipsViews = getchildByPerson(personId);
//            Boolean isChild = isChildPerson(personId);
//            if (!relationshipsViews.isEmpty()) {
//                stmDeletePersonChild = connDeletePerson.prepareStatement(sqlDeleteRelationships);
//                stmDeletePersonChild.setInt(1, personId);
//                stmDeletePersonChild.executeUpdate();
//            }
//            if (isChild) {
//                stmDeleteChild = connDeletePerson.prepareStatement(sqlDeleteRelationChildships);
//                stmDeleteChild.setInt(1, personId);
//                stmDeleteChild.executeUpdate();
//            }
//            stmDeletePerson = connDeletePerson.prepareStatement(sqlDeletePerson);
//            stmDeletePerson.setInt(1, personId);
//            stmDeletePerson.executeUpdate();
//
//            bSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            if (connDeletePerson != null) {
//                if (bSuccess) {
//                    connDeletePerson.commit();
//                } else {
//                    connDeletePerson.rollback();
//                }
//                Conexbd.closeConnection(connDeletePerson, stmDeletePerson, null);
//                Conexbd.closeConnection(null, stmDeletePersonChild, null);
//                Conexbd.closeConnection(null, stmDeleteChild, null);
//            }
//
//        }
//        return bSuccess;
//
//    }
//
//    public Boolean deleteRelationshipsByPerson(Integer personId, Integer personidchild) throws Exception {
//        Boolean bSuccess = false;
//        Connection connDeletePerson = null;
//        PreparedStatement stmDeletePerson = null;
//        PreparedStatement stmDeletePersonChild = null;
//        PreparedStatement stmDeleteChild = null;
//
//        String sqlDeleteRelationChildships = "DELETE FROM relationships WHERE person_id_child = ? AND person_id = ?";
//
//        try {
//
//            connDeletePerson = Conexbd.getConnectionDirecta();
//            connDeletePerson.setAutoCommit(false);
//
//            stmDeleteChild = connDeletePerson.prepareStatement(sqlDeleteRelationChildships);
//
//            stmDeleteChild.setInt(1, personidchild);
//            stmDeleteChild.setInt(2, personId);
//            stmDeleteChild.executeUpdate();
//
//            bSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        } finally {
//            if (connDeletePerson != null) {
//                if (bSuccess) {
//                    connDeletePerson.commit();
//                } else {
//                    connDeletePerson.rollback();
//                }
//                Conexbd.closeConnection(connDeletePerson, stmDeletePerson, null);
//                Conexbd.closeConnection(null, stmDeletePersonChild, null);
//                Conexbd.closeConnection(null, stmDeleteChild, null);
//            }
//
//        }
//        return bSuccess;
//
//    }

}
