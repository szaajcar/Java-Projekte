package org.Formatieren;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Testverbindung {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public Testverbindung(ArrayList<Person> personen) {
        try {
            String url = "jdbc:mariadb://localhost:3306/glj_db";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);

            personenHinzufuegen(personen);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void personenHinzufuegen(ArrayList<Person> personen) throws SQLException{
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM personen");

        while (rs.next()) {
            personen.add(new Person(
                rs.getString("vorname"),
                rs.getString("name"),
                rs.getString("geschlecht"),
                rs.getString("geburtsdatum"),
                rs.getString("ahv"),
                rs.getString("region"),
                rs.getInt("kinder")
            ));
        }
    }

}
