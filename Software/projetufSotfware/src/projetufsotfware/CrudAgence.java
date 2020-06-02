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
 * cette classe sert a modifier les informations concernant les agences
 */

public class CrudAgence implements ActionListener {
    private PreparedStatement ps;
    private Connexion connect;
    private RechercherAgence searchA;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel numero;
    private JLabel ville;
    private JLabel nbAgent;
    
    private JTextField input_numero;
    private JTextField input_ville;
    private JTextField input_nbAgent;
    
    private JButton edit;
    private JButton supp;
    
    public CrudAgence(Connexion cc, RechercherAgence searchA, String nm, String pre) throws SQLException {
        this.connect = cc;
        try {
            String query = "SELECT * FROM agence WHERE number='"+nm+"' AND city='"+pre+"';";
            //System.out.println("query : " + query);
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery(query);
            set.next();
            
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Informations de l'agence");
            fen.setSize(400, 200);
            fen.setLayout(null);

            /** les labels et textfield pour rentrer les informations */
            numero = new JLabel("Numero d'agence (AG/VILLE/01) : ");
            numero.setBounds(10, 20, 150, 20);
            fen.add(numero);
            ville = new JLabel("Ville : ");
            ville.setBounds(10, 50, 150, 20); 
            fen.add(ville);
            nbAgent = new JLabel("Nombre d'agent : ");
            nbAgent.setBounds(10, 80, 200, 20);
            fen.add(nbAgent);
            
            input_numero = new JTextField(set.getString("number"));
            input_numero.setBounds(200, 20, 150, 20);
            fen.add(input_numero);
            input_ville = new JTextField(set.getString("city"));
            input_ville.setBounds(200, 50, 150, 20);
            fen.add(input_ville);
            input_nbAgent = new JTextField(set.getString("nbAgent"));
            input_nbAgent.setBounds(200, 80, 150, 20);
            fen.add(input_nbAgent);
            
            /** bouton modifier et supprimer */
            edit = new JButton("Modifier");
            edit.setBounds(50, 120, 100, 20);
            edit.addActionListener(this);
            fen.add(edit);
            
            supp = new JButton("Supprimer");
            supp.setBounds(190, 120, 100, 20);
            supp.addActionListener(this);
            fen.add(supp);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du menu crud agence : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** si le clic provient du bouton modifier alors ça provoquera la premiere fonction sinon c'est la deuxieme */
            if ( event.getSource() == edit ) {
                String nb = input_numero.getText();
                String cy = input_ville.getText();
                int nba = Integer.valueOf(input_nbAgent.getText());
                
                ModifierA (nb, cy, nba);
            }
            if ( event.getSource() == supp ) {
                String nb = input_numero.getText();
                String cy = input_ville.getText();
                
                SupprimerA (nb, cy);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur des boutons : " + e.getMessage());
        }
    }    
    
    /** fonction pour modifier les informations rentrees */
    public void ModifierA (String nb, String cy, int nba) throws SQLException {
        try {
            String requete = "UPDATE agence SET city='"+cy+"', nbAgent="+nba+" WHERE number="+nb+";";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            /** ferme la fenetre actuelle apres la realisation de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la modification agence : " + e.getMessage());
        }
    }    
    
    /** fonction pour supprimer les informations que l'on ai en train de regarder */
    public void SupprimerA (String nb, String cy) throws SQLException {
        try {
            String requete = "DELETE FROM agence WHERE number='"+nb+"' AND city ='"+cy+"';";
            ps = connect.getConnect().prepareStatement(requete);
            
            ps.executeUpdate();
            /** ferme la fenetre actuelle apres la realisation de la requete */
            fen.dispose();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de la suppression agence : " + e.getMessage());
        }
    }   
}