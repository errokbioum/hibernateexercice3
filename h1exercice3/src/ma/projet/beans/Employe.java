/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author OUMAIMA
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String non;
    private String prenon ;
    private double telephone;
    @OneToMany(mappedBy = "employe" , fetch = FetchType.EAGER)
    List<Projet>projets=null;
    @OneToMany(mappedBy ="employ" , fetch = FetchType.EAGER)
    List<EmployeTache>employeTaches=null;

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<EmployeTache> getEmployeTaches() {
        return employeTaches;
    }

    public void setEmployeTaches(List<EmployeTache> employeTaches) {
        this.employeTaches = employeTaches;
    }

    public Employe() {
    }

    public Employe(String non, String prenon, double telephone) {
        this.non = non;
        this.prenon = prenon;
        this.telephone = telephone;
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

    public String getPrenon() {
        return prenon;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
    }

    public double getTelephone() {
        return telephone;
    }

    public void setTelephone(double telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", non=" + non + ", prenon=" + prenon + ", telephone=" + telephone + '}';
    }
    
    
    
}
