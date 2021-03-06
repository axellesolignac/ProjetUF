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
 * cette classe sert a afficher le menu de gestion des documents
 */

public class GestionDoc implements ActionListener {
    private Connexion connect;
    private JFrame fen;
    
    private JButton add;
    private JButton info;
    
    public GestionDoc(Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction de la fenêtre */
            fen = new JFrame();
            fen.setTitle("Gestion des documents");
            fen.setSize(380, 200);
            /*fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            fen.setLayout(null);
            
            
            /** bouton pour ajouter un document */
            add = new JButton("Ajouter un document");
            add.setBounds(50, 20, 250, 40);
            add.addActionListener(this);
            fen.add(add);

            /** bouton pour afficher les informations de document */
            info = new JButton("Afficher informations documents");
            info.setBounds(50, 70, 250, 40);
            info.addActionListener(this);
            fen.add(info);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la gestion doc : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** depend de l'origine du clic */
            if ( event.getSource() == add ) {
                AjoutDocument ad = new AjoutDocument(connect);
            }
            else if ( event.getSource() == info ) {
                RechercherDocument re = new RechercherDocument(connect);
            }
            else {
                System.out.println("Erreur dans les boutons de gestion des documents");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
}