/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_java;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author jlema
 */
public class Location {
    private final String id;
    private Date dateDebut;
    private Date dateFin;
    private Map<Abonné, String> abonnes;
    private final Map<Film, String> films;

    public Location(String aId){
        this.id = aId;
        abonnes = new HashMap<>();
        films = new HashMap<>();
    }

    public Location(String aId, Date aDateDebut, Date aDateFin) {
        this.id = aId;
        this.dateDebut = aDateDebut;
        this.dateFin = aDateFin;
        abonnes = new HashMap<>();
        films = new HashMap<>();
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date aDateDebut) {
        this.dateDebut = aDateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    public String getId() {
        return id;
    }
    public void setDateFin(Date aDateFin) {
        this.dateFin = aDateFin;
    }

    public Map<Abonné, String> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Map<Abonné, String> aAbonnes) {
        this.abonnes = aAbonnes;
    }

    public Map<Film, String> getFilms() {
        return films;
    }

    public void addPret(final Film aFilm, Date aDateDebut, Date aDateFin,  String aTitre, Abonné aAbonné, String aNom) {
        films.put(aFilm, aTitre);
        abonnes.put(aAbonné, aNom);
    }

    public void removePret(final Film aFilm, Abonné aAbonné,Date aDateDebut, Date aDateFin) {
        films.remove(aFilm);
        abonnes.remove(aAbonné);
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dateDebut);
        hash = 89 * hash + Objects.hashCode(this.dateFin);
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
        return Objects.equals(this.dateFin, other.dateFin);
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", abonnes=" + abonnes + ", films=" + films + '}';
    }


    
}
