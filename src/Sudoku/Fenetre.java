package Sudoku;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Fenetre {
	public static void main(String[] args) {
		JPanel pan = new JPanel();
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Sudoku Pierre MAZUREK");
		fenetre.setSize(600,600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton voirSolution = new JButton("Voir la solution");
		pan.add(voirSolution);
		fenetre.setContentPane(voirSolution);
		fenetre.setVisible(true);
	}

}

