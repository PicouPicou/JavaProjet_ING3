package Modele;

public class Utilisateur {
    private String nomUtilisateur;
    private String motDePasse;

    public Utilisateur(){
        this.nomUtilisateur = "";
        this.motDePasse = "";
    }

    public void setNomUtilisateur(String nomUtilisateur){
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse){
        this.motDePasse = motDePasse;
    }
}
