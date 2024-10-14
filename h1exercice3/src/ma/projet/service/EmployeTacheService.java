/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.beans.EmployeTache;

import ma.projet.dao.Idao;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author OUMAIMA
 */
public class EmployeTacheService implements Idao<EmployeTache>{
    
      @Override
    public Boolean create(EmployeTache o) {
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
    public EmployeTache getById(int o) {
        Session session = null;
        EmployeTache employeTache=null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         employeTache=(EmployeTache)session.get(EmployeTache.class, o);
         
         session.getTransaction().commit();
         return employeTache;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employeTache;
     }

    @Override
    public List<EmployeTache> getAll() {
       Session session = null;
      List <EmployeTache>  employeTaches =null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         employeTaches= session.createQuery("FROM  EmployeTache").list();
         session.getTransaction().commit();
         return employeTaches;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employeTaches;
     }
    
}
