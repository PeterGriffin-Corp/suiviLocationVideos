/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author jlema
 */
public class NoyauFonctionnel {
 
    private final Map<String, Abonne> abonnes;
    private final Map<String, Film> films;
    
    
    public NoyauFonctionnel(Map<String, Abonne> abonnes, List<Film> films) {
        this.abonnes = new HashMap<>();
        this.films = new HashMap<>();
    }
    
    
    public Film findFilm(String _Titre){
        return films.get(_Titre);
    }
       
    
    public void addAbonne(String _Nom, String _DateNaissance, String _Sexe, int trancheRevenu){
        abonnes.put(_Nom, new Abonne(_Nom, _DateNaissance, _Sexe, trancheRevenu));
    }
    
    public Abonne findAbonne(String _Nom){
        Abonne _Abonne = abonnes.get(_Nom);
        return _Abonne;
    }
    

    
}
