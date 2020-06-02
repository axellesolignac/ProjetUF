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
 * cette classe sert a afficher le menu de gestion des clients
 */

public class GestionClient implements ActionListener {
    private Connexion connect;
    private JFrame fen;
    
    private JButton add;
    private JButton info;
    
    public GestionClient(Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            // Construction de la fenêtre 
            fen = new JFrame();
            fen.setTitle("Gestion des clients");
            fen.setSize(370, 200);
            /*fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            fen.setLayout(null);

            // Bouton pour ajouter un client
            add = new JButton("Ajouter un client");
            add.setBounds(50, 20, 220, 40);
            add.addActionListener(this);
            fen.add(add);

            //Bouton pour afficher les informations d'un client
            info = new JButton("Afficher informations client");
            info.setBounds(50, 70, 220, 40);
            info.addActionListener(this);
            fen.add(info);

            // Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du menu de gestion client : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if ( event.getSource() == add ) {
                AjoutClient ajc = new AjoutClient (connect);
            }
            if ( event.getSource() == info ) {
                RechercherClient rc = new RechercherClient (connect);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons : " + e.getMessage());
        }
    }
}