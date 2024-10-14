/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import ma.projet.beans.Projet;
import ma.projet.beans.Projet;
import ma.projet.dao.Idao;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author OUMAIMA
 */
public class ProjetService implements Idao < Projet > {
      @Override
    public Boolean create(Projet o) {
     Session session = null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         session.save(o);
         session.getTransaction().commit();
         return true;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
     }

    @Override
    public Projet getById(int o) {
        Session session = null;
        Projet projet=null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         projet=(Projet)session.get(Projet.class, o);
         
         session.getTransaction().commit();
         return projet;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return projet;
     }

    @Override
    public List<Projet> getAll() {
       Session session = null;
      List <Projet>  projets =null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         projets= session.createQuery("FROM projet").list();
         session.getTransaction().commit();
         return projets;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return projets;
     }
   
    
    
}
