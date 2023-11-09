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
    private final List<Film> films;
    
    
    
    
    
    
    /*
    public void addAbonne(String _Nom, LocalDate _DateNaissance, String _Sexe, Tranche _Revenu){
        abonnes.put(_Nom, new Abonne(_Nom, _DateNaissance, _Sexe, _Revenu));
    }
    
    public Abonne findAbonne(String _Nom){
        Abonne _Abonne = abonnes.get(_Nom);
        return _Abonne;
    }
    */

    public NoyauFonctionnel(Map<String, Abonne> abonnes, List<Film> films) {
        this.abonnes = new HashMap<>();
        this.films = new ArrayList<>();
    }
}
