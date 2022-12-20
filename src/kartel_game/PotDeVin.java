package kartel_game;

//début de la classe
public class PotDeVin extends Jeton {

//début constructeur
    public PotDeVin(String gang) {
        super(gang);
    }
//fin constructeur
    
    
    
//début méthode(s)    
    public String toString(){
        return "$"+this.getType();
    }
//début méthode(s)    
    
}
//fin de la classe