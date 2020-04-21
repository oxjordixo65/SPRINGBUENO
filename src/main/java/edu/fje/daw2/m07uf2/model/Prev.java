package edu.fje.daw2.m07uf2.model;


import org.springframework.data.annotation.Id;

/**
 * Classe entitat que representa un client.
 * Es tracta d'una classe del model que es farà persistent
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2020
 */
public class Prev {
    @Id
    public String id;

    public String dia;
    public String temps;
    public int temperatura;

    public Prev() {
    }

    public Prev(String dia, String temps, int temperatura) {
        this.dia = dia;
        this.temps = temps;
        this.temperatura = temperatura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prev)) return false;

        Prev client = (Prev) o;

        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Prev{" +
                "id='" + id + '\'' +
                ", dia='" + dia + '\'' +
                ", temps='" + temps + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}