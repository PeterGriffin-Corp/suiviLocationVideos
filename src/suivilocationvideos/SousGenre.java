/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_java;

import java.util.Objects;

/**
 *
 * @author jlema
 */
public class SousGenre {
    private final String nonSousGenre;
    private final Enum genre;

    public SousGenre(String aNonSousGenre, Enum aGenre) {
        this.nonSousGenre = aNonSousGenre;
        this.genre = aGenre;
    }

    
    public String getNonSousGenre() {
        return nonSousGenre;
    }

    public Enum getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nonSousGenre);
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
        if (!Objects.equals(this.nonSousGenre, other.nonSousGenre)) {
            return false;
        }
        return Objects.equals(this.genre, other.genre);
    }

    @Override
    public String toString() {
        return "SousGenre{" + "nonSousGenre=" + nonSousGenre + ", genre=" + genre + '}';
    }
    
    
}
