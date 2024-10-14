/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author OUMAIMA
 */
@Embeddable
public class EmployeTachePk implements Serializable{
    private int  employe;
    private int Tache ;
    private Date dateDebutRell;

    public EmployeTachePk(int employe, int Tache, String dateDebutRell) {
        this.employe = employe;
        this.Tache = Tache;
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate localDateDebut = LocalDate.parse(dateDebutRell, formatter);
       
        this.dateDebutRell = java.sql.Date.valueOf(localDateDebut);
      
    }

    public Date getDateDebutRell() {
        return dateDebutRell;
    }

    public void setDateDebutRell(Date dateDebutRell) {
        this.dateDebutRell = dateDebutRell;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return Tache;
    }

    public void setTache(int Tache) {
        this.Tache = Tache;
    }

    public EmployeTachePk() {
    }

    public EmployeTachePk(int employe, int Tache) {
        this.employe = employe;
        this.Tache = Tache;
    }

    @Override
    public String toString() {
        return "EmployeTachePk{" + "employe=" + employe + ", Tache=" + Tache + '}';
    }
    
    
    
}
