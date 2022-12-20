package kartel_game;

//début de la classe
public class Gangster extends Jeton {
        
//début déclaration attribut(s)    
    int taille;
//fin déclaration attribut(s)
    
//début accesseurs classiques    
    public int getTaille() 
        {return taille;}
    public void setTaille(int taille) 
        {this.taille = taille;}
//fin accesseurs classiques

//début constructeur        
    public Gangster(String gang,int t) {
        super(gang);
        this.setTaille(t);
    }
//fin constructeur      
    


//début méthode(s)    
    public String toString() {
        return this.getTaille()+this.getType();
    }
//fin méthode(s)    
    
}
//début de la classe