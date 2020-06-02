/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetufsotfware;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Equipe B2B - B
 * cette classe sert a se connecter a la bdd 
 */

public class Connexion {
    private  Connection connect;
    
    public Connexion() throws SQLException {
        
        /** test la connexion à la base de données */
        
        try {
            String url = "jdbc:mysql://localhost:3306/projetuf";
            connect = DriverManager.getConnection(url,"root","");
            System.out.println("Connexion a la base de donnée : succès ");
            
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec de connexion");
        }
    }
    
    public Connection getConnect() {
        return this.connect;
    }
}