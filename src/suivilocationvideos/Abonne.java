/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Achraf
 */
public class Abonne {
    
    private String nom;
    private String dateNaissance;
    private String sexe;
    private int revenu;

    public Abonne(String nom, String dateNaissance, String sexe, int revenu) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.revenu = revenu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getRevenu() {
        return revenu;
    }

    public void setRevenu(int revenu) {
        this.revenu = revenu;
    }

    
    
    public int getAge(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Parse the birthday String into a LocalDate
        LocalDate birthday = LocalDate.parse(dateNaissance, formatter);
        LocalDate currentDate = LocalDate.now();
        
        int age = currentDate.getYear() - birthday.getYear();
        
        if (currentDate.getMonthValue() < birthday.getMonthValue() ||
            (currentDate.getMonthValue() == birthday.getMonthValue() &&
             currentDate.getDayOfMonth() < birthday.getDayOfMonth())) {
            age--; // Subtract 1 if the birthday hasn't occurred yet this year
        }
        
        
        return age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.dateNaissance);
        hash = 67 * hash + Objects.hashCode(this.sexe);
        hash = 67 * hash + Objects.hashCode(this.revenu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Abonne other = (Abonne) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        return this.revenu == other.revenu;
    }

    @Override
    public String toString() {
        return "Abonne{" + "nom=" + nom + ", age=" + getAge() + ", sexe=" + sexe + ", revenu=" + revenu + '}';
    }
    
    
    
}
