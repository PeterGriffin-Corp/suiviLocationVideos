/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;


/**
 * Création du noyauFonctionnel
 * @author Achraf, Guangyi, Justin
 */
public class NoyauFonctionnel {
 
    private final Map<String, Abonne> abonnes;
    private final Map<String, Film> films;
    private final Map<String, Coffret> coffrets;
    private final Map<Abonne, List<Location>> pret;
//Constructeur
    public NoyauFonctionnel() {
        this.abonnes = new HashMap<>();
        this.films = new HashMap<>();
        this.pret = new HashMap<>();
        this.coffrets = new HashMap<>();
    }

    public Map<String, Abonne> getAbonnes() {
        return abonnes;
    }

    public Map<String, Film> getFilms() {
        return films;
    }

    public Map<Abonne, List<Location>> getPret() {
        return pret;
    }

    public Map<String, Coffret> getCoffrets() {
        return coffrets;
    }
    
    
    
 // Ajout d'un nouvel abonné   
    public void addAbonne(String _Nom, String _DateNaissance, String _Sexe, int trancheRevenu){
        final Abonne abonned = new Abonne(_Nom, _DateNaissance, _Sexe, trancheRevenu);
        if (!abonnes.containsKey(_Nom)) {
            abonnes.put(_Nom, abonned);
            System.out.println("L'abonne a bien été ajouté!");
        }else{
            System.out.println("L'abonne existe déja!");
        }
    }
    
//Regarder si l'abonné existe
    public Optional<Abonne> findAbonne(String _Nom) {
        if (abonnes.containsKey(_Nom)) {
            return Optional.of(abonnes.get(_Nom));
        } else {
            System.out.printf("L'abonné avec le nom %s n'existe pas\n", _Nom);
            return Optional.empty();
        }
    }
    
    
//Ajout d'un nouveau film
    public void addFilm(String _Titre, String _TypeFilm, SousGenre _SousGenre, List<Acteur> _Acteurs) {
        Film nouveauFilm = new Film(_Titre, _TypeFilm, _SousGenre, _Acteurs);
        if (!films.containsKey(_Titre)) {
            films.put(_Titre, nouveauFilm);
            System.out.println("Le film a été ajouté!");
        }else{
            System.out.println("Le film existe déja!");
        }
    }
//Regarder si le film
    public Optional<Film> findMovie(String _Titre) {
        if (films.containsKey(_Titre)) {
            return Optional.of(films.get(_Titre));
        } else {
            System.out.printf("Le Film avec le titre %s n'existe pas\n", _Titre);
            return Optional.empty();
        }
    } 
// Génère une ID unique lors d'une location    
    private static String generateID(String _NomAbonne, String _TitreFilm){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String currentDate = LocalDate.now().format(formatter);
        
        String uniqueID = _NomAbonne + "_" + currentDate + "_" + _TitreFilm;
        
        return uniqueID;
    } 
 /**
 * Enregistre une nouvelle location   
 * @author Achraf, Guangyi, Justin
 */   
    public void enregistrerPretFilm(String _NomAbonne, String _TitreFilm) {
        Optional<Abonne> abonneOptional = findAbonne(_NomAbonne);
        Optional<Film> filmOptional = findMovie(_TitreFilm);

//Si l'abonné et le film existent, génère une ID et une nouvelle location. Dans le cas contraire, indique que l'un des deux n'est pas renseigné.
        if (abonneOptional.isPresent()) {
            Abonne _Abonne = abonneOptional.get();

            if (filmOptional.isPresent()) {
                Film _Film = filmOptional.get();
                String id = generateID(_NomAbonne, _TitreFilm);
                Location loc = new Location(id, _Abonne, _Film);
                List<Location> locationList = new ArrayList<>();
                if(pret.get(_Abonne) != null)
                    locationList = pret.get(_Abonne);
                locationList.add(loc);
                pret.put(_Abonne, locationList);
                System.out.printf("Le prêt du film %s par %s a été loué sous l'id: %s\n", _TitreFilm, _NomAbonne, id);
            } else {
                System.out.println("Nous ne pouvons pas enregistrer le prêt du film car le film n'est pas enregistré\n");
            }
        } else {
            System.out.println("Nous ne pouvons pas enregistrer le prêt du film car l'abonné n'est pas enregistré\n");
        }
    }

    
    public void enregistrerPretFilm(String _NomAbonne, List<String> listFilmsLoyes){
        for(String film: listFilmsLoyes)
            enregistrerPretFilm(_NomAbonne, film);
    }
 /**
 * Affiche la liste des films qu'un abonné a loué
 * @author Achraf, Guangyi, Justin
 */   
    public void afficherListeFilms(String nomAbonne) {
        Optional<Abonne> abonneOptional = findAbonne(nomAbonne);

        if (abonneOptional.isPresent()) {
            Abonne _Abonne = abonneOptional.get();
            System.out.println(_Abonne.getHistoryFilm());
        } else {
            System.out.printf("L'abonné avec le nom %s n'existe pas\n", nomAbonne);
        }
    }
 
/**
 * Retourne une liste d'abonnée appartenant à une fourchette de revenu donnée
 * @author Achraf, Guangyi, Justin
 */
    public List<Abonne> abonnesFourchetteRevenu(int _FourchetteRevenu) {
        return abonnes.entrySet().stream()
                                    .filter(entry -> entry.getValue().getFourchetteRevenu() == _FourchetteRevenu)
                                    .map(Map.Entry::getValue)
                                    .collect(Collectors.toList());
    }
        
/**
 * Retour le genre le plus populaire parmis les locations 
 * @author Achraf, Guangyi, Justin
 */
    public Optional<Genre> genrePlusPopulaires() {
        Map<Genre, Long> nbLocationParGenre = pret.values().stream()
                .flatMap(locations -> locations.stream())
                .map(location -> location.getFilm().getSousGenre().GetGenre())
                .collect(Collectors.groupingBy(
                        genre -> genre,
                        Collectors.counting()
                ));

        return nbLocationParGenre.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

 /**
 * Retourne la similarité entre 2 abonnés en fonction de leur différence d'age, de sexe et de fourchette de revenu
 * @author Achraf, Guangyi, Justin
 */
    private int getSimilarityAbonne(final Abonne abonne1, final Abonne abonne2){
        int similarityAge = Math.abs(abonne1.getAge() - abonne2.getAge())/10;
        int similaritySexe = (abonne1.getSexe().equals(abonne2.getSexe()) ? 1 : 0);
        int similarityTranche = Math.abs(abonne1.getFourchetteRevenu()- abonne2.getFourchetteRevenu());
        return similarityAge + similaritySexe + similarityTranche;
    }
 /**
 * Retourne la similarité entre 2 sous genres, 0 s'ils sont identiques, 
 * 1 s'ils sont différents mais du même genre, et 2 si les genres sont différents 
 * @author Achraf, Guangyi, Justin
 */
    private int similarityGenre(final SousGenre sousGenre1, final SousGenre sousGenre2){
        int similarity = 0;
        if((sousGenre1.GetGenre().equals(sousGenre2.GetGenre())) && !(sousGenre1.equals(sousGenre2))){
            similarity += 1;
        }else{
            if(!sousGenre1.GetGenre().equals(sousGenre2.GetGenre()))
                similarity += 2;
        }
        return similarity;
    }
 /**
 * Retourne la similarité entre 2 films en calculant la similarité entre les gens, le type (couleur) et les acteurs
 * @author Achraf, Guangyi, Justin
 */    
    private int getSimilarityFilm(final Film film1, final Film film2){
        int _similarityGenre = similarityGenre(film1.getSousGenre(), film2.getSousGenre());
        int similarityTypeFilm = (film1.getTypeFilm().toUpperCase().equals(film2.getTypeFilm().toUpperCase())? 0 : 1); //Si c'est la même couleur 0 sinon 1
        List<Acteur> acteurs = film1.getActeurs().stream()
                .distinct()
                .filter(film2.getActeurs()::contains)
                .collect(Collectors.toList());
        int similarityActeur = film1.getActeurs().size() + film2.getActeurs().size() - acteurs.size();
        return _similarityGenre + similarityTypeFilm + similarityActeur;
    }
 
 /**
 * Retourne une liste de films les plus similaires à un film donné sous la forme d'un tri du plus au moins similaire
 * @author Achraf, Guangyi, Justin
 */        
    public List<Film> getListFilmsSim(final String _NomFilm) {
        Optional<Film> filmOptional = findMovie(_NomFilm);

        if (filmOptional.isPresent()) {
            Film _Film = filmOptional.get();

            List<Film> sortedFilms = films.entrySet().stream()
                    .filter(film1 -> !film1.getValue().equals(_Film))
                    .sorted(Comparator.comparing(entry -> getSimilarityFilm(entry.getValue(), _Film)))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            return sortedFilms;
        } else {
            return Collections.emptyList();
        }
    }

 /**
 * 
 * @author Achraf, Guangyi, Justin
 */    
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
    
 /**
 * Retourne la liste d'abonnée qui a loué des films se ressemblant très peu 
 * @author Achraf, Guangyi, Justin
 */    
    public List<Abonne> getListAbonneCurieux(){
        
        Map<Abonne, Integer> abonnesSimilarityMaxScore = new HashMap<>();
        
        for (Map.Entry<String, Abonne> entry : abonnes.entrySet()) {
            Abonne _Abonne = entry.getValue();
            List<Film> _Films = entry.getValue().getHistoryFilm();

            int maxSimilarity = calculateMaxSimilarity(_Films);

            // Put the result in the map
            abonnesSimilarityMaxScore.put(_Abonne, maxSimilarity);
        }
        
        return abonnesSimilarityMaxScore.entrySet()
            .stream()
            .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    public List<Abonne> getListAbonnesSim(final String _NomAbonne) {
        Optional<Abonne> abonneOptional = findAbonne(_NomAbonne);

        if (abonneOptional.isPresent()) {
            Abonne _Abonne = abonneOptional.get();

            return abonnes.entrySet().stream()
                    .sorted(Comparator.comparingInt((Map.Entry<String, Abonne> entry) -> getSimilarityAbonne(entry.getValue(), _Abonne)).reversed())
                    .map(Map.Entry::getValue)
                    .filter(e -> !e.getNom().equals(_NomAbonne))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }    
    
    
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
    
    private Map<Film, List<Abonne>> getListAbonnesByFilm(List<Film> _Films){
        
        List<Abonne> _Abonnes = new ArrayList<>(abonnes.values());

        
        Map<Film, List<Abonne>> abonnesByFilm = new HashMap<>();
        
        for(Film film: _Films){
            List<Abonne> _AbonneParFilm = new ArrayList<>();
            for(Abonne abonne : _Abonnes){
                if(abonne.getHistoryFilm().contains(film)){
                    _AbonneParFilm.add(abonne);
                    abonnesByFilm.put(film, _AbonneParFilm);
                }
            }
        }
        
        return abonnesByFilm;
    }
    
    public List<Film> listFilmsType(double threshold){
        
        Map<Film, List<Abonne>> _GetListAbonnesByFilm = getListAbonnesByFilm(new ArrayList<>(films.values()));
        
        List<Film> filmsTypes = new ArrayList<>();
        
        for(Film film : _GetListAbonnesByFilm.keySet()){
            
            double avgSimAbonnes = calculateAvgSimilarity(_GetListAbonnesByFilm.get(film));
            if(avgSimAbonnes < threshold)
                filmsTypes.add(film);
        }
        
        return filmsTypes;
    }
    
    public void creatCoffret(String titre, List<Acteur> listActeur, List<Film> listFilm, boolean bonus) {
        Coffret nouveauCoffret = new Coffret(titre, listActeur, listFilm, bonus);
        if (!coffrets.containsKey(titre)) {
            coffrets.put(titre, nouveauCoffret);
            System.out.println("Le coffret a été ajouté!");
        }else{
            System.out.println("Le coffret existe déja!");
        }
    }
    
    public int getSimilarityCoffretAndFilm(Coffret _Coffret, Film _Film){
        
        List<Film> filmsCoffret = _Coffret.getListFilm();
        
        int simFilms = filmsCoffret.stream()
                    .filter(film1 -> !_Film.equals(film1))
                    .mapToInt(film1 -> getSimilarityFilm(film1, _Film))
                    .max()
                    .orElse(0);
        
        int isBonus = (_Coffret.isBonus())? 1:0;
        
        return simFilms + filmsCoffret.size() + isBonus;
    }
    
    public Optional<Coffret> findCoffret(String _Titre) {
        if (coffrets.containsKey(_Titre)) {
            return Optional.of(coffrets.get(_Titre));
        } else {
            System.out.printf("Le Coffret avec le titre %s n'existe pas\n", _Titre);
            return Optional.empty();
        }
    }
    
    public void enregistrerPretCoffret(String _NomAbonne, String _CoffretTitle) {
        Optional<Abonne> abonneOptional = findAbonne(_NomAbonne);
        Optional<Coffret> coffretOptional = findCoffret(_CoffretTitle);

        if (abonneOptional.isPresent()) {
            Abonne _Abonne = abonneOptional.get();

            if (coffretOptional.isPresent()) {
                Coffret _Coffret = coffretOptional.get();
                String id = generateID(_NomAbonne, _CoffretTitle);
                Location loc = new Location(id, _Abonne, _Coffret);
                List<Location> locationList = new ArrayList<>();
                if(pret.get(_Abonne) != null)
                    locationList = pret.get(_Abonne);
                locationList.add(loc);
                pret.put(_Abonne, locationList);
                System.out.printf("Le prêt du coffref %s par %s a été loué sous l'id: %s\n", _CoffretTitle, _NomAbonne, id);
            } else {
                System.out.println("Nous ne pouvons pas enregistrer le prêt du coffret car le coffret n'est pas enregistré\n");
            }
        } else {
            System.out.println("Nous ne pouvons pas enregistrer le prêt du coffret car l'abonné n'est pas enregistré\n");
        }
    }
    
}
