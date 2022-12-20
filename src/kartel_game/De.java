package kartel_game;

//début de la classe
public class De {
    
//début déclaration attribut(s)
    private int[] faces;
    private int faceCourante;
//fin déclaration attribut(s)
    
//début accesseurs classiques 
    public int[] getFaces() 
        {return faces;}
    public void setFaces(int[] faces) 
        {this.faces = faces;}
    public int getFaceCourante() 
        {return faceCourante;}
    public void setFaceCourante(int faceCourante) 
        {this.faceCourante = faceCourante;}
//fin accesseurs classiques
    
//début constructeur    
    public De(){
        this.faces=new int[6];
        this.initListeFaces();
    }
//fin constructeur 

    
    
//début méthode(s)    
    public void initListeFaces(){
        for (int i=0;i<2;i++)
            {this.faces[i]=2;}
        for (int i=2;i<4;i++)
            {this.faces[i]=3;}
        for (int i=4;i<6;i++)
            {this.faces[i]=4;}               
    }
    
    public void lancer(){       
        this.setFaceCourante(this.faces[(int)(Math.random()*6)]);
    }
//fin méthode(s)
    
}
//fin de la classe