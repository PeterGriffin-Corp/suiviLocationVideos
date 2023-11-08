/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Achraf
 */
public class Abonne {
    
    private String nom;
    private LocalDate dateNaissance;
    private String sexe;
    private Tranche revenu;
    
    private Map<String, Abonne> abonnes;

    public Abonne(String nom, LocalDate dateNaissance, String sexe, Tranche revenu) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.revenu = revenu;
        this.abonnes = new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Tranche getRevenu() {
        return revenu;
    }

    public void setRevenu(Tranche revenu) {
        this.revenu = revenu;
    }
    
    public int getAge(){
        LocalDate date = LocalDate.now();
        return Period.between(this.dateNaissance, date).getYears();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nom);
        hash = 61 * hash + Objects.hashCode(this.dateNaissance);
        hash = 61 * hash + Objects.hashCode(this.sexe);
        hash = 61 * hash + Objects.hashCode(this.revenu);
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
    
    
    
    public void addAbonne(String _Nom, LocalDate _DateNaissance, String _Sexe, Tranche _Revenu){
        abonnes.put(_Nom, new Abonne(_Nom, _DateNaissance, _Sexe, _Revenu));
    }
    
    public Abonne findAbonne(String _Nom){
        Abonne _Abonne = abonnes.get(_Nom);
        return _Abonne;
    }
    
}
