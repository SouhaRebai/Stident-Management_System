package exercice1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Affichage extends JFrame implements ActionListener {
	Etudiant etudiant;
	EtudiantModel model ;
	JTable jt;
	JButton btn = new JButton ("OK");
	JTextField inf = new JTextField(5);
	JTextField sup = new JTextField(5);
	JLabel lab1 = new JLabel("Moyenne entre");
	JLabel lab2 = new JLabel("et");
	JPanel pan = new JPanel() ;
	EtudiantDAO et= new EtudiantDAO();
	String requete1 = "select * from etudiant;"; 
	String requete2 = "select * from etudiant where Moyenne >? and Moyenne < ? ;";
	ResultSet rs;
	Affichage (){
		this.setTitle("Affichage données");
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        pan.setLayout(new FlowLayout());
        this.add(pan,BorderLayout.NORTH);
        rs = et.getAll(requete1);
        model = new EtudiantModel(rs);
        jt = new JTable(model);
        pan.add(lab1);
        pan.add(inf);
        pan.add(lab2);
        pan.add(sup);
        pan.add(btn);
        btn.addActionListener(this);
        this.add(new JScrollPane(jt),BorderLayout.CENTER);
        this.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn) {
			 et= new EtudiantDAO();
			 rs = et.getAll(requete2,inf,sup);
		     model = new EtudiantModel(rs);
		     jt = new JTable(model);
		     this.add(new JScrollPane(jt),BorderLayout.CENTER);
		     this.setVisible(true);	
		        
		}
		
	}

}
