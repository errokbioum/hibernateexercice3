/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.beans.Employe;
import ma.projet.beans.EmployeTache;
import ma.projet.beans.Projet;
import ma.projet.beans.Tache;
import ma.projet.dao.Idao;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author OUMAIMA
 */
public class EmployeService implements  Idao <Employe> {

   @Override
    public Boolean create(Employe o) {
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
    public Employe getById(int o) {
        Session session = null;
        Employe employe=null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         employe=(Employe)session.get(Employe.class, o);
         
         session.getTransaction().commit();
         return employe;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employe;
     }

    @Override
    public List<Employe> getAll() {
       Session session = null;
      List <Employe>  employes =null;
     try {
         session=NewHibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         employes= session.createQuery("FROM employe").list();
         session.getTransaction().commit();
         return employes;
         
     }catch (HibernateException e ) {
         session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employes;
     }
   public void ListeTacheE( int id){
       EmployeService ss = new EmployeService();
       Employe e = ss.getById(id);
       List <EmployeTache> sa =e.getEmployeTaches();
       System.out.println("les taches realiser par  l'employe  : "+e.getNon() + "  "+ e.getPrenon() + "  sont : " + "  "   );
       for (EmployeTache es : sa) {
           System.err.println(" non : " + es.getTache().getNon()  );
           
       }
   }
   public void ListProjet( int id){
       EmployeService pp = new EmployeService();
       Employe e = pp.getById(id);
       List<Projet> projets = e.getProjets();
       System.out.println(" -->>>liste de projet gerer  par :  "+ e. getNon() + " "+ e.getPrenon());
       for (Projet x : projets) {
           System.out.println( " "+   x.getNon() );
           
       }
       
   }
   public void listTacheP(int id ){
         ProjetService pp = new ProjetService();
       Projet e = pp.getById(id);
       List<Tache> taches = e.getTache();
       System.out.println(" -->>>liste des taches planifier pour le projet :  "+ e.getNon() );
       for (Tache x : taches) {
           System.out.println( " "+   x.getNon() );
       
   }
       
   
}
   public void ListTotal(int id){
    TacheService tt = new TacheService();
    ProjetService pp= new ProjetService();
    EmployeTacheService yy =new EmployeTacheService();
    List< EmployeTache > bb= yy.getAll();
    Projet p = pp.getById(id);
       List <Tache> ss = p.getTache();
          System.out.println(" projet :" + id+"             nom :  "+p.getNon()    +"         Date de debut : "+ p.getDatedebut());
       System.out.println(" Liste des taches ");  
       System.out.println(" Num                             NOm                   Date de debut Reel               Date de fin Reel   " );
    
       for (EmployeTache g : bb) {
           if (g.getTache() != null && g.getTache().getProjet() != null) {
          if(  (g.getTache().getProjet().getId()) == id ){
          System.out.println(  "  " + g.getTache().getId()     +"                           "+  g.getTache().getNon()        +"                   "+ g);
  
      }
            }
       }
      
        }
//   public void list () {
//       Scanner sc= new Scanner( System.in);
//         System.err.println("entrer premier date");
//        String f= sc.nextLine();
//        System.err.println("entrer deuscieme  date");
//        String ff= sc.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//         Date localDateDebut = (Date) formatter.parse(f);
//           Date localDateFin = (Date) formatter.parse(ff);
//      
//        TacheService tt = new TacheService();
//        List<Tache > list = tt.getAll();
//         for (Tache e : list) {
//            if (e.getDateDebut() != null && e.getDateFin() != null) {
//                    if ((e.getDateDebut().after(localDateDebut) || e.getDateDebut().equals(localDateDebut)) &&
//                        (e.getDateFin().before(localDateFin) || e.getDateFin().equals(localDateFin))) {
//                        System.out.println(e.getNon());
//                    }
//                }
//             
//         }
//        
//    }
  
//       public List<Tache> findTachesBetweenDates(Date DateDebut, Date DateFin) {
//       
//        Session session = null;
//        Scanner sc= new Scanner( System.in);
//         
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//         Date a = (Date) formatter.parse((CharSequence) DateDebut);
//          Date b = (Date) formatter.parse((CharSequence) DateFin);
//           
//         try {
//         session=NewHibernateUtil.getSessionFactory().openSession();
//         session.beginTransaction();
//        // Création de la requête avec les paramètres
//        List fa = session.createQuery("FROM Tache t WHERE t.dateDebut >= :dateDebut AND t.dateFin <= :dateFin").setParameter("dateDebut", a).setParameter("dateFin", b).list();  ;
//        session.getTransaction().commit();
//         return fa ;
//         
//     }catch (HibernateException e ) {
//         session.getTransaction().rollback();
//        }finally{
//            session.close();
//        }
//        
//        // Exécuter la requête et retourner les résultats
//       return null;
//     
//      
//   }     
   } 

   
    
      
    
       
   
   
