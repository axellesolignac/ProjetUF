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
 * cette classe servira à modifier le statut d'une annonce d'un bien 
 */

public class ChoixAgence implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel agence;
    private JLabel info;
    private JButton valider;
    
    private int id_bien;
    private String lastname_owner;
    private String city;
    
    ArrayList<String> arrayAgence = new ArrayList<>();
    
    private JComboBox<Object> cbAgence;
    
    public ChoixAgence(Connexion cc, int id_bien, String las_client, String ci) throws SQLException {
        this.connect = cc;
        this.id_bien = id_bien;
        this.lastname_owner = las_client;
        this.city = ci;
        
        try {           
            /* Construction fenetre */
            fen = new JFrame();
            fen.setTitle("Affectation");
            fen.setSize(350, 250);
            fen.setLayout(null);            
            
            String request = "SELECT * FROM agence;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String las = set.getString("number");
                arrayAgence.add(las);
            }
            
            Object[] listAgence = arrayAgence.toArray();
            //System.out.println("liste des agences : " + listAgence);
            
            info = new JLabel("Le bien est situe a " + city);
            info.setBounds(80, 20, 250, 20);
            fen.add(info);
            
            agence = new JLabel("Agence (AG/VILLE/01) : ");
            agence.setBounds(10, 50, 150, 20);
            fen.add(agence);

            cbAgence = new JComboBox<>(listAgence);
            cbAgence.setBounds(150, 50, 150, 20);
            fen.add(cbAgence);
            
            // Bouton modifier 
            valider = new JButton("Valider");
            valider.setBounds(70, 100, 100, 30);
            valider.addActionListener(this);
            fen.add(valider);

            // Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du choix agence : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String agec = cbAgence.getSelectedItem().toString();
            
            AffectationBien ab = new AffectationBien(connect, id_bien, lastname_owner, agec);
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons choixagence : " + e.getMessage());
        }
    }
}
