package kartel_game;

//début de la classe
public class Boss extends Jeton {
    
//début constructeur
    public Boss(String gang){
        super(gang);
    }
//fin constructeur 
    
    
    
//début méthode(s)
    public String toString(){
        return "["+this.getType()+"]";
    }
//fin méthode(s)    
    
}
//fin de la classe