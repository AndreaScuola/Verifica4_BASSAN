package org.example;

public class Libro {
    private int id;
    private String titolo;
    private int numPagine;
    private String autore;

    public Libro(int id, String titolo, int numPagine, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.numPagine = numPagine;
        this.autore = autore;
    }

    public int getId() {return id;}
    public String getTitolo() {return titolo;}
    public int getNumPagine() {return numPagine;}
    public String getAutore() {return autore;}
}
