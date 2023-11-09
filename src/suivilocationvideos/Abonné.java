/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_java;

import java.util.Objects;

/**
 *
 * @author jlema
 */
public class Abonné {
    private final String nom;
    private final String dateNaissance;
    private final String sexe;
    private Enum revenu;

    public Abonné(String aNom, String aDateNaissance, String aSexe) {
        this.nom = aNom;
        this.dateNaissance = aDateNaissance;
        this.sexe = aSexe;
    }

    public Enum getRevenu() {
        return revenu;
    }

    public void setRevenu(Enum aRevenu) {
        this.revenu = aRevenu;
    }

    public String getNom() {
        return nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Abonné other = (Abonné) obj;
        if (Objects.hashCode(this.revenu) != Objects.hashCode(other.revenu)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        return Objects.equals(this.sexe, other.sexe);
    }

    @Override
    public String toString() {
        return "Abonn\u00e9{" + "nom=" + nom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", revenu=" + revenu + '}';
    }
    
    
}
