/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Création de la classe abonnée
 * @author Achraf, Guangyi, Justin
 */
public class Abonne {
    
    private String nom;
    private String dateNaissance;
    private String sexe;
    private int fourchetteRevenu;
    private List<Film> historyFilm; //Liste des films que l'abonné a loué
    private List<Coffret> historyCoffret; //Liste des coffret que l'abonné a loué
    
//Constructeur
    public Abonne(String nom, String dateNaissance, String sexe, int revenu) {
        if(revenu <= 5 && revenu >0){
            this.nom = nom;
            this.dateNaissance = dateNaissance;
            this.sexe = sexe;
            this.fourchetteRevenu = revenu;
            if(this.historyFilm == null)
                this.historyFilm = new ArrayList<>();
            if(this.historyCoffret == null)
                this.historyCoffret = new ArrayList<>();
        }else{
            System.err.println("Tranche Revenu doit être égale à une valeur entre 1 et 5");
        }
    }
//Getter&Setter
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

    public int getFourchetteRevenu() {
        return fourchetteRevenu;
    }

    public void setFourchetteRevenu(int fourchetteRevenu) {
        this.fourchetteRevenu = fourchetteRevenu;
    }

    public List<Film> getHistoryFilm() {
        return historyFilm;
    }

    public void setHistoryFilm(Film _Films) {
        if(!this.historyFilm.contains(_Films))
            this.historyFilm.add(_Films);
    }

    public List<Coffret> getHistoryCoffret() {
        return historyCoffret;
    }

    public void setHistoryCoffret(Coffret _aHistoryCoffret) {
        if (!this.historyCoffret.contains(_aHistoryCoffret))
            this.historyCoffret.add (_aHistoryCoffret);
    }
//Calcul de l'âge à partir de la date de naissance
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
//Hashcode & equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.dateNaissance);
        hash = 29 * hash + Objects.hashCode(this.sexe);
        hash = 29 * hash + this.fourchetteRevenu;
        hash = 29 * hash + Objects.hashCode(this.historyFilm);
        hash = 29 * hash + Objects.hashCode(this.historyCoffret);
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
        if (this.fourchetteRevenu != other.fourchetteRevenu) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.historyFilm, other.historyFilm)) {
            return false;
        }
        return Objects.equals(this.historyCoffret, other.historyCoffret);
    }

    @Override
    public String toString() {
        return "Abonne{" + "nom=" + nom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", fourchetteRevenu=" + fourchetteRevenu + ", historyFilm=" + historyFilm + ", historyCoffret=" + historyCoffret + '}';
    }
    
    
}
