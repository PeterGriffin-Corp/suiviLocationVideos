/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;


/**
 *
 * @author guangyi Huang
 */
public class NoyauFonctionnel {
 
    private final Map<String, Abonne> abonnes;
    private final Map<String, Film> films;
    private final Map<Abonne, List<Location>> pret;

    public NoyauFonctionnel() {
        this.abonnes = new HashMap<>();
        this.films = new HashMap<>();
        this.pret = new HashMap<>();
    }
    
    
    public void addAbonne(String _Nom, String _DateNaissance, String _Sexe, int trancheRevenu){
        final Abonne abonned = new Abonne(_Nom, _DateNaissance, _Sexe, trancheRevenu);
        if (!abonnes.containsKey(_Nom)) {
            abonnes.put(_Nom, abonned);
            System.out.println("L'abonne a bien été ajouté!");
        }else{
            System.out.println("L'abonne existe déja!");
        }
    }
    

    public Abonne findAbonne(String _Nom) {
        if(abonnes.containsKey(_Nom))
            return abonnes.get(_Nom);
        else{
            System.out.printf("L'abonne avec le nom %s n'existe pas", _Nom);
            return null;
        }
    }

    public void addFilm(String _Titre, String _TypeFilm, SousGenre _SousGenre, List<Acteur> _Acteurs) {
        Film nouveauFilm = new Film(_Titre, _TypeFilm, _SousGenre, _Acteurs);
        if (!films.containsKey(_Titre)) {
            films.put(_Titre, nouveauFilm);
            System.out.println("Le film a été ajouté!");
        }else{
            System.out.println("Le film existe déja!");
        }
    }

    public Film findMovie(String _Titre) {
        if(films.containsKey(_Titre))
            return films.get(_Titre);
        else{
            System.out.printf("Le Film avec le titre %s n'existe pas", _Titre);
            return null;
        }
    } 
    
    private static String generateID(String _NomAbonne, String _TitreFilm){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String currentDate = LocalDate.now().format(formatter);
        
        String uniqueID = _NomAbonne + "_" + currentDate + "_" + _TitreFilm;
        
        return uniqueID;
    }
    
    public void enregistrerPretFilm(String _NomAbonne, String _TitreFilm){
        if(abonnes.containsKey(_NomAbonne)){
            if(!films.containsKey(_TitreFilm)){
                Abonne _Abonne = findAbonne(_NomAbonne);
                Film _Film = findMovie(_TitreFilm);
                String id = generateID(_NomAbonne, _TitreFilm);
                Location loc = new Location(id, _Abonne, _Film);
                System.out.printf("Le pret du film %s par %s a été loué sous l'id: %s", _TitreFilm, _NomAbonne, id);
            }else
                System.out.println("Nous pouvons pas enregistrer le pret du Film parce que le film n'est pas enregistré");
        }else
            System.out.println("Nous pouvons pas enregistrer le pret du Film parce que l'abonne n'est pas enregistré");
    }
    
    public void enregistrerPretFilm(String _NomAbonne, List<String> listFilmsLoyes){
        for(String film: listFilmsLoyes)
            enregistrerPretFilm(_NomAbonne, film);
    }
    
    public void afficherListeFilms(String nomAbonne) {
        Abonne _Abonne = findAbonne(nomAbonne);
        System.out.println(_Abonne.getHistoryFilm());
    }

    public List<Abonne> abonnesFourchetteRevenu(int _FourchetteRevenu) {
        return abonnes.entrySet().stream()
                                    .filter(entry -> entry.getValue().getFourchetteRevenu() == _FourchetteRevenu)
                                    .map(Map.Entry::getValue)
                                    .collect(Collectors.toList());
    }
    
    public Genre genrePlusPopulaire() {
        Map<Genre, Integer> genresCount = new HashMap<>();

        for (List<Film> films : pret.values()) {
            for (Film film : films) {
                Genre genre = film.getSousGenre().getGenre();
                genresCount.put(genre, genresCount.getOrDefault(genre, 0) + 1);
            }
        }
    
        Genre genrePlusPopulaire = null;
        int maxCount = 0;

        for (Map.Entry<Genre, Integer> entry : genresCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                genrePlusPopulaire = entry.getKey();
            }
        }

        return genrePlusPopulaire;
    }
    
    public Genre genrePlusPopulaires(){
        
        
        
        return null;
    }

}