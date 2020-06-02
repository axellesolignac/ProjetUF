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

public class AjoutDocument implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private ResultSet set;
    private ResultSet rst;
    private JFrame fen;
    
    private JTextField input_title;
    private JTextField input_contenu;
    private JTextField input_type;
    
    private JLabel title;
    private JLabel contenu;
    private JLabel type;
    private JLabel nameClient;

    private JButton ajout;
    
    ArrayList<String> arrayLastname = new ArrayList<>();
    private JComboBox<Object> cbLastname;
    
    public AjoutDocument(Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            //Construction fenetre
            fen = new JFrame();
            fen.setTitle("Ajouter un document");
            fen.setSize(380, 300);
            fen.setLayout(null);

            String request = "SELECT lastname FROM client;";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);

            while (set.next()) {
                String elm = set.getString("lastname");
                arrayLastname.add(elm);
            }

            Object[] listLastname = arrayLastname.toArray();

            //System.out.println("liste des noms : " + arrayLastname);

            // Construction des label
            title = new JLabel("Titre : ");
            title.setBounds(10, 20, 150, 20);
            fen.add(title);
            contenu = new JLabel("Contenu : ");
            contenu.setBounds(10, 50, 150, 20); 
            fen.add(contenu);
            type = new JLabel("Type : ");
            type.setBounds(10, 80, 150, 20);
            fen.add(type);
            nameClient = new JLabel("Nom du client : ");
            nameClient.setBounds(10, 110, 150, 20);
            fen.add(nameClient);

            input_title = new JTextField();
            input_title.setBounds(180, 20, 170, 20);
            fen.add(input_title);
            input_contenu = new JTextField();
            input_contenu.setBounds(180, 50, 170, 20);
            fen.add(input_contenu);
            input_type = new JTextField();
            input_type.setBounds(180, 80, 170, 20);
            fen.add(input_type);
            cbLastname = new JComboBox<>(listLastname);
            cbLastname.setBounds(180, 110, 170, 20);
            fen.add(cbLastname);

            // Bouton ajouter
            ajout = new JButton("Ajouter");
            ajout.setBounds(120, 150, 150, 20);
            ajout.addActionListener(this);
            fen.add(ajout);

            // Met en visible
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String na = cbLastname.getSelectedItem().toString();
            String request = "SELECT id FROM client WHERE lastname='"+na+"';";
            ps = connect.getConnect().prepareStatement(request);
            rst = ps.executeQuery();
            rst.next();
            
            int id = rst.getInt("id");
            //System.out.println("id : " + id);
            String tit = input_title.getText();
            String ty = input_type.getText();
            String co = input_contenu.getText();
            
            Ajouter(tit, ty, co, id);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
    
    public void Ajouter (String tit, String ty, String co, int id) throws SQLException {
        try  {
            String requete = "INSERT INTO document (title, type, contenu, id_client) VALUES ('"+tit+"', '"+ty+"', '"+co+"', "+id+");";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur ajout : " + e.getMessage());
        }
    }
}