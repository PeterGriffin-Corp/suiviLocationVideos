/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Création de la classe Film
 * @author Achraf, Guangyi, Justin
 */
public class Film {
    private final String titre;
    private final String typeFilm;
    private final SousGenre sousGenre;
    private final List<Acteur> acteurs;

    public Film(String _Titre, String _TypeFilm, SousGenre _SousGenre) {
        this.titre = _Titre;
        this.typeFilm = _TypeFilm;
        this.sousGenre = _SousGenre;
        this.acteurs = new ArrayList<>();
    }

    public SousGenre getSousGenre() {
        return sousGenre;
    }

    public Film(String titre, String typeFilm, SousGenre sousGenre, List<Acteur> acteurs) {
        this.titre = titre;
        this.typeFilm = typeFilm;
        this.sousGenre = sousGenre;
        this.acteurs = acteurs;
    }
    
    public String getTitre() {
        return titre;
    }

    public String getTypeFilm() {
        return typeFilm;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }
    

    //Ajouter un nouvel acteur s'il n'existe pas dans la liste

    public void addActeur(final String aNom, final String aPrenom) {
    Acteur nouvelActeur = new Acteur(aNom, aPrenom);

    // Vérifier si l'acteur n'existe pas déjà dans la liste
    if (!acteurs.contains(nouvelActeur)) {
        acteurs.add(nouvelActeur);
        System.out.println("L'acteur a été ajouté avec succès.");
    } else {
        System.out.println("L'acteur existe déjà dans la liste.");
        }
    }

//Supprimer l'acteur

    public void removeActeur(final Acteur aActeur) {
        acteurs.remove(aActeur);
        System.out.println("L'acteur a été supprimé avec succès.");
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.titre);
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
        final Film other = (Film) obj;
        return Objects.equals(this.titre, other.titre);
    }

    @Override
    public String toString() {
        return "Film{" + "titre=" + titre + ", typeFilm=" + typeFilm + ", sousGenre=" + sousGenre + ", acteurs=" + acteurs + '}';
    }
   
  }

