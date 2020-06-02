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
 * cette classe sert a rechercher une annonce afin de pouvoir changer le statut de ladite annonce
 */

public class RechercherAnnonce implements ActionListener {
    private Connexion connect;
    private RechercherBien searchB;
    private JFrame fen;
    
    private JLabel title;
    private JLabel lastname;
    
    private JTextField input_title;
    private JTextField input_lastname;
    
    private String nm;
    private String pre;
    private JButton valider;
    
    public RechercherAnnonce (Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Rechercher un bien");
            fen.setSize(400, 350);
            fen.setLayout(null);
            
            JLabel labelinfo = new JLabel("Rentrez le titre du bien et le nom du proprietaire");
            labelinfo.setBounds(70, 20, 250, 20);
            fen.add(labelinfo);
            
            /** la zone de saisie */
            title = new JLabel("Titre du bien : ");
            title.setBounds(50, 100, 80, 20);
            fen.add(title);
            lastname = new JLabel("Nom du proprietaire : ");
            lastname.setBounds(50, 140, 150, 20);
            fen.add(lastname);
            
            input_title = new JTextField();
            input_title.setBounds(140, 100, 150, 20);
            fen.add(input_title);
            input_lastname = new JTextField();
            input_lastname.setBounds(140, 140, 150, 20);
            fen.add(input_lastname);
        
            /** bouton rechercher */
            valider = new JButton("Rechercher");
            valider.addActionListener(this);
            valider.setBounds(140, 210, 150, 20);
            fen.add(valider);
            
            /** Met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur recherche bien : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            nm = input_title.getText();
            pre = input_lastname.getText();
            //System.out.println(nm + " ; " + pre);
            CrudBien cb = new CrudBien(connect, searchB, nm, pre);
            
            /** ferme la fenetre actuelle */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton rechercher : " + e.getMessage());
        }
    }
}