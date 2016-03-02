package poubelle;
import java.util.*;

public class Graphe {
	
	private String graphe;
	private int longueur;
	private int largeur;

	
	/**
	 * 
	 */
	//1 contour,0 sans contour
	public Graphe(int lon,int larg,int cont){
		
		longueur = lon;
		largeur = larg;
		graphe = "";
		if (cont == 1 ){
			for(int i=0;i<2*lon-1;i++){
				for(int j=0;j<2*larg-1;j++){
					
					//trait plein
					if (i==0 || i==2*lon-2){ //première et dernière ligne
						if (j%2==0){
							graphe+=".";
						}else{
							graphe+="-";
						}
					}
					//barres verticales et espaces
					if(i%2!=0){		// pour chaque ligne impaire
						if(j!=0 && j!=2*larg-2){
							graphe+=" ";
						}else{
							graphe+="|";
						}
					}
					
					//ligne a remplir (en jouant)
					if(i!=0 && i!=2*lon-2 && i%2==0){ // pour toute ligne qui n'est pas la première
						if (j%2==0){
							graphe+=".";
						}else{
							graphe+=" ";
						}
					}
				}
				graphe+="\n";
			}
		}else{
			//graphe sans bords
			for(int i=0;i<2*lon-1;i++){
				for(int j=0;j<2*larg-1;j++){
					
					//trait plein
					if (i==0 || i==2*lon-2){ //première et dernière ligne
						if (j%2==0){
							graphe+=".";
						}else{
							graphe+=" ";
						}
					}
					//barres verticales et espaces
					if(i%2!=0){		// pour chaque ligne impaire
						if(j!=0 || j!=2*larg-2){
							graphe+=" ";
						}else{
							graphe+=" ";
						}
					}
					
					//ligne a remplir (en jouant)
					if(i!=0 && i!=2*lon-2 && i%2==0){ // pour toute ligne qui n'est pas la première
						if (j%2==0){
							graphe+=".";
						}else{
							graphe+=" ";
						}
					}
				}
				graphe+="\n";
			}
		}
	}
	
	public int parcour(int p1, int p2)
	{
		int compt1 = 0;
		int compt2 = 0;
		if(p1 - p2 == 1 || p1 - p2 == -1)
		{
			while(compt1 != p1)
			{
				if(graphe.charAt(compt2) == '.')
				{
					compt1++;
				}
				compt2++;
			}
			compt2 += p1 - p2;
		}
		else
		{
			while(compt1 != p1)
			{
				if(graphe.charAt(compt2) == '.')
				{
					compt1++;
				}
				compt2++;
			}
			if (p1 < p2)
			{
				compt2 += largeur;
			}
			else
			{
				compt2 -= largeur;
			}
		}
		return compt2;
	}
	
	public boolean coupPossible(int p1, int p2)
	{
		boolean res = true;
		if((Math.abs(p1 - p2) == this.largeur) || (Math.abs(p1 - p2) == 1))
		{
			if(graphe.charAt(this.parcour(p1, p2)) == '-' || graphe.charAt(this.parcour(p1, p2)) == '|')
			{
				res = false;
			}
		}
		else
		{
			res = false;
		}
		
		return res;
	}
	
	public int coup (int p1, int p2, int tour)
	{
		int res = tour;
		char c = 'a';
		int pos = this.parcour(p1, p2);
		if (p1 - p2 == -1 || p1 - p2 == 1)
		{
			c = '-';
		}
		else
		{
			c ='|';
		}
		graphe = graphe.substring(0,pos) + c +graphe.substring(pos+1);
		return res;
	}
	
	public static void main (String [] args)
	{
		Graphe a = new Graphe(5,5,1);
		System.out.print(a.graphe);
		
	}
}
