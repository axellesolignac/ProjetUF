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
 * cette classe affiche le menu disponible pour les agents immobiliers
 */
public class MenuEmploye implements ActionListener {
    private Connexion connect;
    private JButton client;
    private JButton compte;
    private JButton doc;
    private JButton bien;
    private int id_agent;

    public MenuEmploye(Connexion cc, int id) throws SQLException{
            this.connect = cc;
            this.id_agent = id;
            try {
                
            // Fenetre pour afficher le menu
            JFrame fen = new JFrame();
            fen.setTitle("Menu employe");
            fen.setSize(470, 200);
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fen.setLayout(null);

            // Bouton ajouter
            client = new JButton("Gestion des clients");
            client.setBounds(10, 20, 200, 30);
            client.addActionListener(this);
            fen.add(client);

            //Bouton pour le compte
            compte = new JButton("Mon compte");
            compte.setBounds(230, 20, 200, 30);
            compte.addActionListener(this);
            fen.add(compte);

            //Bouton gestion documents
            doc = new JButton("Gestion des documents");
            doc.setBounds(10, 70, 200, 30);
            doc.addActionListener(this);
            fen.add(doc);

            //bouton gestion bien
            bien = new JButton("Gestion des biens");
            bien.setBounds(230, 70, 200, 30);
            bien.addActionListener(this);
            fen.add(bien);

            // Met en visible 
            fen.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur du menu employe : " + e.getMessage());
            }
    }

    @Override
    public void actionPerformed(ActionEvent event){
    	try {
            if ( event.getSource() == client ) {
                GestionClient gc = new GestionClient(connect);
            }
            if ( event.getSource() == doc ) {
                GestionDoc gd = new GestionDoc(connect);
            }
            if ( event.getSource() == compte ) {
                MonCompte rc = new MonCompte(connect, id_agent);
            }
            if ( event.getSource() == bien ) {
                GestionBien gb = new GestionBien(connect);
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton : " + e.getMessage());
        }
    }
}