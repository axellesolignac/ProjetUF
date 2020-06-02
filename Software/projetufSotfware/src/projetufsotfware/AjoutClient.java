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
 * cette classe sert a ajouter un client
 */

public class AjoutClient implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private JFrame fen;
    
    private JTextField input_username;
    private JTextField input_password;
    private JTextField input_lastname;
    private JTextField input_firstname;
    private JTextField input_email;
    private JTextField input_gender;
    private JTextField input_birthdate;
    private JTextField input_phone;
    private JTextField input_address;
    private JTextField input_city;
    private JTextField input_nationality;
    
    private JLabel username;
    private JLabel password;
    private JLabel lastname;
    private JLabel firstname;
    private JLabel gender;
    private JLabel email;
    private JLabel phone;
    private JLabel address;
    private JLabel birthdate;
    private JLabel city;
    private JLabel nationality;
    

    public AjoutClient(Connexion cc) throws SQLException {
        this.connect = cc;
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Ajout d'un client");
            fen.setSize(400, 450);
            //fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fen.setLayout(null);

            /** construction des labels */
            username = new JLabel("Identifiant : ");
            username.setBounds(10, 20, 150, 20);
            fen.add(username);
            password = new JLabel("Mot de passe : ");
            password.setBounds(10, 50, 150, 20);
            fen.add(password);
            lastname = new JLabel("Nom : ");
            lastname.setBounds(10, 80, 150, 20);
            fen.add(lastname);
            firstname = new JLabel("Prenom : ");
            firstname.setBounds(10, 110, 150, 20); 
            fen.add(firstname);
            gender = new JLabel("Sexe : ");
            gender.setBounds(10, 140, 150, 20);
            fen.add(gender);
            birthdate = new JLabel("Date de naissance (AAAA/MM/DD) : ");
            birthdate.setBounds(10, 170, 200, 20);
            fen.add(birthdate);
            phone = new JLabel("Telephone : ");
            phone.setBounds(10, 200, 150, 20);
            fen.add(phone);
            email = new JLabel("Email");
            email.setBounds(10, 230, 150, 20);
            fen.add(email);
            address = new JLabel("Adresse : ");
            address.setBounds(10, 260, 150, 20); 
            fen.add(address);
            city = new JLabel("Ville : ");
            city.setBounds(10, 290, 150, 20);
            fen.add(city);
            nationality = new JLabel("Nationalite : ");
            nationality.setBounds(10, 320, 150, 20);
            fen.add(nationality);

            /** construction de textfield */
            input_username = new JTextField();
            input_username.setBounds(220, 20, 150, 20);
            fen.add(input_username);
            input_password = new JTextField();
            input_password.setBounds(220, 50, 150, 20);
            fen.add(input_password);
            input_lastname = new JTextField();
            input_lastname.setBounds(220, 80, 150, 20);
            fen.add(input_lastname);
            input_firstname = new JTextField();
            input_firstname.setBounds(220, 110, 150, 20);
            fen.add(input_firstname);
            input_gender = new JTextField();
            input_gender.setBounds(220, 140, 150, 20);
            fen.add(input_gender);
            input_birthdate = new JTextField();
            input_birthdate.setBounds(220, 170, 150, 20);
            fen.add(input_birthdate);
            input_phone = new JTextField();
            input_phone.setBounds(220, 200, 150, 20);
            fen.add(input_phone);
            input_email = new JTextField();
            input_email.setBounds(220, 230, 150, 20);
            fen.add(input_email);
            input_address = new JTextField();
            input_address.setBounds(220, 260, 150, 20);
            fen.add(input_address);
            input_city = new JTextField();
            input_city.setBounds(220, 290, 150, 20);
            fen.add(input_city);
            input_nationality = new JTextField();
            input_nationality.setBounds(220, 320, 150, 20);
            fen.add(input_nationality);

            /** bouton ajouter */
            JButton ajout = new JButton("Ajouter");
            ajout.addActionListener(this);
            ajout.setBounds(130, 350, 78, 20);
            fen.add(ajout);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton action : " + e.getMessage());
        }
    }
    
    @Override
    /** Quand on clique sur le bouton 'ajouter', ça s'ajoute dans la bdd */
    public void actionPerformed(ActionEvent evt) {
        try {
            String requete = "INSERT INTO client (username, password, lastname, firstname, gender, birthdate, phone, email, address, city, nationality) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.setString(1, input_username.getText());
            ps.setString(2, input_password.getText());
            ps.setString(3, input_lastname.getText());
            ps.setString(4, input_firstname.getText());
            ps.setString(5, input_gender.getText());
            ps.setDate(6, Date.valueOf(input_birthdate.getText()));
            ps.setInt(7, Integer.valueOf(input_phone.getText()));
            ps.setString(8, input_email.getText());
            ps.setString(9, input_address.getText());
            ps.setString(10, input_city.getText());
            ps.setString(11, input_nationality.getText());
            
            ps.executeUpdate();
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour le bouton action : " + e.getMessage());
        }
    }
}