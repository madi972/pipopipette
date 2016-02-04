package poubelle;

import java.util.Scanner;

public class main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int hauteur = 0;
		int largeur = 0;
		int catJ2 = 0; // si le joueur est une IA ou pas
		int IAJ2 = 0; // categorie de l'IA
		int joueurActif = 0; // le joueur joue en 1er ou en 2eme
		int tourJoueur = 0; // tour de jeux
		int p1 = 0; // position 1 pour le coup
		int p2 = 0; // position 2 pour le coup
		int rebord = 0; // avoir les rebord rempli des le debut ou pas
		int condVictoire = 0;
		
								// Choix des paramétre //
		
		System.out.println("bonjour");
		hauteur = taperChiffre(3,7,"choisisser la hauteur de la grille");
		largeur = taperChiffre(3,7,"choisisser la largeur de la grille");
		rebord = taperChiffre(1,2,"jouer avec les rebord deja rempli 1) oui 2) non");
		catJ2 = taperChiffre(1,2,"taper 1 pour jouer contre un autre joueur 2 contre une IA");
		if(catJ2 == 2)
		{
			IAJ2 = taperChiffre(1,4,"choisisser le type de l'IA 1) simplet 2) prévoyant 3) idiot 4) pondéré");
		}
		condVictoire = taperChiffre(1,2,"taper 1 pour jouer normalement ou 2 en qui perd gagne");
		tourJoueur = taperChiffre(1,2,"voulez vous commencer en premmier 1) oui 2) non");
		
								// création du graphe //
		
		jeux jeux = new jeux(hauteur,largeur,IAJ2,tourJoueur,rebord,condVictoire);
		
								// déroulement du tour //
		
		while(!jeux.partieFini()) 
		{
			if(catJ2 == 2)
			{
				
								// Jeux avec une IA //
				
				if(joueurActif == tourJoueur) 
				{
					do
					{
					p1 = taperChiffre(0,hauteur*largeur-1,"choisissé le premier point");
					p2 = taperChiffre(0,hauteur*largeur-1,"puis le second");
					tourJoueur = jeux.coup(p1,p2,joueurActif); //a faire
					}
					while(!jeux.coupPossible(p1,p2)); // a faire
				}
				else
				{
					tourJoueur = jeux.coupIA(IAJ2,joueurActif); // a faire
				}	
			}
			else
			{
				
								// Jeux contre un autre joueur //
				
				do
				{
				p1 = taperChiffre(0,hauteur*largeur-1,"choisissé le premier point");
				p2 = taperChiffre(0,hauteur*largeur-1,"puis le second");
				tourJoueur = jeux.coup(p1,p2,joueurActif); // a faire
				}
				while(!jeux.coupPossible(p1,p2)); // a faire
			}
		}
		jeux.victoire();
	}

	/**
	 * sert a taper un int compris entre 2 bornes
	 * @param min int minimum
	 * @param max int maximum 
	 * @param phrase String a afficher en fonction de ce que l'on veut comme valeur.
	 * @return l'int choisi
	 */
	
	public static int taperChiffre(int min, int max, String phrase)
	{
		int i = 0;
		System.out.println(phrase);
		if(sc.hasNextInt())
		{
			i = sc.nextInt();
			if(i<min || i>max)
			{
				while(i<min || i>max){
					System.out.println(phrase);
					i = sc.nextInt();
				}
			}
		}
		else
		{
			System.out.println("cette entrée n'est pas valable");
			sc.next();
		}
		return i;
	}
	
	// finir le code et le reorganiser
	
}
