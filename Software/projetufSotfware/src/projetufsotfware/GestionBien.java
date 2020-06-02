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
 * @author Utilisateur
 * cette classe sert a afficher le menu de gestion des bien
 */

public class GestionBien implements ActionListener {
    private Connexion connect;
    private JFrame fen;
    
    private JButton add;
    private JButton info;
    
    public GestionBien (Connexion cc) throws SQLException {
        this.connect = cc;
        try {
            //Construction de la fenêtre 
            fen = new JFrame();
            fen.setTitle("Gestion des biens");
            fen.setSize(380, 200);
            fen.setLayout(null);
            
            /** Bouton pour ajouter un document */
            add = new JButton("Ajouter un bien");
            add.setBounds(50, 20, 220, 40);
            add.addActionListener(this);
            fen.add(add);

            /** Bouton pour afficher les informations de document */
            info = new JButton("Afficher informations biens");
            info.setBounds(50, 70, 220, 40);
            info.addActionListener(this);
            fen.add(info);

            //Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion bien : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
    	try {
            if ( event.getSource() == add ) {
                AjoutBien ab = new AjoutBien(connect);
            }
            if ( event.getSource() == info ) {
                RechercherBien cb = new RechercherBien(connect);
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur bouton gestion bien : " + e.getMessage());
        }
    }
}