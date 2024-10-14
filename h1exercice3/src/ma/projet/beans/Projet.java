/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author OUMAIMA
 */
@Entity
public class Projet {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String non ;
   private  Date datedebut ;
   private Date dateFin;
   @ManyToOne
   Employe employe ;
   @OneToMany( mappedBy = "projet",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
   List<Tache> tache =null;

    public Projet(int id, String non, String datedebut, String dateFin, Employe employe) {
        this.id = id;
        this.non = non;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate localDateDebut = LocalDate.parse(datedebut, formatter);
        LocalDate localDateFin = LocalDate.parse(dateFin, formatter);
        this.datedebut = java.sql.Date.valueOf(localDateDebut);
        this.dateFin = java.sql.Date.valueOf(localDateFin);
       
        this.employe = employe;
    }

    public Projet(String non, String datedebut, String dateFin, Employe employe) {
        this.non = non;
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate localDateDebut = LocalDate.parse(datedebut, formatter);
        LocalDate localDateFin = LocalDate.parse(dateFin, formatter);
        this.datedebut = java.sql.Date.valueOf(localDateDebut);
        this.dateFin = java.sql.Date.valueOf(localDateFin);
       
        this.employe = employe;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Tache> getTache() {
        return tache;
    }

    public void setTache(List<Tache> tache) {
        this.tache = tache;
    }

    public Projet() {
    }

    public Projet(String non, Date datedebut, Date dateFin) {
        this.non = non;
        this.datedebut = datedebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNon() {
        return non;
    }

    public void setNon(String non) {
        this.non = non;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", non=" + non + ", datedebut=" + datedebut + ", dateFin=" + dateFin + '}';
    }
   
    
}
