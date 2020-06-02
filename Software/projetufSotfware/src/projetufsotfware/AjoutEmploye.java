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
 * cette classe sert a ajouter un employe, qu'il soit admin ou agent
 */

public class AjoutEmploye implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private JFrame fen;
    
    private JTextField input_lastname;
    private JTextField input_firstname;
    private JTextField input_status;
    private JTextField input_gender;
    private JTextField input_email;
    private JTextField input_agence;
    private JPasswordField input_password;

    private JLabel lastname;
    private JLabel firstname;
    private JLabel status;
    private JLabel gender; 
    private JLabel email;
    private JLabel agence;
    private JLabel password;
    
    private JButton ajout;
    
    public AjoutEmploye(Connexion cc) throws SQLException {
        this.connect = cc;
        
        /** construction fenetre */
        fen = new JFrame();
        fen.setTitle("Ajouter un employe");
        fen.setSize(370, 350);
        fen.setLayout(null);

        /** construction des labels et inputs */
        lastname = new JLabel("Nom : ");
        lastname.setBounds(10, 20, 50, 20);
        fen.add(lastname);
        firstname = new JLabel("Prenom : ");
        firstname.setBounds(10, 50, 80, 20); 
        fen.add(firstname);
        status = new JLabel("Statut : ");
        status.setBounds(10, 80, 80, 20);
        fen.add(status);
        gender = new JLabel("Sexe : ");
        gender.setBounds(10, 110, 80,20);
        fen.add(gender);
        email = new JLabel("Email : ");
        email.setBounds(10, 140, 80, 20); 
        fen.add(email);
        agence = new JLabel("Agence : ");
        agence.setBounds(10, 170, 80, 20);
        fen.add(agence);
        password = new JLabel("Mot de passe : ");
        password.setBounds(10, 200, 150, 20);
        fen.add(password);


        input_lastname = new JTextField();
        input_lastname.setBounds(150, 20, 150, 20);
        fen.add(input_lastname);
        input_firstname = new JTextField();
        input_firstname.setBounds(150, 50, 150, 20);
        fen.add(input_firstname);
        input_status = new JTextField();
        input_status.setBounds(150, 80, 150, 20);
        fen.add(input_status);
        input_gender = new JTextField();
        input_gender.setBounds(150, 110, 150, 20);
        fen.add(input_gender);
        input_email = new JTextField();
        input_email.setBounds(150, 140, 150, 20);
        fen.add(input_email);
        input_agence = new JTextField();
        input_agence.setBounds(150, 170, 150, 20);
        fen.add(input_agence);
        input_password = new JPasswordField();
        input_password.setBounds(150, 200, 150, 20);
        fen.add(input_password);

        /** bouton ajouter */
        ajout = new JButton("Ajouter");
        ajout.setBounds(100, 230, 150, 20);
        ajout.addActionListener(this);
        fen.add(ajout);

        /** met en visible */
        fen.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String requete = "INSERT INTO employe (password, lastname, firstname, status, gender, email, agence) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.setString(1, String.valueOf(input_password.getPassword()));
            ps.setString(2, input_lastname.getText());
            ps.setString(3, input_firstname.getText());
            ps.setInt(4, Integer.valueOf(input_status.getText()));
            ps.setString(5, input_gender.getText());
            ps.setString(6, input_email.getText());
            ps.setString(7, input_agence.getText());

            ps.executeUpdate();
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur gestion employe : " + e.getMessage());
        }
    }
}