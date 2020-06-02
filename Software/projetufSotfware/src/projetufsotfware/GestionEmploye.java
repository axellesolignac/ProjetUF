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
 * cette classe sert a afficher le menu de gestion des employes
 */

public class GestionEmploye implements ActionListener {
    private Connexion connect;
    private JFrame fen;
    
    private JButton add;
    private JButton info;
    
    public GestionEmploye(Connexion cc) throws SQLException {
        this.connect = cc;
        try {
            //Construction de la fenêtre 
            fen = new JFrame();
            fen.setTitle("Gestion des employes");
            fen.setSize(380, 200);
            /*fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            fen.setLayout(null);
            
            
            // Bouton pour ajouter un employe
            add = new JButton("Ajouter un employe");
            add.setBounds(50, 20, 250, 40);
            add.addActionListener(this);
            fen.add(add);

            //Bouton pour afficher les informations d'un employe
            info = new JButton("Afficher informations employe");
            info.setBounds(50, 70, 250, 40);
            info.addActionListener(this);
            fen.add(info);

            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la gestion employe : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if ( event.getSource() == add ) {
                AjoutEmploye ae = new AjoutEmploye(connect);
            }
            if ( event.getSource() == info ) {
                RechercherEmploye re = new RechercherEmploye(connect);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
}