package kartel_game;

//début de la classe
public class Partie {
    
//début déclaration attribut(s)    
    private LesJoueurs joueurs;
    private Plateau plateau;
    private Prison prison;
    private De de;
//fin déclaration attribut(s)    

//début accesseurs classiques    
    public LesJoueurs getJoueurs() 
        {return joueurs;}
    public void setJoueurs(LesJoueurs joueurs) 
        {this.joueurs = joueurs;}
    public Plateau getPlateau() 
        {return plateau;}
    public void setPlateau(Plateau plateau) 
        {this.plateau = plateau;}
    public Prison getPrison() 
        {return prison;}
    public void setPrison(Prison prison) 
        {this.prison = prison;}
    public De getDe() 
        {return de;}
    public void setDe(De de) 
        {this.de = de;}
//fin accesseurs classiques

//début constructeur       
    public Partie(){
        this.joueurs=ajoutJoueur();
        this.plateau=new Plateau();
        this.de=new De();
        this.prison=new Prison(5);
        jeu();      
    }
     public Partie(LesJoueurs js){
        js.initialiser();
        this.joueurs=js;
        this.plateau=new Plateau();
        this.de=new De();
        this.prison=new Prison(5);
        jeu();      
    }
//fin constructeur       
 
     

//début fonction(s)    
    public LesJoueurs ajoutJoueur(){
        LesJoueurs joueurs=new LesJoueurs();
        boolean lancement=false;boolean choixOk=false;int choixNb=0;
        while(lancement==false)
            {
            choixNb=0;    
            do
                {
                System.out.println("________________________________________");
                joueurs.afficherJoueurs();
                System.out.println("Entrer 1 pour ajouter un joueur (min 2 joueurs), 2 pour commencer la partie, 3 pour retirer le dernier joueur ajout\u00E9, ou 4 pour quitter:");
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<1||choixNb>4)
                        {System.out.println("vous devez rentrer 1,2,3 ou 4 uniquement !!!");    }
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!! (1,2,3 ou 4)");     
                    }
                }
            while(choixOk==false);
        
            switch (choixNb)
                {
                case 1:{joueurs.ajoutJoueur();break;}
                case 2:{
                       if (joueurs.getTaille()<2)
                            {System.out.println("il faut minimum 2 joueurs pour pouvoir commencer la partie");break;}
                       else
                            {lancement=true;break;}
                       }
                case 3:{joueurs.enleverDernierJoueur();break;}
                case 4:{System.exit(0);}
                }
            } 
        return joueurs;
    }
                   
    public void jeu(){
        boolean partieFini=false;int nbJoueurCourant=0;Joueur joueurCourant;Jeton jetonPris;
        int choixNb=0;boolean choixOk=false;
        while (partieFini==false)
            {
            joueurCourant=this.joueurs.getJoueur(nbJoueurCourant);   
            System.out.println("________________________________________");
            
            System.out.println(this.plateau.toString());
            
            System.out.println(this.prison.toString());
            
            System.out.println(this.joueurs.toString());
            
            System.out.println("C'est \u00E0 "+joueurCourant.getNom()+" de jouer.");
            this.de.lancer();
            System.out.println("Le d\u00E9 a \u00E9t\u00E9 lanc\u00E9, le r\u00E9sultat est :"+this.de.getFaceCourante());
            choixNb=0;choixOk=false;
            do
                {
                String s="Tu peux donc choisir entre avanc\u00E9 de ";
                for(int i=2;i<=this.de.getFaceCourante();i++)
                    {s=s+i+" cases, ";}
                s=s+"selon ton choix rentre le chiffre correspondant:";                
                System.out.println(""+s);
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<2||choixNb>this.de.getFaceCourante())
                        {System.out.println("vous devez rentrer uniquement un chiffre faisant partie de vos possibilit\u00E9s !!!");    }
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!! (2,3, ou 4 selon tes possibilit\u00E9s)");     
                    }
                }
            while(choixOk==false);
            
            jetonPris=this.plateau.deplacement(choixNb);
            if(jetonPris instanceof Evasion)
                {
                Evasion evasion=(Evasion)jetonPris;
                evasion.evenement(this.prison);    
                }
            else
                {
                if (jetonPris instanceof Boss)
                    {this.prison.ajouterBoss((Boss)jetonPris );}
                else
                    {this.joueurs.getJoueur(nbJoueurCourant).getReserve().ajouterJeton(jetonPris);}
                }
            this.joueurs.calculScores(this.prison);
            if (this.prison.isPleine())
                {partieFini=true;}            
            nbJoueurCourant=nbJoueurCourant+1;
            if (nbJoueurCourant==this.joueurs.getTaille())
                {nbJoueurCourant=0;}
            
            }
            
            System.out.println("________________________________________");
            System.out.println("La partie est termin\u00E9 car la prison est pleine, voici les boss qui sont en prison:");
            System.out.println(this.prison.toString());
            System.out.println("\nEt voici les joueurs avec leurs score et leurs r\u00E9serves");
            System.out.println(this.joueurs.toString());
            System.out.println("Ainsi le(s) gagnant(s) de cette partie est/sont: "+ this.joueurs.getGagnants().getNoms());

            }
//fin fonction(s)                                 

}
//fin de la classe