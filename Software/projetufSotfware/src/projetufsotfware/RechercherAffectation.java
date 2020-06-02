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
 * @author Utilisateur
 */
public class RechercherAffectation implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel lastname;
    private JLabel labelinfo;
    
    private String las_client;
    private JButton valider;
    
    ArrayList<String> arrayLastname = new ArrayList<>();
    
    private JComboBox<Object> cbLastname;
    
    public RechercherAffectation (Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            fen = new JFrame();
            fen.setTitle("Affectation");
            fen.setSize(430, 250);
            fen.setLayout(null);
            
            String request = "SELECT c.lastname FROM bien b JOIN client c ON b.owner = c.lastname;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String las = set.getString("lastname");
                
                arrayLastname.add(las);
            }
            
            Object[] listLastname = arrayLastname.toArray();
            
            //System.out.println("liste des noms : " + arrayLastname);
            
            labelinfo = new JLabel("Rentrez le nom du proprietaire");
            labelinfo.setBounds(70, 20, 250, 20);
            fen.add(labelinfo);
            
            /** la zone de saisie */
            lastname = new JLabel("Nom du proprietaire : ");
            lastname.setBounds(50, 70, 150, 20);
            fen.add(lastname);
            
            cbLastname = new JComboBox<>(listLastname);
            cbLastname.setBounds(200, 70, 150, 20);
            fen.add(cbLastname);
        
            valider = new JButton("Rechercher");
            valider.addActionListener(this);
            valider.setBounds(120, 140, 150, 20);
            fen.add(valider);
            
            //Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur recherche affectation : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            las_client = cbLastname.getSelectedItem().toString();
            
            String query = "SELECT * FROM bien WHERE owner='"+las_client+"';";
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery();
            set.next();
            int id_bien = set.getInt("id");
            String city = set.getString("city");
            
            ChoixAgence ca = new ChoixAgence(connect, id_bien, las_client, city);
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton affectation : " + e.getMessage());
        }
    }
}