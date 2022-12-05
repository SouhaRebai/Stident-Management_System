package exercice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class EtudiantDAO {
	String url ="jdbc:mysql://127.0.0.1/Scolarité";
 	String user = "root";
 	String password = "";
 	Connection con;
 	Statement st ;
	 public EtudiantDAO() {
	 	try {
				con = DriverManager.getConnection(url,user,password);
				System.out.println("Connexion établie...");
				 if(con != null) {
			        	st = con.createStatement();
			        }
			} catch (SQLException e) {
				System.out.println("Connexion échoué:"+ e.getMessage());
	  }
	 }
	void ajouter (Etudiant et) {
		try {
		con = DriverManager.getConnection(url,user,password);
		try {
		   System.out.println("Connexion avec succès...");
		   String Request = " insert into etudiant values (?,?,?,?);";
		   PreparedStatement ps = con.prepareStatement(Request);
		   ps.setInt(1,et.getNumero());
		   ps.setString(2, et.getNom());
		   ps.setString(3,et.getPrenom());
		   ps.setDouble(4, et.getMoyenne());
		   ps.executeUpdate();
		   System.out.println("Insertion request established...");
		   } catch (SQLException e1) {
			   System.out.println("Request of insertion failed "+e1.getMessage());
		   }
		
		}
		catch (SQLException e1) {
			System.out.println("Connexion echouée...");
		}
	}
	
	void supprimer (Etudiant et) {
		try {
		   String Request = " delete from etudiant where Numero = ? ;";
		   PreparedStatement ps = con.prepareStatement(Request);
		   ps.setInt(1,et.getNumero());
		   ps.executeUpdate();
		   System.out.println("Deletion request established...");
		   } catch (SQLException e1) {
			   System.out.println("Request of deletion failed ");
		   }
		}
	
	void chercher (Etudiant et) {
		try {
		   String Request = " select * from etudiant where Numero = ?;";
		   PreparedStatement ps = con.prepareStatement(Request);
		   ps.setInt(1,et.getNumero());
		   ps.executeUpdate();
		   System.out.println("Search request established...");
		   } catch (SQLException e1) {
			   System.out.println("Request of search failed ");
		   }
		
	}
	 ResultSet getAll(String requete,JTextField inf, JTextField sup ){
	 	 ResultSet rs = null;
	 	 PreparedStatement ps = null;
	 	 double num_inf = Double.parseDouble(inf.getText());
	 	 double num_sup = Double.parseDouble(sup.getText());
	 	 try {
			ps = con.prepareStatement(requete);
			ps.setDouble(1,num_inf);
			ps.setDouble(2,num_sup);
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs = st.executeQuery(requete);
			System.out.println("Selection with succes");
			
		} catch (SQLException e) {
			System.out.println("Selection error: "+e.getMessage());
		}
	 	 return rs;
	  }
	 ResultSet getAll(String requete){
	 	 ResultSet rs = null;
	 	 Statement st = null;
	 	 try {
			st = con.createStatement();
			st.executeUpdate(requete);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs = st.executeQuery(requete);
			System.out.println("Selection with succes");
			
		} catch (SQLException e) {
			System.out.println("Selection error: "+e.getMessage());
		}
	 	 return rs;
	  }
	 
	 void afficherResultSet(ResultSet rs) {
		  try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int nbcol = rsmd.getColumnCount();
			for (int i=1 ; i<=nbcol;i++) {
				System.out.println(rsmd.getColumnName(i) +" ( "+rsmd.getColumnClassName(i)+" )");
			}
			System.out.println();
			while(rs.next()) { 
				for (int i=1 ; i<=nbcol;i++) 
				System.out.print(rs.getObject(i)+" : ");
				System.out.println();
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	public int modifier(int numero , String nom ,String prenom ,double moyenne) {
		int a = -1;
		String req ="update etudiant set nom = ? , prenom = ? , moyenne = ? where numero = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setDouble(3, moyenne);
			ps.setInt(4,numero);
            a = ps.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println("modification error :" + e.getMessage());
		}
		
		return a;
		
	}
}
