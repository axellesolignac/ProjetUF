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
 * cette classe sert de menu au administrateur
*/

public class EspaceAdministrateur implements ActionListener {
    private Connexion connect;
    
    private JButton agence;
    private JButton agent;
    private JButton compte;
    private JButton affect;
    private int id_agent;
    
    public EspaceAdministrateur(Connexion cc, int id) throws SQLException{
        this.connect = cc;
	this.id_agent = id;
        
        try {
            /** construction de la fenetre */
            JFrame fen = new JFrame();
            fen.setTitle("Espace Administrateur");
            fen.setSize(370, 210);
            
            /** arrete le programme apres le lancement et la realisation de la requete */
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fen.setLayout(null);

            /** bouton pour le menu de gestion des agences */
            agence = new JButton("Gestion agence");
            agence.setBounds(10, 20, 150, 40);
            agence.addActionListener(this);
            fen.add(agence);

            /** bouton gestion agents */
            agent = new JButton("Gestion agent");
            agent.setBounds(10, 70, 150, 40);
            agent.addActionListener(this);
            fen.add(agent);

            /** bouton preferences comptes */
            compte = new JButton("Mon compte");
            compte.setBounds(190, 20, 150, 40);
            compte.addActionListener(this);
            fen.add(compte);

            /** bouton d'affectation de bien a un agent */
            affect = new JButton("Affectation");
            affect.setBounds(190, 70, 150, 40);
            affect.addActionListener(this);
            fen.add(affect);

            /** met en visible */
            fen.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du menu admin : " + e.getMessage());
        }
    }
	
    @Override
    public void actionPerformed(ActionEvent event) {
    	try {
            /** depend de l'origine du clic */
            if ( event.getSource() == agence ) {
               GestionAgence cac = new GestionAgence(connect);
            }
            else if ( event.getSource() == agent ) {
                GestionEmploye aat = new GestionEmploye(connect);
            }
            else if ( event.getSource() == compte ) {
                MonCompte mc = new MonCompte(connect, id_agent);
            }
            else if ( event.getSource() == affect ) {
                RechercherAffectation ra = new RechercherAffectation(connect);
            }
            else {
                System.out.println("Erreur dans les boutons");
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur du bouton : " + e.getMessage());
        }       
    }
}