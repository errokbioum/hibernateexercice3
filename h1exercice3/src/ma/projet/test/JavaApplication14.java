/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.EmployeTache;
import ma.projet.beans.EmployeTachePk;
import ma.projet.beans.Projet;
import ma.projet.beans.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;
import ma.projet.util.NewHibernateUtil;

/**
 *
 * @author OUMAIMA
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewHibernateUtil.getSessionFactory();
        EmployeService pp = new EmployeService();
        EmployeTacheService ss= new EmployeTacheService();
         ProjetService pr= new ProjetService();
        TacheService tt= new TacheService();
        Employe p1 = new  Employe("benkiran", "selma", 065676546);
        Employe p2 = new  Employe("berrada", "mouaad", 076745434);
        Employe p3 = new  Employe("feraa", "badr", 06236567);
        Employe p4 = new  Employe("bensliman", "oumaima", 065676673);
        Employe p5 = new  Employe("ahradi", "wiam", 065676676);
        Employe p6 = new  Employe("ait moh", "youness", 075670546);
        Employe p7 = new  Employe("safaae", "salmi", 06562345);
        Employe p8 = new  Employe("chemssi", "yassine", 075676540);
         pp.create(p1);
          pp.create(p2);
           pp.create(p3);
           pp.create(p4);
            pp.create(p5);
             pp.create(p6);
              pp.create(p7);
               pp.create(p8);
                 Projet g1 = new Projet("hackathon ", "2018/12/03", "2030/12/03",p1);
                Projet g2 = new Projet("olpic", "2020/12/03", "2025/12/03",p2);
                 Projet g3 = new Projet("start","2019/12/03","2029/12/03",p1);
                  Projet g4 = new Projet("magic", "2016/12/03","2028/12/03",p2);
               
                       
          
                pr.create(g1);
                pr.create(g2);
                pr.create(g3);
                pr.create(g4);
              
       
        Tache t1 = new Tache("development","2010/12/03" ,"2019/02/05",8000,g1);
         Tache t2 = new Tache("Architecture","2010/12/03","2019/10/03",5000,g1);
          Tache t3 = new Tache("dessin","2010/12/03","2020/12/03",400,g1);
           Tache t4 = new Tache("photographie","2011/12/03","2020/12/03",2000,g2);
            Tache t5 = new Tache("developpement","2011/12/03","2019/02/13",300,g2);
             Tache t6 = new Tache("development","2011/12/03","2020/12/23",199,g2);
              Tache t7 = new Tache("Architecture","2011/12/03","2019/12/09",10000,g2);
               Tache t8 = new Tache("dessin ","2011/12/03","2020/11/03",1300,g2);
               tt.create(t1);
               tt.create(t2);
           tt.create(t3);
               tt.create(t4);
               tt.create(t5);
               tt.create(t6);
               tt.create(t7);
               tt.create(t8);
               
               
               
               
               EmployeTachePk e1 = new EmployeTachePk(1, 1,"2018/12/05");
                EmployeTachePk e3 = new EmployeTachePk(2, 2, "2019/12/08");
                 EmployeTachePk e4 = new EmployeTachePk(3, 3, "2016/12/03" );
                 EmployeTachePk e5 = new EmployeTachePk(4, 4, "2017/12/03" );
                   EmployeTachePk e6 = new EmployeTachePk(5, 4, "2019/12/04" );
                   
                   EmployeTache a1= new EmployeTache(e1, t1, p1,"2020/11/09" );
                   EmployeTache a2= new EmployeTache(e3, t2, p2,"2020/01/03" );
                   EmployeTache a3= new EmployeTache(e4, t3, p3,"2010/10/09" );
                   EmployeTache a4= new EmployeTache(e5, t4, p4,"2020/11/05");
                   EmployeTache a5= new EmployeTache(e6, t5, p5,"2020/11/08" );
                
                   ss.create(a1);
                   ss.create(a2);
                    ss.create(a3);
                      ss.create(a4);
                       ss.create(a5);
                    EmployeTachePk rr=new EmployeTachePk(4, 1,"2019/12/03"  );
                     EmployeTache dd = new EmployeTache(rr, tt.getById(1), pp.getById(4),"2020/12/03");
                      ss.create(dd);
                      Tache t= tt.getById(4);
                      EmployeTachePk r=new EmployeTachePk(1, 4,"2019/12/03"  );
                      EmployeTache d = new EmployeTache(r, t, pp.getById(1), "2020/12/03");
                      
                      ss.create(d);
                       
               pp.ListeTacheE(1);
                pp.ListProjet(2);
                pp.listTacheP(1);
                 pp.ListTotal(2);
                tt.getT();
                 
            
                
             
    }
    
}
