/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.beans.Tache;
import ma.projet.beans.Tache;
import ma.projet.dao.Idao;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author OUMAIMA
 */
public class TacheService implements Idao < Tache >  {
      @Override
    public Boolean create(Tache o) {
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
    public Tache getById(int o) {
        Session session = null;
        Tache tache=null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         tache=(Tache)session.get(Tache.class, o);
         
         session.getTransaction().commit();
         return tache;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return tache;
     }

    @Override
    public List<Tache> getAll() {
       Session session = null;
      List <Tache>  taches =null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         taches= session.createQuery("FROM tache").list();
         session.getTransaction().commit();
         return taches;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return taches;
     }
     public void getT(){
         Session session =null;
         List<Tache>tache=null;
           try {
               session=NewHibernateUtil.getSessionFactory().openSession();
               session.beginTransaction();
              tache=session.createQuery("FROM Tache t WHERE t.prix>1000").list();
               System.out.println("les listes des produits superieur a 1000 dh sont :");
               for (Tache e : tache) {
                   System.out.println(" :"+ e.getNon()  );
                   
               }
           }
               
              catch(HibernateException e )  {
         session.getTransaction().rollback();
           
        }finally{
            session.close();
            } 
                
     }
   
}
