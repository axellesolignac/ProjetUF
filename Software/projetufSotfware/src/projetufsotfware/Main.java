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
 * cette classe sert de page d'authentification des employes afin de pouvoir rentrer dans l'application.
 */

public class Main extends JFrame implements ActionListener {
    private PreparedStatement ps;
    private Connexion connect;
    private ResultSet set;
    
    private JButton button;
    private JFrame fen;
    
    private JTextField input_identifiant;
    private JPasswordField input_password;
    
    private JLabel identifiant;
    private JLabel password;
    private int stat;
    private int id;
    
    public Main(Connexion cc) throws SQLException{
        this.connect = cc;
        try {
            /** Fenetre pour afficher l'authentification */
            fen = new JFrame();
            fen.setTitle("Authentification");
            fen.setSize(350, 250);
            fen.setLayout(null);

            /** les input pour rentrer l'identifiant et le mot de passe*/
            identifiant = new JLabel("Adresse email :");
            identifiant.setBounds(90, 20, 100, 20);
            fen.add(identifiant);
            password = new JLabel("Mot de passe :");
            password.setBounds(90, 75, 100, 20);
            fen.add(password);

            input_identifiant = new JTextField();
            input_identifiant.setBounds(90, 45, 150, 20);
            fen.add(input_identifiant);
            input_password = new JPasswordField();
            input_password.setBounds(90, 95, 150, 20);
            fen.add(input_password);

            /** Bouton de connexion */
            button = new JButton("Se connecter");
            button.setBounds(90, 125, 150, 40);
            button.addActionListener(this);
            fen.add(button);

            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton : " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    	try {
            String mail = input_identifiant.getText();
            String passwd = input_password.getText();
            
            VerificationAuth(mail, passwd);
    	}
    	catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton : " + e.getMessage());
        }
    }

    /** fonction qui vérifie si les informations rentrées */
    public void VerificationAuth (String mail, String passwd) {
        try {
            //System.out.println("dans verifAuth");
            String request = "SELECT * FROM employe WHERE password='"+passwd+"' AND email='"+mail+"';";
            ps = connect.getConnect().prepareStatement(request);
            set = ps.executeQuery(request);
            set.next();
            
            //System.out.println(mail + " ; " + passwd);
            
            id = set.getInt("id_agent");
            //System.out.println("id : " + id);
            stat = set.getInt("status");
            //System.out.println("status : " + stat);
            
            
            if (stat == 0) {
                MenuEmploye me = new MenuEmploye(connect, id);
                /** ferme la fenetre apres l'execution de la requete */
                fen.dispose();
            }
            else if (stat == 1) {
                EspaceAdministrateur ea = new EspaceAdministrateur(connect, id);
                /** ferme la fenetre apres l'execution de la requete */
                fen.dispose();
            } 
            else {
                System.out.println("Erreur de connection, dans l'identifiant ou le mot de passe");
            }
        }
    	catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du verifAuth : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) throws SQLException {
        /** pour se connecter a la bdd */
        Connexion cc = new Connexion();
        
        /** Creation et demarre ma fenetre */
        Main MonMenu = new Main(cc);
    }
}