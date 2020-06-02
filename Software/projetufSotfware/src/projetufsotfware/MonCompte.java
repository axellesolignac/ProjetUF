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

/**
 *
 * @author Equipe B2B - B
 * cette classe sert a gérer les informations lies au compte de l'agent qui est connecte
 */

public class MonCompte implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private PreparedStatement pst;
    private JFrame fen;
    private ResultSet result;
    private ResultSet rst;
    
    private JLabel lastname;
    private JLabel firstname;
    private JLabel status;
    private JLabel gender;
    private JLabel email;
    private JLabel agence;
    private JLabel nbVendeur;
    private JLabel nbBienVente;
    private JLabel nbBienVendu;
    private JLabel password;
    
    private JTextField input_lastname;
    private JTextField input_firstname;
    private JTextField input_status;
    private JTextField input_gender;
    private JTextField input_email;
    private JTextField input_agence;
    private JTextField input_nbVendeur;
    private JTextField input_nbBienVente;
    private JTextField input_nbBienVendu;
    private JTextField input_password;
    
    private JButton edit;
    private int id_agent;
    
    public MonCompte(Connexion cc, int id) throws SQLException {
        this.connect = cc;
        this.id_agent = id;
        
        try {
            /** Construction fenetre */
            fen = new JFrame();
            fen.setTitle("Mon compte");
            fen.setSize(420, 420);
            fen.setLayout(null);

            /** requete sql pour ressortir les informations */
            String requete = "SELECT * FROM employe WHERE id_agent="+id+";";
            ps = connect.getConnect().prepareStatement(requete);
            result = ps.executeQuery(requete);
            result.next();
            
            String request = "SELECT COUNT(b.status) as nombre FROM bien b JOIN client c ON b.owner = c.lastname JOIN employe e ON c.id_agent = e.id_agent WHERE b.status=\"Vendu\" AND e.id_agent=6;";
            pst = connect.getConnect().prepareStatement(request);
            rst = pst.executeQuery(request);
            rst.next();
            
            /** les labels et inputs */
            lastname = new JLabel("Nom : ");
            lastname.setBounds(10, 20, 150, 20);
            fen.add(lastname);
            firstname = new JLabel("Prenom : ");
            firstname.setBounds(10, 50, 150, 20); 
            fen.add(firstname);
            status = new JLabel("Statut : ");
            status.setBounds(10, 80, 150, 20); 
            fen.add(status);
            gender = new JLabel("Sexe : ");
            gender.setBounds(10, 110, 150, 20); 
            fen.add(gender);
            email = new JLabel("Email : ");
            email.setBounds(10, 140, 200, 20); 
            fen.add(email);
            agence = new JLabel("Agence : ");
            agence.setBounds(10, 170, 280, 20); 
            fen.add(agence);
            nbVendeur = new JLabel("Nombre de vendeur geres : ");
            nbVendeur.setBounds(10, 200, 180, 20); 
            fen.add(nbVendeur);
            nbBienVente = new JLabel("Nombre de bien en vente geres : ");
            nbBienVente.setBounds(10, 230, 180, 20); 
            fen.add(nbBienVente);
            nbBienVendu = new JLabel("Nombre total de bien vendus : ");
            nbBienVendu.setBounds(10, 260, 180, 20); 
            fen.add(nbBienVendu);
            password = new JLabel("Mot de passe : ");
            password.setBounds(10, 290, 180, 20); 
            fen.add(password);
            

            input_lastname = new JTextField(result.getString("lastname"));
            input_lastname.setBounds(200, 20, 150, 20);
            fen.add(input_lastname);
            input_firstname = new JTextField(result.getString("firstname"));
            input_firstname.setBounds(200, 50, 150, 20);
            fen.add(input_firstname);
            input_status = new JTextField(result.getString("status"));
            input_status.setBounds(200, 80, 150, 20);
            fen.add(input_status);
            input_gender = new JTextField(result.getString("gender"));
            input_gender.setBounds(200, 110, 150, 20);
            fen.add(input_gender);
            input_email = new JTextField(result.getString("email"));
            input_email.setBounds(200, 140, 150, 20);
            fen.add(input_email);
            input_agence = new JTextField(result.getString("agence"));
            input_agence.setBounds(200, 170, 150, 20);
            fen.add(input_agence);
            input_nbVendeur = new JTextField(result.getString("nbVendeur"));
            input_nbVendeur.setBounds(200, 200, 150, 20);
            fen.add(input_nbVendeur);
            input_nbBienVente = new JTextField(result.getString("nbBienVente"));
            input_nbBienVente.setBounds(200, 230, 150, 20);
            fen.add(input_nbBienVente);
            input_nbBienVendu = new JTextField(rst.getString("nombre"));
            input_nbBienVendu.setBounds(200, 260, 150, 20);
            fen.add(input_nbBienVendu);
            input_password = new JTextField(result.getString("password"));
            input_password.setBounds(200, 290, 150, 20);
            fen.add(input_password);
            
            /** bouton modifier */
            edit = new JButton("Modifier");
            edit.setBounds(130, 330, 100, 20);
            edit.addActionListener(this);
            fen.add(edit);
            
            /** met en visible la page */
            fen.setVisible(true);               
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec pour la page du compte");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            id_agent = result.getInt("id_agent");
            String ln = input_lastname.getText();
            String fn = input_firstname.getText();
            int st = Integer.valueOf(input_status.getText());
            String sx = input_gender.getText();
            String em = input_email.getText();
            String ag = input_agence.getText();
            int nbv = Integer.valueOf(input_nbVendeur.getText());
            int nbvt = Integer.valueOf(input_nbBienVente.getText());
            int nbvd = Integer.valueOf(input_nbBienVendu.getText());
            String psw = input_password.getText();
            
            String requete = "UPDATE employe SET password='"+psw+"', lastname='"+ln+"', firstname='"+fn+"', status="+st+", gender='"+sx+"', email='"+em+"', agence='"+ag+"', nbVendeur="+nbv+", nbBienVente="+nbvt+", nbBienVendu="+nbvd+" WHERE id_agent="+id_agent+";";
            ps = connect.getConnect().prepareStatement(requete);
            ps.executeUpdate();
            
            /** ferme la fenetre actuelle lorsque la requete est realisee */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton modifie : " + e.getMessage());
        }
    }   
}