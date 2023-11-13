/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suivilocationvideos;


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
        SousGenre sousGenre2 = new SousGenre("MUSIQUE", Genre.COMEDIE);
        
        System.out.println(sim.similarityGenre(sousGenre1, sousGenre2));
                
        
    }
    
}
