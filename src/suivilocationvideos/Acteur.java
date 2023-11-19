/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.Objects;

/**

=======
 * Création de la classe abonnée
 * @author Achraf, Guangyi, Justin
 */
public class Acteur {
    private final String nom;
    private final String Prenom;


    //Constructeur

    public Acteur(String aNom, String aPrenom) {
        this.nom = aNom;
        this.Prenom = aPrenom;
    }


//Getter&Setter

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return Prenom;
    }



//Hashcode&Equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nom);
        hash = 31 * hash + Objects.hashCode(this.Prenom);
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
        final Acteur other = (Acteur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.Prenom, other.Prenom);
    }

    @Override
    public String toString() {
        return "Acteur{" + "nom=" + nom + ", Prenom=" + Prenom + '}';
    }
    
}
