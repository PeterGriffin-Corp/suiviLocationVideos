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
    private List<Location> locations;
    private Map<Abonne, List<Film>> filmsLoyeParAbonne;

    public Similarity() {
        this.abonnes = new ArrayList<>();
        this.filmsLoyeParAbonne = new HashMap<>();
    }

    public List<Abonne> getAbonnes() {
        return abonnes;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Map<Abonne, List<Film>> getFilmsLoyeParAbonne() {
        return filmsLoyeParAbonne;
    }

    
    
    
    public void addLocation(Location _Location){
        locations.add(_Location);
    }
    
    public void addFilmAFilmsLoyerParAbonne(Abonne _Abonne, Location _Location){
        List<Film> _filmExistantes = new ArrayList<>();
        _filmExistantes = filmsLoyeParAbonne.get(_Abonne);
        
        if(filmsLoyeParAbonne.get(_Abonne) == null)
        
        for(Film film:_Location.getFilms())
            if(_filmExistantes == null)
                _filmExistantes.add(film);
            else{if(!_filmExistantes.contains(film))
                _filmExistantes.add(film);
            }
        System.out.println(_filmExistantes);
        filmsLoyeParAbonne.put(_Abonne, _filmExistantes);
    }
    
    public Map<Film, List<Abonne>> getSubscribersByFilm(List<Film> films) {
        Map<Film, List<Abonne>> result = new HashMap<>();

        // Iterate through the filmsLoyeParAbonne map
        for (Map.Entry<Abonne, List<Film>> entry : filmsLoyeParAbonne.entrySet()) {
            Abonne abonne = entry.getKey();
            List<Film> subscribedFilms = entry.getValue();

            // Check if the subscribedFilms intersect with the given films
            List<Film> commonFilms = new ArrayList<>(subscribedFilms);
            commonFilms.retainAll(films);

            // Add the Abonne to the corresponding films in the result map
            for (Film film : commonFilms) {
                result.computeIfAbsent(film, k -> new ArrayList<>()).add(abonne);
            }
        }

        return result;
    }
    
    /*
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
    */
    /*
    public int getSimilarityCoffret(final Film _Film, final Coffret _Coffret){
        int _similarityMaxFilmCoffret = 
        return 0;
    }
    */
    /*
    public List<Film> getListFilmsSim(final List<Film> films, final Film _Film){
        
        return films.stream().sorted(
                Comparator.comparing((Film film) -> getSimilarityFilm(film, _Film))
        ).collect(Collectors.toList());
    }
    */
    /*
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
    */
    /*
    private int calculateMaxSimilarity(List<Film> films) {
        return films.stream()
                .mapToInt(film1 -> films.stream()
                        .filter(film2 -> !film1.equals(film2))
                        .mapToInt(film2 -> getSimilarityFilm(film1, film2))
                        .max()
                        .orElse(0))
                .max()
                .orElse(0);
    }*/
    /*
    // on doit tester
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
    */
    /*
    private Double calculateAvgSimilarity(List<Abonne> abonnes) {
    return abonnes.stream()
            .mapToDouble(abonne1 -> abonnes.stream()
                    .filter(abonne2 -> !abonne2.equals(abonne1))
                    .mapToDouble(abonne2 -> getSimilarityAbonne(abonne1, abonne2))
                    .average()
                    .orElse(0))
            .average()
            .orElse(0);
    }
*/
    
    /*private Map<Film, List<Abonne>> getListAbonneparFilm(List<Film> films){
        Map<Film, List<Abonne>> listAbonneParFilm = new HashMap<>();
        for (Map.Entry<Abonne, List<Location>> entry : locationFilm.entrySet()) {
            Abonne abonne = entry.getKey();
            List<Location> locations = entry.getValue();

        for (Location location : locations) {
            for (Map.Entry<String, Abonne> abonneEntry : location.getAbonnes().entrySet()) {
                Film film = abonneEntry.getValue().getFilm();
                listAbonneParFilm.computeIfAbsent(film, k -> new ArrayList<>()).add(abonne);
            }
        }
    }
        return listFilmParAbonne;
    }*/
    
    
    /*
    public Map<Film, List<Abonne>> getListAbonneparFilm(List<Film> films) {
        
        Map<Film, List<Abonne>> listAbonneParFilm = new HashMap<>();

        for (Film film : films) {
            listAbonneParFilm.put(film, new ArrayList<>());
        }
        
        for (List<Location> locations : locationFilm.values()) {
            for(Location location: locations){
                for(Film film : location.getFilms().values()){
                    if(listAbonneParFilm.get(film).isEmpty())
                        if(location.getFilms().get(film.getTitre()) != null)
                            listAbonneParFilm.get(film).add(location.getAbonne());
                    else{
                        if((location.getFilms().get(film.getTitre()) != null) && !listAbonneParFilm.get(film).contains(location.getAbonne()))
                            listAbonneParFilm.get(film).add(location.getAbonne());
                    }
                    //listAbonneParFilm.put(film, _Abonnes);
                }
            }
        }

        return listAbonneParFilm;
    }
*/
    /*
    public Map<Film, List<Abonne>> getListAbonneparFilm(List<Film> films){
        
        Map<Film, List<Abonne>> listAbonneParFilm = new HashMap<>();
        
        for (Film film : films) {
            listAbonneParFilm.put(film, new ArrayList<>());
            for(Abonne abonne: abonnes){
                for(Location location:locationFilm.get(abonne)){
                    System.out.println("1");
                    if(location.getFilms().contains(film)){
                        System.out.println(film.getTitre() + " " + abonne.getNom() + " " + "True");
                    }else{
                        System.out.println(film.getTitre() + " " + abonne.getNom() + " " + "False");
                    }
                }
            }
        }
        
        
        
        return listAbonneParFilm;
    }



    public List<Abonne> getListAbonnesSim(final List<Abonne> abonnes, final Abonne _Abonne){
        
        return abonnes.stream().sorted(
                Comparator.comparing((Abonne abonne) -> getSimilarityAbonne(abonne, _Abonne))
        ).collect(Collectors.toList());
    }
    */
}
