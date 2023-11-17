/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suivilocationvideos;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author JAchraf, Guangyi, Justin
 */
public class Location {
    private final String id;
    private Date dateDebut;
    private Abonne abonne;
    private final Film film;
    private final Coffret coffret;

    
    public Location(String id, Abonne _Abonne, Film _Film, Coffret _Coffret) {
        this.id = id;
        this.abonne = _Abonne;
        this.film = _Film;
        this.coffret = _Coffret;
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

    public Coffret getCoffret() {
        return coffret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.dateDebut);
        hash = 71 * hash + Objects.hashCode(this.abonne);
        hash = 71 * hash + Objects.hashCode(this.film);
        hash = 71 * hash + Objects.hashCode(this.coffret);
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
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        return Objects.equals(this.coffret, other.coffret);
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", dateDebut=" + dateDebut + ", abonne=" + abonne + ", film=" + film + ", coffret=" + coffret + '}';
    }
    
    
}