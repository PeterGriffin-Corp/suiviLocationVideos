/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author jlema
 */
public class Location {
    private final String id;
    private Date dateDebut;
    private Abonne abonne;
    private final Film film;

    
    public Location(String id, Abonne _Abonne, Film _Film) {
        this.id = id;
        this.abonne = _Abonne;
        this.film = _Film;
        this.dateDebut = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.abonne.setHistoryFilm(_Film);
    }
    

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date aDateDebut) {
        this.dateDebut = aDateDebut;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public String getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dateDebut);
        hash = 97 * hash + Objects.hashCode(this.abonne);
        hash = 97 * hash + Objects.hashCode(this.film);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.abonne, other.abonne)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", dateDebut=" + dateDebut + ", abonne=" + abonne + ", film=" + film + '}';
    }

    
}
