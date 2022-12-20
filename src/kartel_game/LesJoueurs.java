package kartel_game;

import java.util.ArrayList;

//début de la classe
public class LesJoueurs {
       
//début déclaration attribut(s)    
    private ArrayList <Joueur> joueurs;
//fin déclaration attribut(s)

  
//début accesseurs classiques    
    public ArrayList<Joueur> getJoueurs() 
        {return joueurs;}
    public void setJoueurs(ArrayList<Joueur> joueurs) 
        {this.joueurs = joueurs;}   
//début accesseurs classiques


//début accesseurs specifiques      
    public int getTaille(){
        return this.joueurs.size();
    }
    public Joueur getJoueur(int i){
        return this.joueurs.get(i);
    }
    public LesJoueurs getGagnants(){
        int max=getJoueur(0).getReserve().getScore();
        for(int i=1; i<getTaille();i++)
            if (getJoueur(i).getReserve().getScore()>max)
                max=this.getJoueur(i).getReserve().getScore();
        LesJoueurs lst=new LesJoueurs();
        for(int i=0; i<this.getTaille();i++)
            if (getJoueur(i).getReserve().getScore()==max)
                lst.getJoueurs().add(getJoueur(i));
        return lst;
    }
    public String getNoms(){
        String s="";
            for (int i=0;i<this.getTaille();i++)
                {
                if (i==this.getTaille()-1)
                    {
                    s=s+this.getJoueur(i).getNom();
                    }
                else
                    {
                    s=s+this.getJoueur(i).getNom()+", ";
                    }
                }    
        return s;
    }    
//fin accesseurs specifiques    
    
    
//début constructeur        
    public LesJoueurs(){
        this.joueurs=new ArrayList <Joueur>();
    }
//fin constructeur  
    
  
    
//début méthode(s)    
    public void enleverDernierJoueur(){
        this.joueurs.remove(this.getTaille()-1);
    }    
    
    public void ajoutJoueur(){
        boolean ajoutOk=false;
        System.out.print("Entrez le nom du joueur \u00E0 ajouter:");
        do
            {
        String s=Lire.S();
            if (s.equals(""))
                {System.out.println("vous devez rentrez quelquechose:");}
            else
                {this.joueurs.add(new Joueur(s,new Reserve()));ajoutOk=true;}    
            }   
        while(ajoutOk==false);
    }   
    
    public void afficherJoueurs(){
        String s="joueurs: ";
        if(this.getTaille()<1)
            {s=s+" Aucun joueur n'a \u00E9t\u00E9 ajout\u00E9 ";}
        else
            {
            for (int i=0;i<this.getTaille();i++)
                {
                if(i==this.getTaille()-1)
                    {s=s+this.joueurs.get(i).getNom();}
                else
                    {s=s+this.joueurs.get(i).getNom()+", ";}
                }
            }
        System.out.println(s);
        } 
        
    public String toString(){
        String s="";
        for (int i=0;i<this.getTaille();i++)
            {s=s+this.getJoueur(i).toString()+"\n";}
        return s;
    }       
            
    public void calculScores(Prison prison){
        for (int i=0;i<this.getTaille();i++)
            {
            int score=0;
            for (int j=0;j<this.getJoueur(i).getReserve().getNbJetons();j++)
                {
                if (prison.bossPrison(this.getJoueur(i).getReserve().getJeton(j).getType()))
                    {
                    if (this.getJoueur(i).getReserve().getJeton(j) instanceof PotDeVin)
                        {score=score;}
                    else
                        {score=score+((Gangster)this.getJoueur(i).getReserve().getJeton(j)).getTaille();}
                    }
                else
                    {
                    if (this.getJoueur(i).getReserve().getJeton(j) instanceof PotDeVin)
                        {score=score+3;}
                    else
                        {score=score-((Gangster)this.getJoueur(i).getReserve().getJeton(j)).getTaille();}
                    }
                }         
            this.getJoueur(i).getReserve().setScore(score);                
            }
        }    
    
    public void initialiser(){
        for (int i=0;i<this.getTaille();i++)
            {
            this.getJoueur(i).getReserve().initialiser();
           }        
    }
//fin méthode(s)        
            
}
//fin de la classe    
    
    
    
    
    

