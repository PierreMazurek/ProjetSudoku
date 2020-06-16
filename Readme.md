Jeu de Sudoku 
=============
*Réalisé par Pierre Mazurek*


**1. Présentation**
---------------
Ce jeu, plutôt simple, permet de générer de manière complètement aléatoire une grille de Sudoku puis de retirer au hasard 50 cases, remplacées par des "0". On doit donc retrouver le contenu de ces cases pour pouvoir résoudre le Sudoku. Le Sudoku est directement affiché sur la console lorsqu'on éxecute la classe `Main.java`.


![Sudoku à résoudre](https://i.imgur.com/QI6EKqw.jpg)


Il est également possible de visualiser une des solutions possibles pour ce sudoku en tapant 1 et en validant.


![Affichage d'une des solutions du Sudoku](https://i.imgur.com/d8dFL5h.jpg)


**Vous avez malencontreusement appuyé sur un autre touche que le 1 ? Pas de panique !**

Le programme est ainsi fait pour réafficher le Sudoku si vous n'avez pas tapé 1 en dessous de la dernière ligne.


![Réaffichage du Sudoku si mauvaise touche tapée](https://i.imgur.com/QI6EKqw.jpg)


Chaque Sudoku généré est unique, il est donc possible de recompiler le programme pour commencer une nouvelle partie...

Le programme est composé de trois classes Java : `Main.java`, `Grille.java` et `Case.java`.


**2. Détail du code du programme**
------------------------------
Toutes les classes ayant servi pour construire ce petit programme sont disponibles dans l'[onglet src](https://github.com/PierreMazurek/ProjetSudoku/tree/master/src/Sudoku).
 
-------------

Intéressons nous tout d'abord à la classe [`Case.java`](https://github.com/PierreMazurek/ProjetSudoku/blob/master/src/Sudoku/Case.java). 
Cette classe va simplement construire l'objet classe avec le numéro de sa ligne et de sa colonne avec les mutateurs et accesseurs correspondant.
 
------------

Entrons tout de suite dans le vif du sujet : la classe [`Grille.java`](https://github.com/PierreMazurek/ProjetSudoku/blob/master/src/Sudoku/Grille.java). Il s'agit du coeur du projet. Bien que ce format de fichier ne s'y prête pas forcément, c'est ici que nous détaillerons au mieux chaque méthode déclarée.

Le code de cette classe débute par un constructeur qui nous permet de déclarer deux tableaux de 9 lignes et 9 colonnes : `Grille` et `Solution`, respectivement la grille de Sudoku et une des solutions possibles.

Vient ensuite les accesseurs permettant de retourner directement les deux tableaux déclarés précédemment. 

Il y a également des accesseurs et mutateurs pour l'objet Case. 

Il est alors possible d'obtenir la valeur de la Case en fonction des numéros de sa colonne et de sa ligne et de lui attribuer un chiffre.

On déclare ensuite les méthodes `chiffreEstDansLigne`, `chiffreEstDansColonne` et `chiffreEstDansCarre` (précisons qu'un **Carré** vaut 3x3 cases et dois lui aussi contenir des valeurs distinctes de 1 à 9 dans la résolution du Sudoku). Ces méthodes permettent de vérifier si le chiffre existe ou non via son numéro de ligne, de colonne ou de Carré.

La méthode `possibleDePlacer` permet de savoir si le chiffre a oui ou non déjà été placé dans les lignes, colonnes ou Carrés. Cela sera utile pour générer le Sudoku.

On a ensuite la méthode `getChiffreAleatoire` qui va simplement renvoyer une valeur aléatoire entre 1 et 9.

Venons en à la méthode `supprimerChiffre`. Cette dernière va nous permettre de prendre 50 valeurs aléatoires sur toute la grille générée, de les supprimer et de les remplacer par des "0".

Par la suite, les méthodes `remplirCarre`, `remplirDiagonale` et `remplirGrille` vont nous permettre de remplir entièrement la grille de Sudoku en vérifiant qu'il y ait bien des valeurs distinctes de 1 à 9 pour chaque ligne, colonne et Carré. On commence tout d'abord à remplir les Carrés en diagonale puis on remplit le reste des cases une à une.

On génère ensuite la grille de Sudoku avec la méthode `genererSudoku` qui remplit la grille de Sudoku `Grille` avec les méthodes de remplissage définies précédemment, fait prendre la même valeur à la variable `Solution` puis retire les cases de la variable `Grille` avec la méthode `supprimerChiffre`.

Il en résulte deux grilles, `Grille` et `Solution` qui sont respectivement la grille de Sudoku à compléter et une des solutions possibles pour ce Sudoku.

Il ne reste ensuite que les méthodes d'affichage : 
* `toString` qui va permettre d'afficher la grille de Sudoku à compléter, la méthode. 
* `displaySudoku` et qui va permettre d'afficher un message pour introduire la grille de Sudoku, la grille de Sudoku en elle-même (en appelant la méthode`toString`) et de proposer de voir la solution (en appelant la méthode `afficherSolution`).
* `afficherSolution` qui va permettre d'afficher la solution si on tape 1 (en appelant la méthode `displaySolution`) ou de réafficher la grille de Sudoku pour n'importe quelle autre valeur entrée.
* `displaySolution` qui est en fait la méthode `toString` appliquée à la variable`Solution`.

 
-----------------

Enfin, la classe [`Main.java`](https://github.com/PierreMazurek/ProjetSudoku/blob/master/src/Sudoku/Main.java) va simplement créer un nouvel objet **a** de type `Grille` puis lui appliquer la méthode `displaySudoku`.

**3. Conclusion**
------------------
Bien qu'il s'agisse d'un petit programme, toutes les classes fonctionnent et leur exécution permet de générer une grille de Sudoku directement dans la console avec la possibilité de pouvoir voir une des solutions possibles. La réalisation de ce programme aura permis de revoir les bases du langage Java déjà consolidées par la réalisation des Travaux Pratiques. 
  
 
 
 


*Pierre Mazurek ESIREM 3A IE - Projet Java Sudoku 2020*