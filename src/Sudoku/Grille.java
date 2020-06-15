
package Sudoku;

import java.util.Scanner;

public class Grille {
	
	public void main(String[] args) {
	}
	
	private int[][] Grille;
	private int[][] Solution;
	
	public Grille() {
        Grille = new int[9][9];
        Solution = new int[9][9];
        this.genererSudoku();
	}
	public int[][] getGrille() {
        return this.Grille.clone();
    }
	public int[][] getSolution(){
		return this.Solution.clone();
	}
	
	
	public int getCase (int chiffre, int ligne, int colonne) {
		return Grille[ligne][colonne];
	}
	
	public void setCase (int chiffre, int ligne, int colonne) {
		this.Grille[ligne][colonne] = chiffre;
	}
    

	private boolean chiffreEstDansLigne(int chiffre, int ligne) {
		boolean reponse = false;
		for(int i=0; i<9; i++) {
			if(Grille[ligne][i]==chiffre) {
				reponse = true;
				break;
			}
		}
		return reponse;
	}
	
	private boolean chiffreEstDansColonne(int chiffre, int colonne) {
		boolean reponse = false;
		for(int i=0; i<9; i++) {
			if(Grille[i][colonne]==chiffre) {
				reponse = true;
				break;
			}
		}
		return reponse;
	}
	
