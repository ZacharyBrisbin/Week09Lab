package database;

import models.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDB {

    public int insert(Users user) throws GroupDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int rows = 0;
        try{
            String username = user.getUsername();
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();
            String password = user.getPassword();
            trans.begin();
            em.persist(username);
            em.persist(email);
            em.persist(firstname);
            em.persist(lastname);
            em.persist(password);
            em.merge(user);
            trans.commit();
            rows = 1;
        }catch(Exception e){
            trans.rollback();
        }
        finally
        {
            em.close();
        }
        return rows;
    }

    public int update(Users user) throws GroupDBException {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
       int rows = 0;
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
            rows = 1;
        } catch(Exception e){
            trans.rollback();
        }finally {
           em.close();
        }
        return rows;
    }

    public List<Users> getAll() throws GroupDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Users> users = em.createNamedQuery("Users.findAll",Users.class).getResultList();
            return users;
        } finally {
         em.close();
        }
    }

    /**
     * Get a single user by their username.
     *
     * @param username The unique username.
     * @return A User object if found, null otherwise.
     * @throws database.GroupDBException
     * @throws NotesDBException
     */
    public Users getUser(String username) throws GroupDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();        
        try {
            Users user = em.find(Users.class, username);;
            return user;
        } finally {
         em.close();
        }
    }

    public int delete(Users user) throws GroupDBException {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int rows = 0;
        
        try{
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
            rows = 1;
        }catch(Exception e){
            trans.rollback();
        }finally{
            em.close();
        }
        return rows;
    }
}
