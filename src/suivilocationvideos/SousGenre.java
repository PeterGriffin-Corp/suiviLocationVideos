
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


/**
 *
 * @author Achraf, Guangyi HUANG
 */
public enum SousGenre {
    western(Genre.ACTION),
    adventure(Genre.ACTION),
    romance(Genre.COMEDIE),
    music(Genre.COMEDIE);
    
    private final Genre genre;

    private SousGenre(Genre aGenre) {
        this.genre = aGenre;
    }

    public Genre GetGenre() {
        return genre;
    }
}