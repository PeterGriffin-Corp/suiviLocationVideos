
package suivilocationvideos;


import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Achraf, Guangyi, Justin
 */
public class SuiviLocationVideos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Abonne abonne1 = new Abonne("Guangyi","11/07/1996" , "M", 2);
        Abonne abonne2 = new Abonne("Achraf","01/01/1999" , "M", 2);
        Abonne abonne3 = new Abonne("Femme","01/01/1999" , "F", 3);
       
//        System.out.println(abonne1);
        

       
        
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
        
        
//        System.out.println(sim.getSimilarityFilm(film3, film1));
//        System.out.println(sim.getSimilarityFilm(film2, film1));
//        
//        System.out.println(sim.getListFilmsSim(films, film1));

        

        
        
        
        //sim.addFilmAFilmsLoyerParAbonne(abonne1, loc1);
        
        //System.out.println(sim.getFilmsLoyeParAbonne());
        //System.out.println(loc1);
        
        //System.out.println(abonne1.getHistoryFilm());
        //Location loc5 = new Location("5", abonne1, films_lot4);
        //System.out.println(abonne1.getHistoryFilm());
        
        NoyauFonctionnel nf = new NoyauFonctionnel();
        
        nf.addAbonne("Guy", "11/07/1996", "M", 1);
        nf.addAbonne("Ash", "27/06/1999", "M", 1);
        nf.addAbonne("Jasmine", "01/01/1992", "F", 5);
        
        nf.addFilm("Film1", "Couleur", SousGenre.adventure, listActeurs1);
        nf.addFilm("Film2", "Couleur", SousGenre.music, listActeurs2);
        nf.addFilm("Film3", "Couleur", SousGenre.western, listActeurs3);
        nf.addFilm("Film4", "Couleur", SousGenre.western, listActeurs1);
        nf.addFilm("Film5", "Couleur", SousGenre.romance, listActeurs2);
        nf.addFilm("Film6", "Couleur", SousGenre.romance, listActeurs3); 
        
        List<String> films_lot1 = new ArrayList<>();
        films_lot1.add("Film1");
        films_lot1.add("Film2");
        
        List<String> films_lot2 = new ArrayList<>();
        films_lot2.add("Film3");
        films_lot2.add("Film2");
        
        List<String> films_lot3 = new ArrayList<>();
        films_lot3.add("Film4");
        films_lot3.add("Film5");
        
        List<String> films_lot4 = new ArrayList<>();
        films_lot4.add("Film6");
        films_lot4.add("Film2");
        
        
        nf.enregistrerPretFilm("Guy", films_lot1);
        nf.enregistrerPretFilm("Guy", films_lot2);
        nf.enregistrerPretFilm("Ash", films_lot2);
        nf.enregistrerPretFilm("Jasmine", films_lot4);
        
        
        List<Film> _Films = new ArrayList<>();
        _Films.add(new Film("Film1", "Couleur", SousGenre.adventure, listActeurs1));
        _Films.add(new Film("Film2", "Couleur", SousGenre.music, listActeurs2));
        _Films.add(new Film("Film3", "Couleur", SousGenre.western, listActeurs3));
        _Films.add(new Film("Film4", "Couleur", SousGenre.western, listActeurs1));
        
        List<Abonne> _Abonnes = new ArrayList<>();
        _Abonnes.add(new Abonne("Guy", "11/07/1996", "M", 1));
        _Abonnes.add(new Abonne("Ash", "27/06/1999", "M", 1));
        _Abonnes.add(new Abonne("Jasmine", "01/01/1992", "F", 5));
        
        //System.err.println(_Abonnes);
        
        System.out.println(nf.listFilmsType(50));
        System.out.println(nf.getListFilmsSim("Film1"));
        
    
        
        
        
        System.out.println(nf.getListAbonnesSim("Guy"));
        
      
        // System.out.println(nf.getListAbonneCurieux());
        
        Gson g = new Gson();
        
        
        
        String folderName = "data";
        Path resourcesPath = Paths.get("src");
        Path folderPath = resourcesPath.resolve(folderName);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String currentDate = LocalDate.now().format(formatter);
        
        

        
        try {
            FileWriter file = new FileWriter(folderPath.toString() + "\\Abonne_" + currentDate, false);
            file.write(g.toJson(nf.getAbonnes()));
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(SuiviLocationVideos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter file = new FileWriter(folderPath.toString() + "\\films_" + currentDate, false);
            file.write(g.toJson(nf.getFilms()));
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(SuiviLocationVideos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter file = new FileWriter(folderPath.toString() + "\\coffret_" + currentDate, false);
            file.write(g.toJson(nf.getCoffrets()));
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(SuiviLocationVideos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter file = new FileWriter(folderPath.toString() + "\\pret_" + currentDate, false);
            file.write(g.toJson(nf.getPret()));
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(SuiviLocationVideos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
