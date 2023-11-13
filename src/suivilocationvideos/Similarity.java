/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Achraf
 */
public class Similarity {
    
    private List<Abonne> abonnes;
    private Map<Abonne, List<Location>> locationFilm;

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
        
        return films.stream().sorted(
                Comparator.comparing((Film film) -> getSimilarityFilm(film, _Film))
        ).collect(Collectors.toList());
    }
    
    private Map<Abonne, List<Film>> getListFilmLoyeparAbonne(List<Abonne> abonnes){
        Map<Abonne, List<Film>> listFilmParAbonne = new HashMap<>();
        for (Abonne abonne : abonnes) {
            List<Film> films = locationFilm.get(abonne).stream()
                    .flatMap(location -> location.getFilms().values().stream())
                    .collect(Collectors.toList());
            listFilmParAbonne.put(abonne, films);
        }
        return listFilmParAbonne;
    }
    
    private int calculateMaxSimilarity(List<Film> films) {
        return films.stream()
                .mapToInt(film1 -> films.stream()
                        .filter(film2 -> !film1.equals(film2))
                        .mapToInt(film2 -> getSimilarityFilm(film1, film2))
                        .max()
                        .orElse(0))
                .max()
                .orElse(0);
    }
    
    public List<Abonne> getListAbonneCurieux(List<Abonne> abonnes){
        
        Map<Abonne, List<Film>> listFilmParAbonne = getListFilmLoyeparAbonne(abonnes);
        Map<Abonne, Integer> abonnesSimilarityMaxScore = new HashMap<>();
        
        for (Map.Entry<Abonne, List<Film>> entry : listFilmParAbonne.entrySet()) {
            Abonne abonne = entry.getKey();
            List<Film> films = entry.getValue();

            int maxSimilarity = calculateMaxSimilarity(films);

            // Put the result in the map
            abonnesSimilarityMaxScore.put(abonne, maxSimilarity);
        }
        
        return abonnesSimilarityMaxScore.entrySet()
            .stream()
            .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
    }
    
}
