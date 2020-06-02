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
 * cette classe sert à modifier et supprimer les agents immobilier et à les lier à une agence
 */

public class CrudEmploye implements ActionListener {
    private Connexion connect;
    private RechercherEmploye searchE;
    private PreparedStatement ps;
    private ResultSet set;
    private int id;
    private JFrame fen;
  
    private JTextField input_lastname;
    private JTextField input_firstname;
    private JTextField input_status;
    private JTextField input_gender;
    private JTextField input_email;
    private JTextField input_agence;
    private JTextField input_password;
    
    private JLabel lastname;
    private JLabel firstname;
    private JLabel status;
    private JLabel gender;
    private JLabel email;
    private JLabel agence;
    private JLabel password;
    
    private JButton edit;
    private JButton supp;
    
    
    public CrudEmploye(Connexion cc, RechercherEmploye searchE, String nm, String pre) throws SQLException {
        this.connect = cc;
        try {
            String query = "SELECT * FROM employe WHERE lastname='"+nm+"' AND firstname='"+pre+"';";
            //System.out.println("query : " + query);
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery(query);
            set.next();
            
            /* construction fenetre */
            fen = new JFrame();
            fen.setTitle("Informations de l'employe");
            fen.setSize(420, 330);
            fen.setLayout(null);

            /** les labels et inputs */
            lastname = new JLabel();
            lastname.setText("Nom : ");
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
            email.setBounds(10, 140, 150, 20);
            fen.add(email);
            agence = new JLabel("Agence : ");
            agence.setBounds(10, 170, 150, 20); 
            fen.add(agence);
            password = new JLabel("Mot de passe : ");
            password.setBounds(10, 200, 150, 20);
            fen.add(password);
            
            input_lastname = new JTextField(set.getString("lastname"));
            input_lastname.setBounds(200, 20, 150, 20);
            fen.add(input_lastname);
            input_firstname = new JTextField(set.getString("firstname"));
            input_firstname.setBounds(200, 50, 150, 20);
            fen.add(input_firstname);
            input_status = new JTextField(set.getString("status"));
            input_status.setBounds(200, 80, 150, 20);
            fen.add(input_status);
            input_gender = new JTextField(set.getString("gender"));
            input_gender.setBounds(200, 110, 150, 20);
            fen.add(input_gender);
            input_email = new JTextField(set.getString("email"));
            input_email.setBounds(200, 140, 150, 20);
            fen.add(input_email);
            input_agence = new JTextField(set.getString("agence"));
            input_agence.setBounds(200, 170, 150, 20);
            fen.add(input_agence);
            input_password = new JTextField(set.getString("password"));
            input_password.setBounds(200, 200, 150, 20);
            fen.add(input_password);
            
            /** bouton modifier et supprimer */
            edit = new JButton("Modifier");
            edit.setBounds(50, 240, 100, 20);
            edit.addActionListener(this);
            fen.add(edit);
            
            supp = new JButton("Supprimer");
            supp.setBounds(190, 240, 100, 20);
            supp.addActionListener(this);
            fen.add(supp);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du menu crud : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** si l'origine du clic viens de Modifier, alors ça entrainera la fonction modifier avec les informations sinon ça fera supprimer */
            
            if ( event.getSource() == edit ) {
                id = set.getInt("id_agent");
                String ln = input_lastname.getText();
                String fn = input_firstname.getText();
                String st = input_status.getText();
                String sx = input_gender.getText();
                String em = input_email.getText();
                String ag = input_agence.getText();
                String psw = input_password.getText();
                
                ModifierE (id, ln, fn, st, sx, em, ag, psw);
            }
            else if ( event.getSource() == supp ) {
                String ln = input_lastname.getText();
                String fn = input_firstname.getText();
                
                SupprimerE (ln, fn);
            }
            else {
                System.out.println("Erreur ");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons : " + e.getMessage());
        }
    }
    
    /** fonction pour modifier les elements de la table selon les informations rentrees */
    public void ModifierE (int id, String ln, String fn, String st, String sx, String em, String ag, String psw) throws SQLException {
        try {
            String requete = "UPDATE employe SET password='"+psw+"', lastname='"+ln+"', firstname='"+fn+"', status='"+st+"', gender='"+sx+"', email='"+em+"', agence='"+ag+"' WHERE id_agent="+id+";";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            
            /** ferme la fenetre actuelle apres de la realisation de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la modification : " + e.getMessage());
        }
    }
    
    /** fonction pour supprimer les elements de la table contenant les informations recuperees */
    public void SupprimerE (String ln, String fn) throws SQLException {
        try {
            String requete = "DELETE FROM employe WHERE lastname='"+ln+"' AND firstname ='"+fn+"';";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            
            /** ferme la fenetre actuelle apres de la realisation de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la suppression : " + e.getMessage());
        }
    }
}