package poubelle;

public class jeux 
{
	private int tourJ1;
	private int hauteur;
	private int largueur;
	private ia categorieIA;
	private int pointJ1;
	private int pointJ2;
	private LDA graphe;
	private int condVictoire;
	
	
	public jeux (int hauteur ,int largeur ,int IAJ2 ,int tourJoueur ,int rebord,int condVictoire)
	{
		this.largueur = largeur;
		this.hauteur = hauteur;
		this.categorieIA.choixIA(IAJ2);
		this.tourJ1 = tourJoueur;
		this.graphe.creation(rebord);
		this.condVictoire=condVictoire;
	}
	
	
	/**
	 * affiche la phrase de victoire
	 */
	
	public void victoire()
	{
		String phrase ="Le Joueur ";
		if (condVictoire == 1)
		{
			if(pointJ1 < pointJ2)
			{
				phrase += "2 a gagner";
			}
			else
			{
				if(pointJ1 > pointJ2)
				{
					phrase += "1 a gagner";
				}
				else
				{
					phrase += "1 et 2 ont fait un match nul";
				}
			}
		}
		else
		{
			if(pointJ1 < pointJ2)
			{
				phrase += "1 a gagner";
			}
			else
			{
				if(pointJ1 > pointJ2)
				{
					phrase += "2 a gagner";
				}
				else
				{
					phrase += "1 et 2 ont fait un match nul";
				}
			}
		}
		System.out.println(phrase);
	}
	
	/**
	 * test si la partie est finie
	 * @return un boolean qui dit si la partie est finie
	 */
	
	public boolean partieFini()
	{
		boolean fin = false;
		if(pointJ1 + pointJ2 == (hauteur-1) * (largueur-1))
		{
			fin = true;
		}
		return fin;
	}
	
	
	
}
