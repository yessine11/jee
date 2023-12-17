package tp4;

import java.util.Date;

public class Etudiant {


    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String filiere;

 
    public Etudiant() {
    }

 
    public Etudiant(int id, String nom, String prenom, Date dateNaissance, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.filiere = filiere;
    }

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getFiliere() {
        return filiere;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
