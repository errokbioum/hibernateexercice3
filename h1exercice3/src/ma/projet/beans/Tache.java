/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String non;
    private Date dateDebut;
    private Date dateFin;
    private double prix;
    @ManyToOne
    private Projet projet;
    @OneToMany(mappedBy = "tache" , fetch = FetchType.EAGER)
    List<EmployeTache>employeTaches=null;

    public Tache(String non, String dateDebut, String  dateFin, double prix, Projet projet) {
        this.non = non;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDate localDateDebut = LocalDate.parse(dateDebut, formatter);
        LocalDate localDateFin = LocalDate.parse(dateFin, formatter);
        this.dateDebut = java.sql.Date.valueOf(localDateDebut);
        this.dateFin = java.sql.Date.valueOf(localDateFin);

     
        this.prix = prix;
        this.projet = projet;
    }

    public Tache() {
    }
 public List<EmployeTache> getEmployeTaches() {
        return employeTaches;
    }
    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

   

    public void setEmployeTaches(List<EmployeTache> employeTaches) {
        this.employeTaches = employeTaches;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", non=" + non + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + '}';
    }

    public Tache(int id, String non, Date dateDebut, Date dateFin, double prix) {
        this.id = id;
        this.non = non;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

  

    public Tache(String non, Date dateDebut, Date dateFin, double prix) {
        this.non = non;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }
    
}
