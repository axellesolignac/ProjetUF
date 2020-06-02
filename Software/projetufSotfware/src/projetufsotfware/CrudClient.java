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
 * @author Utilisateur
 */

public class CrudClient implements ActionListener {
    private Connexion connect;
    private RechercherClient searchC;
    private PreparedStatement ps;
    private ResultSet set;
    private int id;
  
    /* tous les textes et cases de saisie et les boutons */
    private JTextField input_username;
    private JTextField input_password;
    private JTextField input_lastname;
    private JTextField input_firstname;
    private JTextField input_gender;
    private JTextField input_birthdate;
    private JTextField input_phone;
    private JTextField input_email;
    private JTextField input_address;
    private JTextField input_city;
    private JTextField input_nationality;
    
    private JLabel username;
    private JLabel password;
    private JLabel lastname;
    private JLabel firstname;
    private JLabel gender;
    private JLabel birthdate;
    private JLabel phone;
    private JLabel email;
    private JLabel address;
    private JLabel city;
    private JLabel nationality;
    
    private JButton edit;
    private JButton supp;
    
    
    public CrudClient(Connexion cc, RechercherClient searchC, String nm, String pre) throws SQLException {
        this.connect = cc;
        try {
            String query = "SELECT * FROM client WHERE lastname='"+nm+"' AND firstname='"+pre+"';";
            //System.out.println("query : " + query);
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery(query);
            set.next();
            
            /* Construction fenetre */
            JFrame fen = new JFrame();
            fen.setTitle("Informations du client");
            fen.setSize(400, 450);
            fen.setLayout(null);
            
            username = new JLabel("Identifiant : ");
            username.setBounds(10, 20, 150, 20);
            fen.add(username);
            password = new JLabel("Mot de passe :");
            password.setBounds(10, 50, 150, 20);
            fen.add(password);
            lastname = new JLabel();
            lastname.setText("Nom : ");
            lastname.setBounds(10, 80, 150, 20);
            fen.add(lastname);
            firstname = new JLabel("Prenom : ");
            firstname.setBounds(10, 110, 150, 20); 
            fen.add(firstname);
            gender = new JLabel("Sexe : ");
            gender.setBounds(10, 140, 150, 20);
            fen.add(gender);
            birthdate = new JLabel("Date de naissance (AAAA/MM/DD): ");
            birthdate.setBounds(10, 170, 200, 20);
            fen.add(birthdate);
            phone = new JLabel("Numero de telephone: ");
            phone.setBounds(10, 200, 150, 20); 
            fen.add(phone);
            email = new JLabel("Email : ");
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
            
            input_username = new JTextField(set.getString("username"));
            input_username.setBounds(220, 20, 150, 20);
            fen.add(input_username);
            input_password = new JTextField(set.getString("password"));
            input_password.setBounds(220, 50, 150, 20);
            fen.add(input_password);
            input_lastname = new JTextField(set.getString("lastname"));
            input_lastname.setBounds(220, 80, 150, 20);
            fen.add(input_lastname);
            input_firstname = new JTextField(set.getString("firstname"));
            input_firstname.setBounds(220, 110, 150, 20);
            fen.add(input_firstname);
            input_gender = new JTextField(set.getString("gender"));
            input_gender.setBounds(220, 140, 150, 20);
            fen.add(input_gender);
            input_birthdate = new JTextField(set.getString("birthdate"));
            input_birthdate.setBounds(220, 170, 150, 20);
            fen.add(input_birthdate);
            input_phone = new JTextField(set.getString("phone"));
            input_phone.setBounds(220, 200, 150, 20);
            fen.add(input_phone);
            input_email = new JTextField(set.getString("email"));
            input_email.setBounds(220, 230, 150, 20);
            fen.add(input_email);
            input_address = new JTextField(set.getString("address"));
            input_address.setBounds(220, 260, 150, 20);
            fen.add(input_address);
            input_city = new JTextField(set.getString("city"));
            input_city.setBounds(220, 290, 150, 20);
            fen.add(input_city);
            input_nationality = new JTextField(set.getString("nationality"));
            input_nationality.setBounds(220, 320, 150, 20);
            fen.add(input_nationality);
            
            // Bouton modifier et supprimer
            edit = new JButton("Modifier");
            edit.setBounds(50, 350, 100, 30);
            edit.addActionListener(this);
            fen.add(edit);
            
            supp = new JButton("Supprimer");
            supp.setBounds(190, 350, 100, 30);
            supp.addActionListener(this);
            fen.add(supp);

            // Met en visible
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
            if ( event.getSource() == edit ) {
                id = set.getInt("id");
                String us = input_username.getText();
                String psw = input_password.getText();
                String ln = input_lastname.getText();
                String fn = input_firstname.getText();
                String sx = input_gender.getText();
                Date bd = Date.valueOf(input_birthdate.getText());
                int tl = Integer.valueOf(input_phone.getText());
                String em = input_email.getText();
                String ad = input_address.getText();
                String cy = input_city.getText();
                String na = input_nationality.getText();
                
                Modifier(id, us, psw, ln, fn, sx, bd, tl, em, ad, cy, na);
            }
            if ( event.getSource() == supp ) {
                String ln = input_lastname.getText();
                id = set.getInt("id");
                
                Supprimer (ln, id);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons : " + e.getMessage());
        }
    }
    
    public void Modifier (int id, String us, String psw, String ln, String fn, String sx, Date bd, int tl, String em, String ad, String cy, String na) throws SQLException {
        try {
            String requete = "UPDATE client SET username='"+us+"', password='"+psw+"', lastname='"+ln+"', firstname='"+fn+"', gender='"+sx+"', birthdate='"+bd+"', phone="+tl+", email='"+em+"', address='"+ad+"', city='"+cy+"', nationality='"+na+"' WHERE id="+id+";";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la modification : " + e.getMessage());
        }
    }
    
    public void Supprimer (String ln, int id) throws SQLException {
        try {
            String requete = "DELETE FROM client WHERE lastname='"+ln+"' AND id="+id+";";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la suppression : " + e.getMessage());
        }
    }
}