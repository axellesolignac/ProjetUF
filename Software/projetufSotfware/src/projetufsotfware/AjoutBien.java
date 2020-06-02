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
 * cette classe sert a ajouter un bien
 */

public class AjoutBien implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private JFrame fen;
    
    private JTextField input_categorie;
    private JTextField input_title;
    private JTextField input_prix;
    private JTextField input_address;
    private JTextField input_city;
    private JTextField input_description;
    private JTextField input_superficie;
    private JTextField input_surfaceTerrain;
    private JTextField input_dependance;
    private JTextField input_photo;
    private JTextField input_nbPiece;
    private JTextField input_nbEtage;
    private JTextField input_nbChambre;
    private JTextField input_owner;
    
    private JLabel categorie;
    private JLabel title;
    private JLabel prix;
    private JLabel address;
    private JLabel city;
    private JLabel description;
    private JLabel superficie;
    private JLabel surfaceTerrain;
    private JLabel dependance;
    private JLabel photo;
    private JLabel nbPiece;
    private JLabel nbEtage;
    private JLabel nbChambre;
    private JLabel owner;

    private JButton ajout;
    
    public AjoutBien (Connexion cc) throws SQLException {
        this.connect = cc;
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Ajouter un bien");
            fen.setSize(450, 550);
            fen.setLayout(null);

            /** les labels et inputs */
            categorie = new JLabel("Categorie : ");
            categorie.setBounds(10, 20, 150, 20);
            fen.add(categorie);
            title = new JLabel("Titre : ");
            title.setBounds(10, 50, 150, 20); 
            fen.add(title);
            prix = new JLabel("Prix : ");
            prix.setBounds(10, 80, 150, 20);
            fen.add(prix);
            address = new JLabel("Adresse : ");
            address.setBounds(10, 110, 150, 20);
            fen.add(address);
            city = new JLabel("Ville : ");
            city.setBounds(10, 140, 150, 20); 
            fen.add(city);
            description = new JLabel("Description : ");
            description.setBounds(10, 170, 150, 20);
            fen.add(description);
            superficie = new JLabel("Superficie : ");
            superficie.setBounds(10, 200, 150, 20);
            fen.add(superficie);
            surfaceTerrain = new JLabel("Surface du terrain : ");
            surfaceTerrain.setBounds(10, 230, 150, 20); 
            fen.add(surfaceTerrain);
            dependance = new JLabel("Dependance : ");
            dependance.setBounds(10, 260, 150, 20);
            fen.add(dependance);
            photo = new JLabel("Photo : ");
            photo.setBounds(10, 290, 150, 20);
            fen.add(photo);
            nbPiece = new JLabel("Nombre de piece : ");
            nbPiece.setBounds(10, 320, 150, 20); 
            fen.add(nbPiece);
            nbEtage = new JLabel("Nombre d'etage : ");
            nbEtage.setBounds(10, 350, 150, 20);
            fen.add(nbEtage);
            nbChambre = new JLabel("Nombre de chambre : ");
            nbChambre.setBounds(10, 380, 150, 20); 
            fen.add(nbChambre);
            owner = new JLabel("Nom du proprietaire : ");
            owner.setBounds(10, 410, 200, 20);
            fen.add(owner);

            input_categorie = new JTextField();
            input_categorie.setBounds(200, 20, 150, 20);
            fen.add(input_categorie);
            input_title = new JTextField();
            input_title.setBounds(200, 50, 150, 20);
            fen.add(input_title);
            input_prix = new JTextField();
            input_prix.setBounds(200, 80, 150, 20);
            fen.add(input_prix);
            input_address = new JTextField();
            input_address.setBounds(200, 110, 150, 20);
            fen.add(input_address);
            input_city = new JTextField();
            input_city.setBounds(200, 140, 150, 20);
            fen.add(input_city);
            input_description = new JTextField();
            input_description.setBounds(200, 170, 150, 20);
            fen.add(input_description);
            input_superficie = new JTextField();
            input_superficie.setBounds(200, 200, 150, 20);
            fen.add(input_superficie);
            input_surfaceTerrain = new JTextField();
            input_surfaceTerrain.setBounds(200, 230, 150, 20);
            fen.add(input_surfaceTerrain);
            input_dependance = new JTextField();
            input_dependance.setBounds(200, 260, 150, 20);
            fen.add(input_dependance);
            input_photo = new JTextField();
            input_photo.setBounds(200, 290, 150, 20);
            fen.add(input_photo);
            input_nbPiece = new JTextField();
            input_nbPiece.setBounds(200, 320, 150, 20);
            fen.add(input_nbPiece);
            input_nbEtage = new JTextField();
            input_nbEtage.setBounds(200, 350, 150, 20);
            fen.add(input_nbEtage);
            input_nbChambre = new JTextField();
            input_nbChambre.setBounds(200, 380, 150, 20);
            fen.add(input_nbChambre);
            input_owner = new JTextField();
            input_owner.setBounds(200, 410, 150, 20);
            fen.add(input_owner);
            
            /** bouton ajouter */
            ajout = new JButton("Ajouter");
            ajout.setBounds(130, 460, 150, 20);
            ajout.addActionListener(this);
            fen.add(ajout);

            /** met en visible */
            fen.setVisible(true);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erreur ajout bien : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String requete = "INSERT INTO bien (categorie, title, prix, address, city, description, superficie, surfaceTerrain, dependance, photo, nbPiece, nbEtage, nbChambre, owner) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = connect.getConnect().prepareStatement(requete);

            ps.setString(1, input_categorie.getText());
            ps.setString(2, input_title.getText());
            ps.setInt(3, Integer.valueOf(input_prix.getText()));
            ps.setString(4, input_address.getText());
            ps.setString(5, input_city.getText());
            ps.setString(6, input_description.getText());
            ps.setInt(7, Integer.valueOf(input_superficie.getText()));
            ps.setInt(8, Integer.valueOf(input_surfaceTerrain.getText()));
            ps.setInt(9, Integer.valueOf(input_dependance.getText()));
            ps.setString(10, input_photo.getText());
            ps.setInt(11, Integer.valueOf(input_nbPiece.getText()));
            ps.setInt(12, Integer.valueOf(input_nbEtage.getText()));
            ps.setInt(13, Integer.valueOf(input_nbChambre.getText()));
            ps.setString(14, input_owner.getText());
            
            ps.executeUpdate();
            
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erreur ajout agence : " + e.getMessage());
        }
    }
}