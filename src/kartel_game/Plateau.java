package kartel_game;

//début de la classe
public class Plateau {
    
//début déclaration attribut(s)    
    private Jeton[] plateau;
//fin déclaration attribut(s)    
    

//début accesseurs classiques
    public void setPlateau(Jeton[] p)
        {this.plateau=p;}
//fin accesseurs classiques    
//début accesseurs spécifiques      
    public int getTaille(){
        return this.plateau.length;        
    }
//fin accesseurs spécifiques          

//début constructeur       
    public Plateau(){
        this.plateau=initPlateau();
    }
//fin constructeur 

    
    
//début méthode(s)    
    public Jeton[] initPlateau(){
        Jeton[] plateau=new Jeton[44];
        plateau[0]=new Detective();
        plateau[1]=new Boss("A");
        plateau[2]=new Gangster("A",1);
        plateau[3]=new Gangster("A",2);
        plateau[4]=new Gangster("A",2);
        plateau[5]=new Gangster("A",3);
        plateau[6]=new PotDeVin("A");
        plateau[7]=new Boss("B");
        plateau[8]=new Gangster("B",1);
        plateau[9]=new Gangster("B",2);
        plateau[10]=new Gangster("B",2);
        plateau[11]=new Gangster("B",3);
        plateau[12]=new PotDeVin("B");
        plateau[13]=new Boss("C");
        plateau[14]=new Gangster("C",1);
        plateau[15]=new Gangster("C",2);
        plateau[16]=new Gangster("C",2);
        plateau[17]=new Gangster("C",3);
        plateau[18]=new PotDeVin("C");
        plateau[19]=new Boss("D");
        plateau[20]=new Gangster("D",1);
        plateau[21]=new Gangster("D",2);
        plateau[22]=new Gangster("D",2);
        plateau[23]=new Gangster("D",3);
        plateau[24]=new PotDeVin("D");
        plateau[25]=new Boss("E");
        plateau[26]=new Gangster("E",1);
        plateau[27]=new Gangster("E",2);
        plateau[28]=new Gangster("E",2);
        plateau[29]=new Gangster("E",3);
        plateau[30]=new PotDeVin("E");
        plateau[31]=new Boss("F");
        plateau[32]=new Gangster("F",1);
        plateau[33]=new Gangster("F",2);
        plateau[34]=new Gangster("F",2);
        plateau[35]=new Gangster("F",3);
        plateau[36]=new PotDeVin("F");
        plateau[37]=new Boss("G");
        plateau[38]=new Gangster("G",1);
        plateau[39]=new Gangster("G",2);
        plateau[40]=new Gangster("G",2);
        plateau[41]=new Gangster("G",3);
        plateau[42]=new PotDeVin("G");
        plateau[43]=new Evasion();
        Jeton jTemp;
        for (int i=0;i<1000;i++)
            {
            int alea1,alea2;
            alea1=1+(int)(Math.random()*((43-1+1)));
            alea2=1+(int)(Math.random()*((43-1+1)));
            jTemp=plateau[alea1];
            plateau[alea1]=plateau[alea2];
            plateau[alea2]=jTemp;
            }      
        return plateau;
    }
    
    public int getPositionDetective(){
        int pos=0;
        while (!this.plateau[pos].toString().equals("<>"))
            {pos=pos+1;}
        return pos;
    }
    
    public Jeton deplacement(int i){
        int pos=this.getPositionDetective();
        int newPos=pos+i;
        if (newPos>this.getTaille()-1)
            {
            newPos=newPos-this.getTaille();                
            }
        Jeton j=this.plateau[newPos];
        this.plateau[newPos]=this.plateau[pos];
        this.plateau[pos]=null;    
        diminuPlateau();
        return j;
    } 
        
    public void diminuPlateau(){
        Jeton plateauReduit[]=new Jeton [this.getTaille()-1];
        int nb=0;
        for (int i=0;i<this.getTaille();i++)
            {
             if (this.plateau[i]!=null)
                {
                plateauReduit[nb]=this.plateau[i];
                nb=nb+1;     
                }     
            }
        this.setPlateau(plateauReduit);
    }
     
    public String toString(){
        String s="";
        for (int i=0;i<this.getTaille();i++)
            {
                if (i==this.getTaille()-1)
                    {
                    s=s+this.plateau [i].toString();
                    }
                else
                    {
                    s=s+this.plateau[i].toString()+" - ";
                    }
            }
       return s; 
        
        
    }
//fin méthode(s)        
    
}
//fin de la classe