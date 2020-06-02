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
 * cette classe sert a modifier ou supprimer un bien dans sa totatite
 */

public class CrudBien implements ActionListener {
    private Connexion connect;
    private RechercherBien searchB;
    private PreparedStatement ps;
    private ResultSet set;
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
    private JTextField input_status;
    
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
    private JLabel status;
    
    private JButton edit;
    private JButton supp;
    
    public CrudBien (Connexion cc, RechercherBien searchB, String nm, String pre) throws SQLException {
        this.connect = cc;
        try {
            String query = "SELECT * FROM bien WHERE title='"+nm+"' AND owner='"+pre+"';";
            //System.out.println("query : " + query);
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery(query);
            set.next();
            
            /** Construction fenetre */
            fen = new JFrame();
            fen.setTitle("Informations du bien");
            fen.setSize(400, 600);
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
            surfaceTerrain.setBounds(10, 230, 200, 20); 
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
            owner = new JLabel("Proprietaire (nom) : ");
            owner.setBounds(10, 410, 150, 20);
            fen.add(owner);
            status = new JLabel("Statut : ");
            status.setBounds(10, 440, 150, 20);
            fen.add(status);

            input_categorie = new JTextField(set.getString("categorie"));
            input_categorie.setBounds(200, 20, 150, 20);
            fen.add(input_categorie);
            input_title = new JTextField(set.getString("title"));
            input_title.setBounds(200, 50, 150, 20);
            fen.add(input_title);
            input_prix = new JTextField(set.getString("prix"));
            input_prix.setBounds(200, 80, 150, 20);
            fen.add(input_prix);
            input_address = new JTextField(set.getString("address"));
            input_address.setBounds(200, 110, 150, 20);
            fen.add(input_address);
            input_city = new JTextField(set.getString("city"));
            input_city.setBounds(200, 140, 150, 20);
            fen.add(input_city);
            input_description = new JTextField(set.getString("description"));
            input_description.setBounds(200, 170, 150, 20);
            fen.add(input_description);
            input_superficie = new JTextField(set.getString("superficie"));
            input_superficie.setBounds(200, 200, 150, 20);
            fen.add(input_superficie);
            input_surfaceTerrain = new JTextField(set.getString("surfaceTerrain"));
            input_surfaceTerrain.setBounds(200, 230, 150, 20);
            fen.add(input_surfaceTerrain);
            input_dependance = new JTextField(set.getString("dependance"));
            input_dependance.setBounds(200, 260, 150, 20);
            fen.add(input_dependance);
            input_photo = new JTextField(set.getString("photo"));
            input_photo.setBounds(200, 290, 150, 20);
            fen.add(input_photo);
            input_nbPiece = new JTextField(set.getString("nbPiece"));
            input_nbPiece.setBounds(200, 320, 150, 20);
            fen.add(input_nbPiece);
            input_nbEtage = new JTextField(set.getString("nbEtage"));
            input_nbEtage.setBounds(200, 350, 150, 20);
            fen.add(input_nbEtage);
            input_nbChambre = new JTextField(set.getString("nbChambre"));
            input_nbChambre.setBounds(200, 380, 150, 20);
            fen.add(input_nbChambre);
            input_owner = new JTextField(set.getString("owner"));
            input_owner.setBounds(200, 410, 150, 20);
            fen.add(input_owner);
            input_status = new JTextField(set.getString("status"));
            input_status.setBounds(200, 440, 150, 20);
            fen.add(input_status);
            
            /** bouton modifier et supprimer */
            edit = new JButton("Modifier");
            edit.setBounds(50, 490, 100, 30);
            edit.addActionListener(this);
            fen.add(edit);
            supp = new JButton("Supprimer");
            supp.setBounds(190, 490, 100, 30);
            supp.addActionListener(this);
            fen.add(supp);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du menu crud client : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** le choix depend de la source du clic */
            if ( event.getSource() == edit ) {
                int id = set.getInt("id");
                String ca = input_categorie.getText();
                String ti = input_title.getText();
                int px = Integer.valueOf(input_prix.getText());
                String ad = input_address.getText();
                String cy = input_city.getText();
                String ds = input_description.getText();
                int sup = Integer.valueOf(input_superficie.getText());
                int sut = Integer.valueOf(input_surfaceTerrain.getText());
                int de = Integer.valueOf(input_dependance.getText());
                String ph = input_photo.getText();
                int nbP = Integer.valueOf(input_nbPiece.getText());
                int nbE = Integer.valueOf(input_nbEtage.getText());
                int nbC = Integer.valueOf(input_nbChambre.getText());
                String ow = input_owner.getText();
                
                Modifier (id, ca, ti, px, ad, cy, ds, sup, sut, de, ph, nbP, nbE, nbC, ow);
            }
            if ( event.getSource() == supp ) {
                int id = set.getInt("id");
                String ti = input_title.getText();
                
                Supprimer (id, ti);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons : " + e.getMessage());
        }
    }
    
    /** fonction pour modifier avec les donnees rentrees */
    public void Modifier (int id, String ca, String ti, int px, String ad, String cy, String ds, int sup, int sut, int de, String ph, int nbP, int nbE, int nbC, String ow) throws SQLException {
        try {
            String requete = "UPDATE bien SET categorie='"+ca+"', title='"+ti+"', prix="+px+", address='"+ad+"', city='"+cy+"', description='"+ds+"', superficie="+sup+", surfaceTerrain="+sut+", dependance="+de+", photo='"+ph+"', nbPiece="+nbP+", nbEtage="+nbE+", nbChambre="+nbC+", owner='"+ow+"' WHERE id="+id+";";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la modification : " + e.getMessage());
        }
    }
    
    /** fonction pour supprimer la ligne dans la bdd  */
    public void Supprimer (int id, String ti) throws SQLException {
        try {
            String requete = "DELETE FROM bien WHERE id="+id+" AND title='"+ti+"';";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la suppression : " + e.getMessage());
        }
    }
}