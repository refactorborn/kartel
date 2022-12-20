package kartel_game;

import java.util.ArrayList;

//début de la classe
public class Prison {
    
//début déclaration attribut(s)
    private ArrayList <Boss> prison;
    private int taille;
//fin déclaration attribut(s)    

//début accesseurs classiques    
    public ArrayList <Boss> getPrison() 
        {return prison;}
    public void setPrison(ArrayList <Boss> prison) 
        {this.prison = prison;}
//début accesseurs classiques
//début accesseurs spécifiques     
    public Boss getBoss(int i)
        {return this.prison.get(i);}
    public int getNbBoss()
        {return this.prison.size();}
    public boolean isPleine(){
        boolean plein=false;
        if (this.taille==this.getNbBoss())
            {plein=true;}
        return plein;
    }
    public boolean isVide(){
        return this.prison.isEmpty();
    }           
//fin accesseurs spécifiques
    
//début constructeur   
    public Prison(int t){
        this.prison=new ArrayList <Boss> () ;
        this.taille=t;
    }        
//fin constructeur    
   
    
    
//début méthode(s)    
    public void ajouterBoss(Boss b){
            this.prison.add(b);
    }

    public String toString(){
        String s="Prison: ";
        if (this.getNbBoss()==0)
            {s=s+"aucun boss n'est en prison";}
        else
            {
            for (int i=0;i<this.getNbBoss();i++)
                {
                if (i==this.getNbBoss()-1)
                    {
                    s=s+this.getBoss(i).toString();
                    }
                else
                    {
                    s=s+this.getBoss(i).toString()+" - ";
                    }
                }
            }
        return s;
    }
        
    public boolean bossPrison(String s){
        boolean bossPrison=false;
        for (int i=0; i<this.getNbBoss();i++)
            {
            if (this.getBoss(i).getType().equals(s))
                {bossPrison=true;}                
            }
        return bossPrison;       
    }
        
    public void retireBoss(int i){
        this.prison.remove(i-1);       
    }
//fin méthode(s)      
      
}
//fin de la classe
