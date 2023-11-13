/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Achraf
 */
public class Similarity {
    
    private List<Abonne> abonnes;

    public Similarity() {
    }
    
    
    public int getSimilarityAbonne(final Abonne abonne1, final Abonne abonne2){
        int similarityAge = Math.abs(abonne1.getAge() - abonne2.getAge())/10;
        int similaritySexe = (abonne1.getSexe().equals(abonne2.getSexe()) ? 1 : 0);
        int similarityTranche = Math.abs(abonne1.getRevenu() - abonne2.getRevenu());
        return similarityAge + similaritySexe + similarityTranche;
    }
    
    
    private int similarityGenre(final SousGenre sousGenre1, final SousGenre sousGenre2){
        int similarity = 0;
        if((sousGenre1.getGenre().equals(sousGenre2.getGenre())) && !(sousGenre1.getNomSousGenre().toUpperCase().equals(sousGenre2.getNomSousGenre().toUpperCase()))){
            similarity += 1;
        }else{
            if(!sousGenre1.getGenre().equals(sousGenre2.getGenre()))
                similarity += 2;
        }
        return similarity;
    }
    
    public int getSimilarityFilm(final Film film1, final Film film2){
        int _similarityGenre = similarityGenre(film1.getSousGenre(), film2.getSousGenre());
        int similarityTypeFilm = (film1.getTypeFilm().toUpperCase().equals(film2.getTypeFilm().toUpperCase())? 0 : 1);
        List<Acteur> acteurs = film1.getActeurs().stream()
                .distinct()
                .filter(film2.getActeurs()::contains)
                .collect(Collectors.toList());
        int similarityActeur = film1.getActeurs().size() + film2.getActeurs().size() - acteurs.size();
        return _similarityGenre + similarityTypeFilm + similarityActeur;
    }
    
    /*
    public int getSimilarityCoffret(final Film _Film, final Coffret _Coffret){
        int _similarityMaxFilmCoffret = 
        return 0;
    }
    */
    
    public List<Film> getListFilmsSim(final List<Film> films, final Film _Film){
        
        films.stream().distinct().
        
        return null;
    }
    
}
