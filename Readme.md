<span style="color: blue">Jeu de Sudoku</span> 
=============
*Réalisé par Pierre Mazurek*

Ce jeu, plutôt simple, permet de générer de manière complètement aléatoire une grille de Sudoku puis de retirer au hasard 50 cases puis de les remplacer par des "0". On doit donc retrouver le contenu de ces cases pour pouvoir résoudre le Sudoku. Le Sudoku est directement affiché sur la console lorsqu'on éxecute la classe `Main.java`.


![Sudoku à résoudre](https://i.imgur.com/QI6EKqw.jpg)


Il est également possible de visualiser une des solutions possibles pour ce sudoku en tapant 1 et en validant.


![Affichage d'une des solutions du Sudoku](https://i.imgur.com/d8dFL5h.jpg)


**Vous avez malencontreusement appuyé sur un autre touche que le 1 ? Pas de panique !**
Le programme est ainsi fait pour réafficher le Sudoku si vous n'avez pas tapé 1 en dessous de la dernière ligne.


![Réaffichage du Sudoku si mauvaise touche tapée](https://i.imgur.com/QI6EKqw.jpg)


Chaque Sudoku généré est unique, il est donc possible de recompiler le programme pour commencer une nouvelle partie...

Le programme est composé de trois classes Java : `Main.java`, `Grille.java` et `Case.java`.