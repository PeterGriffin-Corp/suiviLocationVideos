
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

     
        /*
        La création des acteurs
        */
        Acteur acteur1 = new Acteur("LaFontaine", "Jean");
        Acteur acteur2 = new Acteur("DuPuit", "Nico");
        Acteur acteur3 = new Acteur("Jardin", "Patrik");
        Acteur acteur4 = new Acteur("SauveTerre", "Luc");
        Acteur acteur5 = new Acteur("Princesse", "Lucie");
        
        /*
        L'ajout des acteurs dans une liste d'acteurs
        */

        List<Acteur> listActeurs1 = new ArrayList<>();
        listActeurs1.add(acteur1);
        listActeurs1.add(acteur3);
        
        List<Acteur> listActeurs2 = new ArrayList<>();
        listActeurs2.add(acteur1);
        listActeurs2.add(acteur2);
        listActeurs2.add(acteur3);
        listActeurs2.add(acteur5);
        
        List<Acteur> listActeurs3 = new ArrayList<>();
        listActeurs3.add(acteur4);
        listActeurs3.add(acteur2);
        listActeurs3.add(acteur5);
        
        
        /*
        La création des abonnés et films
        */
        NoyauFonctionnel nf = new NoyauFonctionnel();
        
        nf.addAbonne("Guy", "11/07/1996", "M", 1);
        nf.addAbonne("Ash", "27/06/1999", "M", 1);
        nf.addAbonne("Jasmine", "01/01/1992", "F", 5);
        nf.addAbonne("Loic","03/01/2004" , "M", 1);
        nf.addAbonne("Justin","04/01/2000" , "F", 3);
        
        nf.addFilm("Iron-Man", "Couleur", SousGenre.adventure, listActeurs3);
        nf.addFilm("Avatar", "Couleur", SousGenre.adventure, listActeurs1);
        nf.addFilm("Hight school musical", "Couleur", SousGenre.music, listActeurs2);
        nf.addFilm("Lucky luck", "Couleur", SousGenre.western, listActeurs3);
        nf.addFilm("Chasse aux trésor", "Noir et blanc", SousGenre.western, listActeurs1);
        nf.addFilm("Jardin des météors", "Couleur", SousGenre.romance, listActeurs2);
        nf.addFilm("Mamadu et Manon", "Couleur", SousGenre.romance, listActeurs2);
        nf.addFilm("Dance3", "Couleur", SousGenre.music, listActeurs2);
        
        
        
        /*
        L'ajout des films dans une liste de film
        */
        List<String> films_lot1 = new ArrayList<>();
        films_lot1.add("Avatar");
        films_lot1.add("Mamadu et Manon");
        films_lot1.add("Jardin des météors");
        
        List<String> films_lot2 = new ArrayList<>();
        films_lot2.add("Lucky Luck");
        films_lot2.add("Chasse aux trésor");
        films_lot2.add("Hight school musical");
        
        List<String> films_lot3 = new ArrayList<>();
        films_lot3.add("Dance3");
        films_lot3.add("Hight school musical");
        films_lot3.add("Chasse aux trésor");
        
        List<String> films_lot4 = new ArrayList<>();
        films_lot4.add("Iron-Man");
        films_lot4.add("Avatar");
        films_lot4.add("Dance3");
        
        /*
        L'ajout des films dans une liste de film pour coffret
        */
        List<Film> coffret_1 = new ArrayList<>();
        coffret_1.add(nf.findMovie("Iron-Man").get());
        coffret_1.add(nf.findMovie("Avatar").get());
        coffret_1.add(nf.findMovie("Chasse aux trésor").get());
        coffret_1.add(nf.findMovie("Hight school musical").get());
        coffret_1.add(nf.findMovie("Lucky luck").get());
        coffret_1.add(nf.findMovie("Jardin des météors").get());
        
        List<Film> coffret_2 = new ArrayList<>();
        coffret_2.add(nf.findMovie("Mamadu et Manon").get());
        coffret_2.add(nf.findMovie("Avatar").get());
        coffret_2.add(nf.findMovie("Chasse aux trésor").get());
        coffret_2.add(nf.findMovie("Dance3").get());
        coffret_2.add(nf.findMovie("Jardin des météors").get());
        
        
        
        /*
        L'enregistrement des locations des films par des abonnés
        */
        nf.enregistrerPretFilm("Guy", films_lot1);
        nf.enregistrerPretFilm("Guy", films_lot2);
        nf.enregistrerPretFilm("Ash", films_lot2);
        nf.enregistrerPretFilm("Ash", films_lot4);
        nf.enregistrerPretFilm("Jasmine", films_lot4);
        nf.enregistrerPretFilm("Jasmine", films_lot3);
        
        /*
        La création des coffrets
        */
        nf.creatCoffret("La folie",coffret_1, true);
        nf.creatCoffret("Trop bien",coffret_2, true);
        
        /*
        L'enregistrement des locations des coffrets par des abonnés
        */
        nf.enregistrerPretCoffret("Guy","La folie");
        nf.enregistrerPretCoffret("Justin","La folie");
        nf.enregistrerPretCoffret("Guy","Trop bien");
        nf.enregistrerPretCoffret("Ash","Trop bien");
        
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
