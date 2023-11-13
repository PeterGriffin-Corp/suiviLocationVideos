/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suivilocationvideos;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Achraf
 */
public class SuiviLocationVideos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Abonne abonne = new Abonne("Guangyi","11/07/1996" , "M", 2);
       
        System.out.println(abonne);
        
        Similarity sim = new Similarity();
        
        SousGenre sousGenre1 = new SousGenre("musique", Genre.COMEDIE);
        SousGenre sousGenre2 = new SousGenre("Romance", Genre.COMEDIE);
        
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
        
        Film film1 = new Film("Film1", "Couleur", sousGenre1, listActeurs1);
        Film film2 = new Film("Film2", "Couleur", sousGenre2, listActeurs2);
        Film film3 = new Film("Film3", "Couleur", sousGenre1, listActeurs3);        
        
        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);
        films.add(film3);


        
        System.out.println(sim.getSimilarityFilm(film3, film1));
        System.out.println(sim.getSimilarityFilm(film2, film1));
        
        System.out.println(sim.getListFilmsSim(films, film1));
        
    }
    
}
