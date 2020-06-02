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
public class AffectationBien implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private ResultSet set;
    private ResultSet rst;
    private JFrame fen;
    
    private JLabel agent;
    private JButton valider;
    private JLabel labelinfo;
    
    private int id_bien;
    private String lastname_owner;
    private String numbAgence;
    
    ArrayList<String> arrayAgent = new ArrayList<>();
    private JComboBox<Object> cbAgent;
    
    public AffectationBien(Connexion cc, int id_bien, String las_client, String agec) throws SQLException {
        this.connect = cc;
        this.id_bien = id_bien;
        this.lastname_owner = las_client;
        this.numbAgence = agec;
        
        try {           
            /* Construction fenetre */
            fen = new JFrame();
            fen.setTitle("Affectation d'un bien");
            fen.setSize(370, 250);
            fen.setLayout(null);            
            
            String request = "SELECT * FROM employe WHERE agence='"+numbAgence+"';";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String las = set.getString("lastname");
                arrayAgent.add(las);
            }
            
            Object[] listAgent = arrayAgent.toArray();
            //System.out.println("liste des agents : " + listAgent);
            
            labelinfo = new JLabel("Rentrez le nom de l'agent qui gerera le bien");
            labelinfo.setBounds(50, 20, 350, 20);
            fen.add(labelinfo);
            
            agent = new JLabel("Agent : ");
            agent.setBounds(30, 70, 80, 20);
            fen.add(agent);

            cbAgent = new JComboBox<>(listAgent);
            cbAgent.setBounds(150, 70, 150, 20);
            fen.add(cbAgent);
            
            // Bouton modifier 
            valider = new JButton("Valider");
            valider.setBounds(100, 100, 100, 30);
            valider.addActionListener(this);
            fen.add(valider);

            // Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du choix agent : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String lastAgt = cbAgent.getSelectedItem().toString();
            
            
            String querys = "SELECT id_agent, firstname FROM employe WHERE lastname='"+lastAgt+"';";
            ps = connect.getConnect().prepareStatement(querys);
            set = ps.executeQuery();
            set.next();
            int id_agent = set.getInt("id_agent");
            String fnAgt = set.getString("firstname");
     
            
            Ajouter (id_agent, lastAgt, fnAgt, numbAgence, id_bien, lastname_owner);
            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton valider Affectation : " + e.getMessage());
        }
    }
    
    public void Ajouter (int id_agent, String lastAgt, String fnAgt, String numbAgence, int id_bien, String lastname_owner) throws SQLException {
        try  {
            String requete = "INSERT INTO affectation (id_agent, lastname_agent, firstname_agent, agence, id_bien, lastname_client) VALUES ("+id_agent+", '"+lastAgt+"', '"+fnAgt+"', '"+numbAgence+"', "+id_bien+", '"+lastname_owner+"');";
            ps = connect.getConnect().prepareStatement(requete);

            ps.executeUpdate();
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans Ajouter affectation : " + e.getMessage());
        }
    }
}