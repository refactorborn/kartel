package kartel_game;

import java.util.ArrayList;

//début de la classe
public class Reserve {
    
//début déclaration attribut(s)
    private ArrayList <Jeton> reserve;
    private int score;
//fin déclaration attribut(s)    

//début accesseurs classiques    
    public ArrayList <Jeton> getReserve() 
        {return reserve;}
    public void setReserve(ArrayList <Jeton> r) 
        {this.reserve = r;}
    public int getScore() 
        {return score;}
    public void setScore(int score) 
        {this.score = score;}
//fin accesseurs classiques    
    
//début accesseurs cspécifiques     
    public int getNbJetons() 
        {return this.reserve.size();}
    public Jeton getJeton(int i)
        {return this.reserve.get(i);}
//fin accesseurs cspécifiques      

//début constructeur    
   public Reserve(){
       this.reserve=new ArrayList<Jeton>();
       this.score=0;
   } 
//fin constructeur
   
   
   
//début méthode(s)        
    public void ajouterJeton(Jeton j){
        this.reserve.add(j);
    }
    
    public String toString(){
        String s="";
        if (this.getNbJetons()==0)
            {s="ne poss\u00E8de pas encore de jetons";} 
        else
            {
            for (int i=0;i<this.getNbJetons();i++)
                {
                if (i==this.getNbJetons()-1)
                    {
                    s=s+this.getJeton(i).toString();
                    }
                else
                    {
                    s=s+this.getJeton(i).toString()+" - ";
                    }
                }
            }
        return s;
    }
    
    public void initialiser(){
        this.reserve.clear();
        this.score=0;   
    }
//fin méthode(s)  
    
}
//fin de la classe