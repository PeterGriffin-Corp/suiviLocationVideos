/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Guangyi HUANG
 */
public class Coffret {
    private final String titre;
    private final List<Acteur> listActeur;
    private final List<Film> listFilm;
    private final boolean bonus;

    public Coffret(String aTitre, List<Acteur> aListActeur, List<Film> aListFilm, boolean aBonus) {
        this.titre = aTitre;
        this.listActeur = aListActeur;
        this.listFilm = aListFilm;
        this.bonus = aBonus;
    }
    
    
    public void addFilm(Film film) {
    // Vérifier si le film n'existe pas déjà dans la liste
    if (!listFilm.contains(film)) {
        listFilm.add(film);
        }
    }

    public String getTitre() {
        return titre;
    }
    public Genre getGenreMajoritaire() {
        Map<Genre, Integer> genreCount = new HashMap<>();

        // Compter le nombre d'occurrences de chaque genre
        for (Film film : listFilm) {
            Enum genre = film.getSousGenre().getGenre();
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }

        // Trouver le genre avec le nombre d'occurrences le plus élevé
        Genre genreMajoritaire = null;
        int countMajoritaire = 0;

        for (Map.Entry<Genre, Integer> entry : genreCount.entrySet()) {
            Genre genre = entry.getKey();
            int count = entry.getValue();

            if (count > countMajoritaire) {
                countMajoritaire = count;
                genreMajoritaire = genre;
            }
        }

        return genreMajoritaire;
    }


    public List<Acteur> getListeActeurs() {
        List<Acteur> listActeurs = new ArrayList<>();

        // Parcourir chaque film pour récupérer la liste d'acteurs
        for (Film film : listFilm) {
            listActeurs.addAll(film.getActeurs());
        }

        return listActeurs;
    }
    
    public List<Acteur> getListeActeursDistincts() {
    Set<Acteur> acteursDistincts = new HashSet<>(getListeActeurs());
    return new ArrayList<>(acteursDistincts);
    }
    
    public boolean isBonus() {
        return bonus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.titre);
        hash = 23 * hash + Objects.hashCode(this.listActeur);
        hash = 23 * hash + Objects.hashCode(this.listFilm);
        hash = 23 * hash + (this.bonus ? 1 : 0);
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
        final Coffret other = (Coffret) obj;
        if (this.bonus != other.bonus) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.listActeur, other.listActeur)) {
            return false;
        }
        return Objects.equals(this.listFilm, other.listFilm);
    }

    @Override
    public String toString() {
        return "Coffret{" + "titre=" + titre + ", listActeur=" + listActeur + ", listFilm=" + listFilm + ", bonus=" + bonus + '}';
    }
   
   
}
  
