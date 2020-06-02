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
 * cette classe sert a rechercher les agences selon leur numéro et leur ville
 */

public class RechercherAgence implements ActionListener {
    private Connexion connect;
    private RechercherAgence searchA;
    private JFrame fen;
    
    private JLabel numero;
    private JLabel ville;
    
    private JTextField input_numero;
    private JTextField input_ville;
    
    private String nm;
    private String pre;
    private JButton valider;
    
    public RechercherAgence (Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Rechercher une agence");
            fen.setSize(430, 300);
            fen.setLayout(null);
            
            JLabel labelinfo = new JLabel("Rentrez le numero de l'agence et sa ville");
            labelinfo.setBounds(70, 20, 350, 20);
            fen.add(labelinfo);
            
            /** la zone de saisie */
            numero = new JLabel("Numero de l'agence : ");
            numero.setBounds(20, 100, 200, 20);
            fen.add(numero);
            ville = new JLabel("Ville : ");
            ville.setBounds(20, 140, 80, 20);
            fen.add(ville);
            
            input_numero = new JTextField();
            input_numero.setBounds(200, 100, 200, 20);
            fen.add(input_numero);
            input_ville = new JTextField();
            input_ville.setBounds(200, 140, 200, 20);
            fen.add(input_ville);
        
            /** bouton rechercher */
            valider = new JButton("Rechercher");
            valider.addActionListener(this);
            valider.setBounds(110, 170, 150, 20);
            fen.add(valider);
            
            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur recherche agence : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            nm = input_numero.getText();
            pre = input_ville.getText();
            //System.out.println(nm + " ; " + pre);
            CrudAgence cra = new CrudAgence(connect, searchA, nm, pre);
            
            /** ferme la fenetre actuelle  */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton rechercher : " + e.getMessage());
        }
    }
}