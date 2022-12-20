package kartel_game;

//début de la classe
public class Evasion extends Jeton{
    
//début constructeur    
    public Evasion(){
        super("Evasion");
            }
//fin constructeur    

    
    
//début méthode(s)    
    public String toString(){
        return "\u0023";
    }        

    public void evenement(Prison prison){
        boolean lancement=false;boolean choixOk=false;int choixNb=0;
        choixNb=0;
        do
            {
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
            System.out.println("Vous avez r\u00E9cup\u00E9r\u00E9 le jeton d'\u00E9vasion, il permet si vous le souhaiter de faire s'\u00E9vader un Boss de prison,");
            if(prison.isVide())
                {
                System.out.println("cependant la prison est vide donc vous ne pouvez rien faire");
                choixOk=true;
                choixNb=5;
                }               
            else
                {
                String s="pour \u00E7a entrer ";
                for (int i=1;i<=prison.getNbBoss();i++)
                    {
                    s=s+i+" pour lib\u00E9rer le boss de la cellule "+i+", ";                        
                    }
                s=s+"\nsi vous ne voulez pas lib\u00E9rer de boss il faut entrer 5";                  
                System.out.println(s);
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<1||(choixNb>prison.getNbBoss()&&choixNb!=5))
                        {
                        String s2="vous devez entrer uniquement ";
                        for(int i=1;i<=prison.getNbBoss();i++)
                            {
                            s2=s2+i+", ";    
                            }
                        s2=s2+"ou 5";
                        System.out.println(s2);
                        }
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!!");     
                    }
                }
            }
        while(choixOk==false);                     
        if(choixNb!=5)
            {
            prison.retireBoss(choixNb);
            System.out.println("le boss s'est \u00E9vad\u00E9, il disparrait dans la nature et devient introuvable");
            }                            
    }
//fin méthode(s)    
       
}
//début de la classe