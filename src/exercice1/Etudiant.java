package exercice1;

public class Etudiant {
	private int numero;
	private String nom;
	private String prenom;
	private double moyenne ;
    Etudiant(){	
    }
    Etudiant(String nom ,String prenom ){
    	this.nom= nom;
    	this.prenom= prenom;
    }
    Etudiant(int numero ){
    	this.numero = numero;
    }
    Etudiant(int numero ,String nom ,String prenom ){
    	this.numero= numero;
    	this.nom= nom;
    	this.prenom= prenom;
    }
    Etudiant (int numero ,String nom ,String prenom,double moyenne ){
    	this.numero= numero;
    	this.nom= nom;
    	this.prenom= prenom;
    	this.moyenne= moyenne;
    }
    public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	

}
