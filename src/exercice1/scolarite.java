package exercice1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class scolarite extends JFrame implements ActionListener{
	JPanel pan = new JPanel();
	JLabel num_lab = new JLabel("Numero carte étudiant");
	JLabel nom_lab = new JLabel("Nom de l'étudiant");
	JLabel prenom_lab = new JLabel("Prénom de l'étudiant");
	JLabel moy_lab = new JLabel("Moyenne de l'étudiant");
	JTextField numero = new JTextField(15);
	JTextField nom = new JTextField(15);
	JTextField prenom = new JTextField(15);
	JTextField moyenne = new JTextField(15);
	JButton ajouter = new JButton("Ajouter");
	JButton supprimer = new JButton("Supprimer");
	JButton affichage = new JButton("Affichage ");
	JButton annuler = new JButton("Annuler");
    int c1;
	String c2,c3;
    double c4;
    EtudiantDAO DAO = new EtudiantDAO () ;
    Etudiant etudiant = new Etudiant();
	public scolarite() {
		this.setBounds(100, 100, 400, 220);
		this.setTitle("Ajout etudiant (Scolarité)");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan.setBorder(new EmptyBorder(5,5,5,5));
		pan.setLayout(new GridLayout(6,2,2,2));
		pan.add(num_lab);
		pan.add(numero);
		pan.add(nom_lab);
		pan.add(nom);
		pan.add(prenom_lab);
		pan.add(prenom);
		pan.add(moy_lab);
		pan.add(moyenne);
		pan.add(ajouter);
		pan.add(supprimer);
		pan.add(affichage);
        pan.add(annuler);
        ajouter.addActionListener(this);
        supprimer.addActionListener(this);
        affichage.addActionListener(this);
        annuler.addActionListener(this);
		this.add(pan);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == ajouter) {
			c1 = Integer.parseInt(numero.getText()); 
			c2 = nom.getText();
			c3 = prenom.getText();
			c4 = Double.parseDouble(moyenne.getText()); 
            DAO = new EtudiantDAO();
            Etudiant etudiant = new Etudiant(c1,c2,c3,c4);
            DAO.ajouter(etudiant);}
     
          if (obj == affichage) {
      			Affichage aff = new Affichage();
        	  
          }
          if (obj == supprimer) {
        	  c1 =Integer.parseInt(numero.getText());  
              DAO = new EtudiantDAO();
              etudiant = new Etudiant(c1);
              DAO.supprimer(etudiant);
          }
         	  
		if(obj == annuler) {
			numero.setText("");
			nom.setText("");
			prenom.setText("");
			moyenne.setText("");
		}
	}
	public static void main(String [] args) {
		scolarite frame = new scolarite();
	}

}
