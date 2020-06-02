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
import java.util.*;

/**
 *
 * @author Equipe B2B - B
 * cette classe sert a rechercher un bien par son titre et le nom de son propriétaire
 */

public class RechercherBien implements ActionListener {
    private Connexion connect;
    private RechercherBien searchB;
    private PreparedStatement ps;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel title;
    private JLabel lastname;
    
    private String nm;
    private String pre;
    private JButton valider;
    
    ArrayList<String> arrayTitle = new ArrayList<>();
    ArrayList<String> arrayLastname = new ArrayList<>();
    
    private JComboBox<Object> cbTitle;
    private JComboBox<Object> cbLastname;
    
    public RechercherBien (Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Rechercher un bien");
            fen.setSize(400, 350);
            fen.setLayout(null);
            
            /** requete pour recuperer et afficher des donnees */
            String request = "SELECT b.title, c.lastname FROM bien b JOIN client c ON b.owner = c.lastname;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String ftn = set.getString("title");
                String las = set.getString("lastname");
                
                arrayTitle.add(ftn);
                arrayLastname.add(las);
            }
            
            Object[] listTitle = arrayTitle.toArray();
            Object[] listLastname = arrayLastname.toArray();
            
            //System.out.println("liste des titres : " + listTitle);
            //System.out.println("liste des noms : " + arrayLastname);
            
            JLabel labelinfo = new JLabel("Rentrez le titre du bien et le nom du proprietaire");
            labelinfo.setBounds(70, 20, 350, 20);
            fen.add(labelinfo);
            
            /** la zone de saisie */
            title = new JLabel("Titre du bien : ");
            title.setBounds(20, 100, 150, 20);
            fen.add(title);
            lastname = new JLabel("Nom du proprietaire : ");
            lastname.setBounds(20, 140, 150, 20);
            fen.add(lastname);
            
            cbTitle = new JComboBox<>(listTitle);
            cbTitle.setBounds(200, 100, 150, 20);
            fen.add(cbTitle);
            cbLastname = new JComboBox<>(listLastname);
            cbLastname.setBounds(200, 140, 150, 20);
            fen.add(cbLastname);
        
            /** bouton rechercher */
            valider = new JButton("Rechercher");
            valider.addActionListener(this);
            valider.setBounds(110, 210, 150, 20);
            fen.add(valider);
            
            /** met en visible */
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
            nm = cbTitle.getSelectedItem().toString();
            pre = cbLastname.getSelectedItem().toString();
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