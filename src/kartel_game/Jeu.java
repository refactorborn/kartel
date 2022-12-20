package kartel_game;

import java.util.ArrayList;

//début de la classe
public class Jeu {

//début fonction main (celle qui est lu)          
    public static void main(String[] args) {  
        boolean rejouer=false;
        boolean memeJoueur=false;
        Partie p;        
        accueil();
        p=new Partie();        
        do
            {
            rejouer=accueil2();            
            if (rejouer==true)
                {
                memeJoueur=memeJoueur();
                if (memeJoueur==true)
                    {
                    LesJoueurs js=p.getJoueurs();
                    p=new Partie(js);
                    }
                else
                    {
                    p=new Partie();
                    }    
                }
            }
        while(rejouer==true);
        System.out.println("\nNous esperons que vous avez appr\u00E9ci\u00E9 jouer à Kartel, revenez quand vous voulez");
    }
//fin fonction main (celle qui est lu)     
    
//début fonction gérant le menu lors de la première partie   
    public static void accueil(){
        boolean lancement=false;boolean choixOk=false;int choixNb=0;
        System.out.println("bienvenu pour jouer \u00E0 Kartel");
        while(lancement==false)
            {
            choixNb=0;
            do
                {
                System.out.println("________________________________________");
                System.out.println("Entrer 1 pour lancer une partie, 2 pour voir les r\u00E8gles, 3 pour quitter:");
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<1||choixNb>3)
                        {System.out.println("vous devez rentrer 1,2 ou 3 uniquement !!!");}
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!! (1,2 ou 3)");     
                    }
                }
            while(choixOk==false);                     
            switch(choixNb)
                {
                case 1:{lancement=true;break;}
                case 2:{System.out.println(ecrireRegles());break;}
                case 3:{System.exit(0);}
                }
            }
        }    
//fin fonction gérant le menu lors de la première partie 

//début fonction gérant le menu à partir de la deuxième partie   
    public static boolean accueil2(){
        boolean rejouer=false;        
        boolean lancement=false;boolean choixOk=false;int choixNb=0;
        while(lancement==false)
            {
            System.out.println("Vous avez la possibilit\u00E9 de rejouer");
            choixNb=0;
            do
                {
                System.out.println("________________________________________");
                System.out.println("Entrer 1 pour rejouer, 2 pour voir les r\u00E8gles, 3 pour quitter:");
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<1||choixNb>3)
                        {System.out.println("vous devez rentrer 1,2 ou 3 uniquement !!!");}
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!! (1,2 ou 3)");     
                    }
                }
            while(choixOk==false);                    
            switch(choixNb)
                {
                case 1:{lancement=true;rejouer=true; break;}
                case 2:{System.out.println(ecrireRegles());break;}
                case 3:{lancement=true;rejouer=false ;break;}
                }
            }
        return rejouer;
        }   
//fin fonction gérant le menu à partir de la deuxième partie  
    
    
//début fonction gérant le menu qui demande si on veut rejouer avec les mêmes joueurs ou non   
    public static boolean memeJoueur(){
        boolean memeJoueur=false;        
        boolean lancement=false;boolean choixOk=false;int choixNb=0;
        while(lancement==false)
            {
            choixNb=0;
            do
                {
                System.out.println("\nEntrer 1 pour rejouer avec les m\u00EAmes joueurs, 2 pour changer de joueurs:");
                String choix=Lire.S();
                try
                    {
                    choixNb=Integer.parseInt(choix);    
                    if (choixNb<1||choixNb>2)
                        {System.out.println("vous devez rentrer 1 ou 2 uniquement !!!");}
                    else
                        {choixOk=true;}
                    }
                catch (NumberFormatException e)
                    {
                    System.out.println("vous devez uiquement rentrer un nombre entier !!! (1 ou 2)");     
                    }
                }
            while(choixOk==false);                     
            switch(choixNb)
                {
                case 1:{lancement=true;memeJoueur=true; break;}
                case 2:{lancement=true;memeJoueur=false ;break;}
                }
            }
        return memeJoueur;
        } 
//fin fonction gérant le menu qui demande si on veut rejouer avec les mêmes joueurs ou non          
        
//début fonction qui retourne les règles sous forme de type String
    public static String ecrireRegles(){
        String s="- - - - - - - - - - - - - - - - - - - - ";
        s+="\nTous les jetons sont positionn\u00E9s en rond al\u00E9atoirement, le d\u00E9tective y compris.";
        s+="\n";
        s+="\nDans ce jeu tous les joueurs contr\u00F4lent le m\u00EAme pion qui est le d\u00E9tective, et le font avancer dans le but de";
        s+="\nr\u00E9cup\u00E9rer des jetons. Pour ceci, les joueurs jouent chacun leur tour, le joueur qui joue lance un d\u00E9, ce d\u00E9";
        s+="\nposs\u00E8de 2 faces avec le num\u00E9ro 2, 2 faces avec le num\u00E9ro 3, et 2 faces avec le num\u00E9ro 4. En fonction du ";
        s+="\nr\u00E9sultat du d\u00E9, le joueurs \u00E0 la possibilit\u00E9 de choisir de combien de jetons il d\u00E9cide d'avancer le d\u00E9tective. ";
        s+="\nLe jeton sur lequel atterit le d\u00E9tective subit diff\u00E9rents sorts suivant sa nature, si c'est un boss il finit en prison,";
        s+="\nsi c'est un pot de vin ou des gangsters le joueur venant de jouer le r\u00E9cup\u00E8re dans sa r\u00E9serve, et si c'est un ";
        s+="\njeton 'evasion' il est enlever du jeu et donne la possibilit\u00E9 au joueur de retirer un boss de la prison.";
        s+="\nLe jeu prend fin quand il y a 5 boss en prison.";
        s+="\n";
        s+="\nPour calculer les scores:";
        s+="\n-Pot de vin: si le boss du m\u00EAme gang n'est pas en prison vaut 3 point";
        s+="\n-Gangster: si le boss du m\u00EAme gang n'est pas en prison retire le nombre de gangster en point";
        s+="\n           si le boss du m\u00EAme gang est en prison vaut le nombre de gangster en point";
        s+="\n";
        s+="\nRepr\u00E9sentation ici (le '?' repr\u00E9sente le gang, en jeu il sera remplac\u00E9 par des lettres correspondant chacune \u00E0 un gang):";
        s+="\n-D\u00E9tective: <>";
        s+="\n-Evasion: \u0023";
        s+="\n-Boss: [?]";        
        s+="\n-Pot de vin: $?";
        s+="\n-Gangster: chiffre? (le chiffre repr\u00E9sente le nombre de gangster, peut \u00EAtre 1,2,ou3) ";
        return s;
    }
//fin fonction qui retourne les règles sous forme de type String    
   
}
//fin de la classe