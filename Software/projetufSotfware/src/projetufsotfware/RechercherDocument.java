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
 * cette classe sert a rechercher des documents
 */

public class RechercherDocument implements ActionListener {
    private Connexion connect;
    private RechercherDocument searchD;
    private PreparedStatement ps;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel type;
    private JLabel owner;
    
    private String nm;
    private String pre;
    private JButton valider;
    
    ArrayList<String> arrayType = new ArrayList<>();
    ArrayList<String> arrayLastname = new ArrayList<>();
    
    private JComboBox<Object> cbType;
    private JComboBox<Object> cbLastname;
    
    public RechercherDocument (Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            fen = new JFrame();
            fen.setTitle("Rechercher un document");
            fen.setSize(400, 350);
            fen.setLayout(null);
            
            
            String request = "SELECT d.type, c.lastname, c.firstname FROM document d JOIN client c ON d.id_client = c.id;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String til = set.getString("type");
                String las = set.getString("lastname");
                
                arrayType.add(til);
                arrayLastname.add(las);
            }
            
            Object[] listType = arrayType.toArray();
            Object[] listLastname = arrayLastname.toArray();
            
            JLabel labelinfo = new JLabel("Chercher par type et proprietaire");
            labelinfo.setBounds(70, 20, 250, 20);
            fen.add(labelinfo);
            
            /** la zone de saisie */
            type = new JLabel("Type du document : ");
            type.setBounds(50, 100, 150, 20);
            fen.add(type);
            owner = new JLabel("Nom du proprietaire : ");
            owner.setBounds(50, 140, 150, 20);
            fen.add(owner);
            
            cbType = new JComboBox<>(listType);
            cbType.setBounds(200, 100, 150, 20);
            fen.add(cbType);
            cbLastname = new JComboBox<>(listLastname);
            cbLastname.setBounds(200, 140, 150, 20);
            fen.add(cbLastname);
        
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
    public void actionPerformed(ActionEvent event) {
        try {
            nm = cbType.getSelectedItem().toString();
            pre = cbLastname.getSelectedItem().toString();
            //System.out.println(nm + " ; " + pre);
            CrudDocument cd = new CrudDocument(connect, searchD, nm, pre);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
}