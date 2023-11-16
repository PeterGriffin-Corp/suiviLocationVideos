/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suivilocationvideos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Achraf
 */
public class SuiviLocationVideos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Abonne abonne1 = new Abonne("Guangyi","11/07/1996" , "M", 2);
        Abonne abonne2 = new Abonne("Achraf","01/01/1999" , "M", 2);
        Abonne abonne3 = new Abonne("Femme","01/01/1999" , "F", 3);
       
//        System.out.println(abonne1);
        
        Similarity sim = new Similarity();
       
        
        Acteur acteur1 = new Acteur("A", "B");
        Acteur acteur2 = new Acteur("C", "D");
        Acteur acteur3 = new Acteur("E", "F");
        Acteur acteur4 = new Acteur("G", "H");
        
        List<Acteur> listActeurs1 = new ArrayList<>();
        listActeurs1.add(acteur1);
        listActeurs1.add(acteur3);
        
        List<Acteur> listActeurs2 = new ArrayList<>();
        listActeurs2.add(acteur1);
        listActeurs2.add(acteur2);
        listActeurs2.add(acteur3);
        
        List<Acteur> listActeurs3 = new ArrayList<>();
        listActeurs3.add(acteur4);
        
        Film film1 = new Film("Film1", "Couleur", SousGenre.adventure, listActeurs1);
        Film film2 = new Film("Film2", "Couleur", SousGenre.music, listActeurs2);
        Film film3 = new Film("Film3", "Couleur", SousGenre.western, listActeurs3); 
        
        Film film4 = new Film("Film4", "Couleur", SousGenre.western, listActeurs1);
        Film film5 = new Film("Film5", "Couleur", SousGenre.romance, listActeurs2);
        Film film6 = new Film("Film6", "Couleur", SousGenre.romance, listActeurs3); 
        
        List<Film> films_1 = new ArrayList<>();
        films_1.add(film1);
        films_1.add(film2);
        
        List<Film> films_2 = new ArrayList<>();
        films_2.add(film3);

        List<Film> films_3 = new ArrayList<>();
        films_3.add(film1);
        films_3.add(film2);
        
        List<Film> films_4 = new ArrayList<>();
        films_4.add(film4);
        films_4.add(film5);
        
//        System.out.println(sim.getSimilarityFilm(film3, film1));
//        System.out.println(sim.getSimilarityFilm(film2, film1));
//        
//        System.out.println(sim.getListFilmsSim(films, film1));

        
        
        Location loc1 = new Location("1", abonne1, films_1);
        Location loc2 = new Location("2", abonne1, films_2);
        
        Location loc3 = new Location("3", abonne2, films_3);
        Location loc4 = new Location("4", abonne3, films_4);
        
        
        List<Abonne> abonnes = new ArrayList<>();
        abonnes.add(abonne1);
        abonnes.add(abonne2);
        abonnes.add(abonne3);
        
        
        
        //sim.addFilmAFilmsLoyerParAbonne(abonne1, loc1);
        
        //System.out.println(sim.getFilmsLoyeParAbonne());
        //System.out.println(loc1);
        
        //System.out.println(abonne1.getHistoryFilm());
        Location loc5 = new Location("5", abonne1, films_4);
        //System.out.println(abonne1.getHistoryFilm());
        
        NoyauFonctionnel nf = new NoyauFonctionnel();
        
        nf.addAbonne("GUY", "16/07/1996", "M", 1);
        
        nf.findAbonne("Achraf");
        
    }
    
}
