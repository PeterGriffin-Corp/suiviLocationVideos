/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;

import java.util.Objects;

/**
 *
 * @author jlema
 */
public class SousGenre {
    private final String nomSousGenre;
    private final Genre genre;

    public SousGenre(String _NomSousGenre, Genre _Genre) {
        this.nomSousGenre = _NomSousGenre;
        this.genre = _Genre;
    }

    

    
    public String getNomSousGenre() {
        return nomSousGenre;
    }

    public Enum getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nomSousGenre);
        hash = 19 * hash + Objects.hashCode(this.genre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SousGenre other = (SousGenre) obj;
        if (!Objects.equals(this.nomSousGenre, other.nomSousGenre)) {
            return false;
        }
        return Objects.equals(this.genre, other.genre);
    }

    @Override
    public String toString() {
        return "SousGenre{" + "SousGenre=" + nomSousGenre + ", genre=" + genre + '}';
    }
    
    
}
