package kartel_game;

//début de la classe
public class Jeton {
    
//début déclaration attribut(s)    
    private String type;
//fin déclaration attribut(s)
    
//début accesseurs classiques    
    public String getType() 
        {return type;}
    public void setType(String gang) 
        {this.type = gang;}
//fin accesseurs classiques    
   
//début constructeur    
    public Jeton(String type) {
        this.setType(type);
    }
//fin constructeur           
    
    
}
//début de la classe