/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Achraf
 */
public class Similarity {
    
    private List<Abonne> abonnes;
    
    
    public int getSimilarityAbonne(final Abonne abonne1, final Abonne abonne2){
        int similarityAge = Math.abs(abonne1.getAge() - abonne2.getAge())/10;
        int similaritySexe = (abonne1.getSexe().equals(abonne2.getSexe()) ? 1 : 0);
        int similarityTranche = Math.abs(abonne1.getRevenu() - abonne2.getRevenu());
        return similarityAge + similaritySexe + similarityTranche;
    }
    
    
    
    
    
    
}