	private boolean chiffreEstDansCarre(int chiffre, int ligne, int colonne) {
		boolean reponse = false;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (Grille[ligne+i][colonne+j]==chiffre) {
					reponse = true;
					break;
				}
			}
		}
		return reponse;
	}
		
	public boolean possibleDePlacer(int chiffre, int ligne, int colonne) {
		boolean reponse = true;
		if(chiffreEstDansLigne(chiffre, ligne) || chiffreEstDansColonne(chiffre, colonne) || chiffreEstDansCarre(chiffre, ligne-ligne%3, colonne-colonne%3)) {
			reponse = false;
		}
		return reponse;
	}
	
	private int getChiffreAleatoire() {
		return (int) Math.floor(Math.random()*9+1);
	}
	
	private int supprimerChiffre() {
		int n = 50;
		boolean suppressionEnCours = true;
		while(suppressionEnCours) {
			int ligne = getChiffreAleatoire()-1;
			int colonne = getChiffreAleatoire()-1;
			if(Grille[ligne][colonne]!=0) {
				Grille[ligne][colonne]=0;
				n--;
				if (n<=0) {
					suppressionEnCours = false;
				}
			}
		}
		return n;
	}
	
	public Case getCaseAleatoire() {
		int x = getChiffreAleatoire()-1;
		int y = getChiffreAleatoire()-1;
		Case caseInitiale = new Case(x,y);
		while(Grille[x][y]==Solution[x][y]) {
			y++;
			if(x>8) {
				x=0;
			}
			if(y>8) {
				y=0; x++;
			}
			if (x==caseInitiale.getX() && y==caseInitiale.getY()) {
				return null;
			}
		}
		return new Case(x,y);
	}
	
	private void remplirCarre(int ligne, int colonne) {
		int chiffre = getChiffreAleatoire();
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				while(chiffreEstDansCarre(chiffre, ligne, colonne)) {
					chiffre = getChiffreAleatoire();
				}
				Grille[ligne+i][colonne+j] = chiffre;
			}
		}
	}
	
	private void remplirDiagonale() {
		for (int i=0; i<9; i+=3) {
			remplirCarre(i,i);
		}
	}
	
	private boolean remplirGrille(int ligne, int colonne) {
		if (colonne >=9 && ligne<8) {
			colonne=0; ligne+=1;
		}
		if (colonne>=9 && ligne >=9) {
			return true;
		}
		if (ligne<3) {
			if (colonne<3) {
				colonne =3;
			}
		}
		else if (ligne<6) {
			if (colonne >=3 && colonne<6) {
				colonne = 6;
			}
		}
		else if (colonne >=6) {
			ligne+=1; colonne=0;
			if (ligne >=9) {
				return true;
			}
		}
		for (int chiffre=1; chiffre<=9; chiffre++) {
			if (possibleDePlacer(chiffre, ligne, colonne)) {
				Grille[ligne][colonne]=chiffre;
				if (remplirGrille(ligne, colonne+1)) {
					return true;
				}
				Grille[ligne][colonne]=0;
			}
		}
		return false;
	}
	
	public void genererSudoku() {
		remplirDiagonale();
		remplirGrille(0,3);
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.Solution[i][j] = Grille[i][j];
            }
        }
		supprimerChiffre();
	}
	
	public String toString() {
		String sudoku = "";
		sudoku +="          +-------+-------+-------+" + "\n" + "          | " + Grille [0][0] + " " + Grille [0][1] + " "+ Grille [0][2] + " | " + Grille [0][3] + " " + Grille [0][4] + " "+ Grille [0][5] + " | " + Grille [0][6] + " " + Grille [0][7] + " "+ Grille [0][8] + " | " + "\n         " + " | " + Grille [1][0] + " " + Grille [1][1] + " "+ Grille [1][2] + " | " + Grille [1][3] + " " + Grille [1][4] + " "+ Grille [1][5] + " | " + Grille [1][6] + " " + Grille [1][7] + " "+ Grille [1][8] + " | " +"\n         " + " | " + Grille [2][0] + " " + Grille [2][1] + " "+ Grille [2][2] + " | " + Grille [2][3] + " " + Grille [2][4] + " "+ Grille [2][5] + " | " + Grille [2][6] + " " + Grille [2][7] + " "+ Grille [2][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		sudoku +="\n         " + " | " + Grille [3][0] + " " + Grille [3][1] + " "+ Grille [3][2] + " | " + Grille [3][3] + " " + Grille [3][4] + " "+ Grille [3][5] + " | " + Grille [3][6] + " " + Grille [3][7] + " "+ Grille [3][8] + " | " + "\n         " + " | " + Grille [4][0] + " " + Grille [4][1] + " "+ Grille [4][2] + " | " + Grille [4][3] + " " + Grille [4][4] + " "+ Grille [4][5] + " | " + Grille [4][6] + " " + Grille [4][7] + " "+ Grille [4][8] + " | " +"\n         " + " | " + Grille [5][0] + " " + Grille [5][1] + " "+ Grille [5][2] + " | " + Grille [5][3] + " " + Grille [5][4] + " "+ Grille [5][5] + " | " + Grille [5][6] + " " + Grille [5][7] + " "+ Grille [5][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		sudoku +="\n         " + " | " + Grille [6][0] + " " + Grille [6][1] + " "+ Grille [6][2] + " | " + Grille [6][3] + " " + Grille [6][4] + " "+ Grille [6][5] + " | " + Grille [6][6] + " " + Grille [6][7] + " "+ Grille [6][8] + " | " + "\n         " + " | " + Grille [7][0] + " " + Grille [7][1] + " "+ Grille [7][2] + " | " + Grille [7][3] + " " + Grille [7][4] + " "+ Grille [7][5] + " | " + Grille [7][6] + " " + Grille [7][7] + " "+ Grille [7][8] + " | " +"\n         " + " | " + Grille [8][0] + " " + Grille [8][1] + " "+ Grille [8][2] + " | " + Grille [8][3] + " " + Grille [8][4] + " "+ Grille [8][5] + " | " + Grille [8][6] + " " + Grille [8][7] + " "+ Grille [8][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		return sudoku;
	}
	
	public void afficherSolution() {
		Scanner sc = new Scanner(System.in);
		char reponse = ' ';
		System.out.println("Taper 1 si vous souhaitez afficher une des \n    solutions possibles pour ce Sudoku : ");
		reponse = sc.nextLine().charAt(0);
		if (reponse == '1') {
			System.out.println("\n" + "Voici une des solutions possibles pour ce Sudoku :" + "\n");
			this.displaySolution();
		}
		if (reponse != '1') {
			System.out.println("\n");
			System.out.println("Vous n'avez pas tapé 1, nous vous laissons continuer votre Sudoku." + "\n");
			this.displaySudoku();
		}
	}
	
	public void displaySudoku() {
		System.out.println("*---------------Jeu de Sudoku---------------*" + "\n" + "Remplacez les zéros par les nombres manquants" + "\n");
		System.out.println(this);
		System.out.println("\n");
		this.afficherSolution();
	}
	
	public void displaySolution() {
		String sudoku = "";
		sudoku +="          +-------+-------+-------+" + "\n" + "          | " + Solution [0][0] + " " + Solution [0][1] + " "+ Solution [0][2] + " | " + Solution [0][3] + " " + Solution [0][4] + " "+ Solution [0][5] + " | " + Solution [0][6] + " " + Solution [0][7] + " "+ Solution [0][8] + " | " + "\n         " + " | " + Solution [1][0] + " " + Solution [1][1] + " "+ Solution [1][2] + " | " + Solution [1][3] + " " + Solution [1][4] + " "+ Solution [1][5] + " | " + Solution [1][6] + " " + Solution [1][7] + " "+ Solution [1][8] + " | " +"\n         " + " | " + Solution [2][0] + " " + Solution [2][1] + " "+ Solution [2][2] + " | " + Solution [2][3] + " " + Solution [2][4] + " "+ Solution [2][5] + " | " + Solution [2][6] + " " + Solution [2][7] + " "+ Solution [2][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		sudoku +="\n         " + " | " + Solution [3][0] + " " + Solution [3][1] + " "+ Solution [3][2] + " | " + Solution [3][3] + " " + Solution [3][4] + " "+ Solution [3][5] + " | " + Solution [3][6] + " " + Solution [3][7] + " "+ Solution [3][8] + " | " + "\n         " + " | " + Solution [4][0] + " " + Solution [4][1] + " "+ Solution [4][2] + " | " + Solution [4][3] + " " + Solution [4][4] + " "+ Solution [4][5] + " | " + Solution [4][6] + " " + Solution [4][7] + " "+ Solution [4][8] + " | " +"\n         " + " | " + Solution [5][0] + " " + Solution [5][1] + " "+ Solution [5][2] + " | " + Solution [5][3] + " " + Solution [5][4] + " "+ Solution [5][5] + " | " + Solution [5][6] + " " + Solution [5][7] + " "+ Solution [5][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		sudoku +="\n         " + " | " + Solution [6][0] + " " + Solution [6][1] + " "+ Solution [6][2] + " | " + Solution [6][3] + " " + Solution [6][4] + " "+ Solution [6][5] + " | " + Solution [6][6] + " " + Solution [6][7] + " "+ Solution [6][8] + " | " + "\n         " + " | " + Solution [7][0] + " " + Solution [7][1] + " "+ Solution [7][2] + " | " + Solution [7][3] + " " + Solution [7][4] + " "+ Solution [7][5] + " | " + Solution [7][6] + " " + Solution [7][7] + " "+ Solution [7][8] + " | " +"\n         " + " | " + Solution [8][0] + " " + Solution [8][1] + " "+ Solution [8][2] + " | " + Solution [8][3] + " " + Solution [8][4] + " "+ Solution [8][5] + " | " + Solution [8][6] + " " + Solution [8][7] + " "+ Solution [8][8] + " | " + "\n" +"          +-------+-------+-------+ ";
		System.out.println(sudoku);
	}
	
	public boolean sudokuComplet() {
		boolean reponse = true;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if(Grille[i][j]!=Solution[i][j]) {
					reponse = false;
					break;
				}
			}
		}
		return reponse;
	}
	
}
