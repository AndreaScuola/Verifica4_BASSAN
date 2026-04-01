package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servletLibri")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nomeDB = request.getParameter("nomeDB");
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        //System.out.println("nomeDB: " + nomeDB + " user: " + user + " password: " + password);

        ArrayList<Libro> libri = new ArrayList<Libro>();

        Database db = new Database();
        libri = db.getLibri(nomeDB, user, password);

        try(PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Servlet Libri</title></head><body>");
            out.println("<h1>Tabella risultati</h1>");

            out.println("<table border=1>");
            out.println("<tr><th>ID</th><th>Titolo</th><th>Numero pagine</th><th>Autore</th></tr>");

            for (Libro l : libri) {
                out.println("<tr>");
                out.println("<td>" + l.getId() + "</td>");
                out.println("<td>" + l.getTitolo() + "</td>");
                out.println("<td>" + l.getNumPagine() + "</td>");
                out.println("<td>" + l.getAutore() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
        }
    }
}
