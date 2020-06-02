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
 * cette classe sert a ajouter une agence dans la base de donnees
 */

public class AjoutAgence implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private JFrame fen;
    
    private JTextField input_numero;
    private JTextField input_ville;
    private JTextField input_agent;
    
    private JLabel numero;
    private JLabel ville;
    private JLabel agent;

    private JButton ajout;
    
    public AjoutAgence(Connexion cc) throws SQLException {
        this.connect = cc;
        
        try {
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Ajouter une agence");
            fen.setSize(450, 230);
            fen.setLayout(null);
            
            /** les labels et textfield afin de rentrer des informations */
            numero = new JLabel("Numero d'agence (AG/VILLE/01) : ");
            numero.setBounds(10, 20, 250, 20);
            fen.add(numero);
            ville = new JLabel("Ville : ");
            ville.setBounds(10, 50, 80, 20); 
            fen.add(ville);
            agent = new JLabel("Nombre d'agent : ");
            agent.setBounds(10, 80, 200, 20);
            fen.add(agent);

            input_numero = new JTextField();
            input_numero.setBounds(260, 20, 150, 20);
            fen.add(input_numero);
            input_ville = new JTextField();
            input_ville.setBounds(260, 50, 150, 20);
            fen.add(input_ville);
            input_agent = new JTextField();
            input_agent.setBounds(260, 80, 150, 20);
            fen.add(input_agent);

            /** bouton ajouter */
            ajout = new JButton("Ajouter");
            ajout.setBounds(150, 120, 150, 20);
            ajout.addActionListener(this);
            fen.add(ajout);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur ajout agence : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String requete = "INSERT INTO agence (number, city, nbAgent) VALUES (?, ?, ?);";
            ps = connect.getConnect().prepareStatement(requete);

            ps.setString(1, input_numero.getText());
            ps.setString(2, input_ville.getText());
            ps.setInt(3, Integer.valueOf(input_agent.getText()));

            ps.executeUpdate();
            
            /** ferme la fenetre apres l'execution de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur ajout agence : " + e.getMessage());
        }
    }
}