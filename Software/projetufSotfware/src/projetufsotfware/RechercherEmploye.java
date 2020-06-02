/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetufsotfware;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Equipe B2B - B
 * cette classe sert a rechercher un client a partir de son nom et de son prenom
 */

public class RechercherEmploye implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private ResultSet set;
    private RechercherEmploye searchE;
    private JFrame fen;
    
    private JLabel labelinfo;
    private JLabel lastname;
    private JLabel firstname;
    
    private String nm;
    private String pre;
    private JButton valider;
    
    ArrayList<String> arrayLastname = new ArrayList<>();
    ArrayList<String> arrayFirstname = new ArrayList<>();
    
    private JComboBox<Object> cbLastname;
    private JComboBox<Object> cbFirstname;
    
    public RechercherEmploye(Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Rechercher un employe");
            fen.setSize(400, 350);
            fen.setLayout(null);
            
            /** requete afin de recuperer les noms, prenoms des employes afin de pouvoir les stocker dans des tableaux et pouvoir les afficher */
            String request = "SELECT lastname, firstname FROM employe;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            
            while (set.next()) {
                String elm = set.getString("lastname");
                String ftn = set.getString("firstname");
                arrayLastname.add(elm);
                arrayFirstname.add(ftn);
            }
            
            Object[] listLastname = arrayLastname.toArray();
            Object[] listFirstname = arrayFirstname.toArray();
            
            //System.out.println("liste des noms : " + arrayLastname);
            //System.out.println("liste des prenoms : " + arrayFirsntame);
            
            labelinfo = new JLabel("Rentrez le nom et le prenom du client");
            labelinfo.setBounds(70, 20, 250, 20);
            fen.add(labelinfo);
            
            /** les zones de saisie */
            lastname = new JLabel("Nom : ");
            lastname.setBounds(50, 100, 50, 20);
            fen.add(lastname);
            firstname = new JLabel("Prenom : ");
            firstname.setBounds(50, 140, 80, 20);
            fen.add(firstname);
            
            cbLastname = new JComboBox<>(listLastname);
            cbLastname.setBounds(140, 100, 150, 20);
            fen.add(cbLastname);
            cbFirstname = new JComboBox<>(listFirstname);
            cbFirstname.setBounds(140, 140, 150, 20);
            fen.add(cbFirstname);
        
            /** bouton rechercher */
            valider = new JButton("Rechercher");
            valider.addActionListener(this);
            valider.setBounds(100, 210, 150, 20);
            fen.add(valider);
            
            /** Met en visible */
            fen.setVisible(true);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Echec de connexion pour la recherche employe : " + e.getMessage());
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            nm = cbLastname.getSelectedItem().toString();
            pre = cbFirstname.getSelectedItem().toString();
            //System.out.println(nm + " ; " + pre);
            
            CrudEmploye ic = new CrudEmploye(connect, searchE, nm, pre);
            
            /** ferme la fenetre actuelle */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton rechercheremploye : " + e.getMessage());
        }
    }
}  