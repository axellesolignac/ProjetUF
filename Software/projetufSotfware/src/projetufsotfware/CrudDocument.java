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
 * cette classe sert a modifier et supprimer les informations concernant des documents recherches
 */

public class CrudDocument implements ActionListener {
    private Connexion connect;
    private PreparedStatement ps;
    private RechercherDocument searchD;
    private ResultSet set;
    private JFrame fen;
    
    private JLabel title;
    private JLabel type;
    private JLabel contenu;
    
    private JTextField input_title;
    private JTextField input_type;
    private JTextField input_contenu;
    
    private JButton edit;
    private JButton supp;
    
    public CrudDocument (Connexion cc, RechercherDocument searchD, String nm, String pre) throws SQLException {
        this.connect = cc;
        
        try {
            String query = "SELECT * FROM document d JOIN client c ON d.id_client = c.id WHERE type='"+nm+"' AND c.lastname='"+pre+"';";
            //System.out.println("query : " + query);
            ps = connect.getConnect().prepareStatement(query);
            set = ps.executeQuery(query);
            set.next();
            
            /** construction fenetre */
            fen = new JFrame();
            fen.setTitle("Informations du document ");
            fen.setSize(420, 200);
            fen.setLayout(null);
            
            /** les labels et inputs */
            title = new JLabel("Title : ");
            title.setBounds(10, 20, 150, 20);
            fen.add(title);
            type = new JLabel("Type : ");
            type.setBounds(10, 50, 150, 20); 
            fen.add(type);
            contenu = new JLabel("Contenu : ");
            contenu.setBounds(10, 80, 150, 20);
            fen.add(contenu);

            
            input_title = new JTextField(set.getString("title"));
            input_title.setBounds(200, 20, 150, 20);
            fen.add(input_title);
            input_type = new JTextField(set.getString("type"));
            input_type.setBounds(200, 50, 150, 20);
            fen.add(input_type);
            input_contenu = new JTextField(set.getString("contenu"));
            input_contenu.setBounds(200, 80, 150, 20);
            fen.add(input_contenu);

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
            System.out.println("Erreur recherche bien : " + e.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            /** depend de l'origine du clic  */
            if ( event.getSource() == edit ) {
                int id = set.getInt("id");
                String ti = input_title.getText();
                String ty = input_type.getText();
                String co = input_contenu.getText();
                
                ModifierD (id, ti, ty, co);
            }
            if ( event.getSource() == supp ) {
                String ti = input_title.getText();
                int id = set.getInt("id");
                
                SupprimerD (ti, id);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur pour les boutons : " + e.getMessage());
        }
    }
    
    /** fonction pour modifier un document */
    public void ModifierD (int id, String ti, String ty, String co) throws SQLException {
        try {
            String requete = "UPDATE document SET title='"+ti+"', type='"+ty+"', contenu='"+co+"' WHERE id="+id+";";
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

    /** fonction pour supprimer un document */
    public void SupprimerD (String ti, int id) throws SQLException {
        try {
            String requete = "DELETE FROM document WHERE title='"+ti+"' AND id ='"+id+"';";
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