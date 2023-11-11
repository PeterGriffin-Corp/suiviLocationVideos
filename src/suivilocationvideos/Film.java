/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jlema
 */
public class Film {
    private final String titre;
    private final String typeFilm;
    private final List<Acteur> acteurs;

    public Film(String aTitre, String aTypeFilm){
        this.titre = aTitre;
        this.typeFilm = aTypeFilm;
        acteurs = new ArrayList<>();
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

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Objects.hashCode(this.typeFilm);
        return hash;
    }

    public void addActeur(final String aNom, final String aPrenom) {
        acteurs.add(new Acteur(aNom, aPrenom));
    }

    public void removeActeur(final Acteur aActeur) {
        acteurs.remove(aActeur);
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
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return Objects.equals(this.typeFilm, other.typeFilm);
    }

    @Override
    public String toString() {
        return "Film{" + "titre=" + titre + ", typeFilm=" + typeFilm + ", acteurs=" + acteurs + '}';
    }


  }

    
