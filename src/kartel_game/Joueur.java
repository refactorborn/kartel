package kartel_game;

//début de la classe
public class Joueur {

//début déclaration attribut(s)    
    private String nom;
    private Reserve reserve;
//fin déclaration attribut(s)
    
    
//début accesseurs classiques    
    public String getNom() 
        {return nom;}
    public void setNom(String nom) 
        {this.nom = nom;}
    public Reserve getReserve() 
        {return reserve;}
    public void setReserve(Reserve r) 
        {this.reserve = r;}
//fin accesseurs classiques    
    
    
//début constructeur        
    public Joueur(String n,Reserve r){
        this.setNom(n);
        this.setReserve(r);
    }
//fin constructeur        
    
    
    
//début méthode(s)    
    public String toString(){
        String s=this.getNom()+" ("+this.getReserve().getScore()+") : "+this.getReserve().toString();
        return s;
    }
//fin méthode(s)          
    
}
//fin de la classe