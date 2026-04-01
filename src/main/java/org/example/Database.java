package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private String url;

    public Database() {
        url = "jdbc:mysql://127.0.0.1:3306/";
    }

    public ArrayList<Libro> getLibri(String nomeDB, String user, String password) {
        ArrayList<Libro> libri = new ArrayList<>();

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                Class.forName("com.mysql.jdbc.Driver");
            }

            Connection conn = DriverManager.getConnection(url+nomeDB, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM libri");

            while (rs.next()) {
                int id = rs.getInt("id");
                String titolo = rs.getString("titolo");
                int numPagine = rs.getInt("numPagine");
                String autore = rs.getString("autore");

                Libro l = new Libro(id, titolo, numPagine, autore);
                libri.add(l);

                // System.out.println("Libro: " + titolo);
            }

            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return libri;
    }
}
