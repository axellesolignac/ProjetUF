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
 * cette classe sert a afficher le menu de gestion des agences
 */

public class GestionAgence implements ActionListener {
    private Connexion connect;
    private JFrame fen;
    
    private JButton add;
    private JButton info;
    
    public GestionAgence(Connexion cc) throws SQLException {
        this.connect = cc;
        try {
            /** construction de la fenêtre */
            fen = new JFrame();
            fen.setTitle("Gestion des agences");
            fen.setSize(370, 200);
            /*fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
            fen.setLayout(null);
            
            /** bouton pour ajouter une agence */
            add = new JButton("Ajouter une agence");
            add.setBounds(50, 20, 250, 40);
            add.addActionListener(this);
            fen.add(add);

            /** bouton pour afficher les informations d'une agence */
            info = new JButton("Afficher informations agence");
            info.setBounds(50, 70, 250, 40);
            info.addActionListener(this);
            fen.add(info);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la gestion agence : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** depend de l'origine du clic */
            if ( event.getSource() == add ) {
                AjoutAgence aa = new AjoutAgence(connect);
            }
            else if ( event.getSource() == info ) {
                RechercherAgence ra = new RechercherAgence(connect);
            }
            else {
                System.out.println("Erreur dans les boutons de gestion agences");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
}