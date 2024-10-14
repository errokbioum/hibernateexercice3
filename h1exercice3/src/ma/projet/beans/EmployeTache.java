/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author OUMAIMA
 */
@Entity
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePk employeTachePk;
    @ManyToOne
    private Tache tache ;
    @ManyToOne
    private Employe employ;
    
    
    private Date dateFinReel ;

    public EmployeTache(EmployeTachePk employeTachePk, Tache tache, Employe employe, String dateFinReel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate localDateDebut = LocalDate.parse(dateFinReel, formatter);
       
        this.dateFinReel= java.sql.Date.valueOf(localDateDebut);
        this.employeTachePk = employeTachePk;
        this.tache = tache;
        this.employ = employe;
        
       
    }

    public EmployeTache(Tache tache, Employe employe, Date dateFinReel) {
        this.tache = tache;
        this.employ = employe;
     
        this.dateFinReel = dateFinReel;
    }

    public EmployeTache() {
    }

    public EmployeTachePk getEmployeTachePk() {
        return employeTachePk;
    }

    public void setEmployeTachePk(EmployeTachePk employeTachePk) {
        this.employeTachePk = employeTachePk;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employe getEmploye() {
        return employ;
    }

    public void setEmploye(Employe employe) {
        this.employ = employe;
    }

  

   

   

    public Date getDateFinReel() {
        return dateFinReel;
    }

    public void setDateFinReel(Date dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    @Override
    public String toString() {
        return ""  +    employeTachePk.getDateDebutRell() + "                          " + dateFinReel + "";
    }
    
    
    
}
