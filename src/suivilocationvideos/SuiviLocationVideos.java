
package suivilocationvideos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
        
        //System.out.println(nf.listFilmsType(50));
        //System.out.println(nf.getListFilmsSim("Film1"));
        
        //System.out.println(nf.getSimilarityFilm(_Films.get(0), _Films.get(3)));
        //System.out.println(nf.getSimilarityFilm(_Films.get(0), _Films.get(2)));
        //System.out.println(nf.getSimilarityFilm(_Films.get(0), _Films.get(1)));
        
        
        
//        System.out.println(nf.getListAbonnesSim("Guy"));
//        
//        System.out.println(nf.getSimilarityAbonne(_Abonnes.get(0), _Abonnes.get(1)));
//        System.out.println(nf.getSimilarityAbonne(_Abonnes.get(0), _Abonnes.get(2)));
        
        // System.out.println(nf.getListAbonneCurieux());
        //System.out.println(new Gson().toJson(nf));
        
        //Gson g = new Gson();
        
        //NoyauFonctionnel nf1 = g.fromJson(g.toJson(nf), NoyauFonctionnel.class);
        
        //NoyauFonctionnel nf1 = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(nf), NoyauFonctionnel.class);
        //System.err.println(nf1);
        
       
        //String abonnesJsonString = new ObjectMapper().writeValueAsString(nf.getAbonnes());
        
        //Map<String, Abonne> abonnes_json = new ObjectMapper().readValue(abonnesJsonString, new com.fasterxml.jackson.core.type.TypeReference<Map<String, Abonne>>() {});

        //System.out.println(abonnes_json);
        //System.out.println(new ObjectMapper().writeValueAsString(nf.getAbonnes()));
        
        
        //String jsonString = g.toJson(nf);
        //JsonElement jsonElement = JsonParser.parseString(jsonString);
        //System.out.println(jsonElement);
    }
    
}
