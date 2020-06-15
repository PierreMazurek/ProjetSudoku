Jeu de Sudoku 
=============
*Réalisé par Pierre Mazurek*


1. Présentation
---------------
Ce jeu, plutôt simple, permet de générer de manière complètement aléatoire une grille de Sudoku puis de retirer au hasard 50 cases puis de les remplacer par des "0". On doit donc retrouver le contenu de ces cases pour pouvoir résoudre le Sudoku. Le Sudoku est directement affiché sur la console lorsqu'on éxecute la classe `Main.java`.


![Sudoku à résoudre](https://i.imgur.com/QI6EKqw.jpg)


Il est également possible de visualiser une des solutions possibles pour ce sudoku en tapant 1 et en validant.


![Affichage d'une des solutions du Sudoku](https://i.imgur.com/d8dFL5h.jpg)


**Vous avez malencontreusement appuyé sur un autre touche que le 1 ? Pas de panique !**
Le programme est ainsi fait pour réafficher le Sudoku si vous n'avez pas tapé 1 en dessous de la dernière ligne.


![Réaffichage du Sudoku si mauvaise touche tapée](https://i.imgur.com/QI6EKqw.jpg)


Chaque Sudoku généré est unique, il est donc possible de recompiler le programme pour commencer une nouvelle partie...

Le programme est composé de trois classes Java : `Main.java`, `Grille.java` et `Case.java`.

2. Détail du code du programme
------------------------------
Toutes les classes ayant servi pour construire ce petit programme sont disponibles dans l'[onglet src](https://github.com/PierreMazurek/ProjetSudoku/tree/master/src/Sudoku).

Intéressons nous tout d'abord à la classe `Case.java`. 
Cette classe va simplement construire l'objet classe avec le numéro de sa ligne et de sa colonne avec les mutateurs et accesseurs correspondant.

Entrons tout de suite dans le vif du sujet : la classe `Grille.java`. Il s'agit du coeur du projet. Bien que ce format de fichier ne s'y prête pas forcément, c'est ici que nous détaillerons au mieux chaque méthode déclarée.  