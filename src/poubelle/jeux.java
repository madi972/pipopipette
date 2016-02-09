package poubelle;

public class Jeux 
{
	private int tourJ1;
	private int hauteur;
	private int largueur;
	private IA categorieIA;
	private int pointJ1;
	private int pointJ2;
	private LDA graphe;
	private int condVictoire;
	
	
	public Jeux (int hauteur ,int largeur ,int IAJ2 ,int tourJoueur ,int rebord,int condVictoire)
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
	
	/**
	 * sert a choisir les coup en fonction de l'IA choisi
	 * @param IAJ2 ia choisi avant la partit
	 * @param joueurActif valeur du tour
	 */
	 
	public void coupIA(int IAJ2, int joueurActif)
	{
		switch (IAJ2)
		{
		case 1:
			IASimplet(joueurActif,this.hauteur,this.largueur);
			break;
		}
	}
	
	/**
	 * IA aléatoire
	 * @param joueurActif valeur du tour
	 * @param hauteur hauteur de la grille
	 * @param largueur largueur de la grille
	 */
	
	public void IASimplet(int joueurActif,int hauteur, int largueur)
	{
		int p1 = 0;
		int p2 = 0;
		int random = 0;
		do
		{
			int nbPoint = hauteur*largueur-1;
			p1 = (int)(Math.random()*(nbPoint-0))+0;
			if(p1 == 0)
			{
				random = (int)(Math.random()*(2-1))+1;
			}
			if(p1 == nbPoint)
			{
				random = (int)(Math.random()*(4-3))+3;
			}
			if(p1 > 0 && p1 < nbPoint - largueur)
			{
				random = (int)(Math.random()*(3-1))+1;
			}
			if(p1 < nbPoint && p1 > largueur)
			{
				random = (int)(Math.random()*(4-2))+2;
			}
			switch (random)
			{
			case 1:
				p2 = p1+largueur;
				break;
			case 2:
				p2 = p1+1;
				break;
			case 3:
				p2 = p1-1;
				break;
			case 4:
				p2 = p1-largueur;
				break;
			}
		}while(coupPossible(p1,p2));
		
	}
	
	
}
