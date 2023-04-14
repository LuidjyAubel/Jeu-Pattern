# JEU DESIGN PATTERN

-----------------------------------

## Pattern :
 - state pour passer d'un ennemi simple à un boss
 - décorator pour augmenter le lvl et les stats d'un ennemi
 - stratégie pour implémenter les compétence à effets qui change le déroulement du combat

## Classe :
- Joueur (le personage incarné par le joueur)
- Ennemy (les différents énnemis du jeu)
- EnnemyDecorator (Qui lvl up un ennemi)
- Competence (les compentences disponnible pour le joueur)
- etatNormal (classe de l'état normal Pattern State)
- etatBoss (classe de l'état boss Pattern State)

## Class Static :
- Combat qui assure le déroulement d'un combat entre un joueur et un ennemi 
- Magasin qui assure l'achats de stats / compétence du joueur

## Interface :
- etatEnnemy (interface du pattern state)
- stats (défini les méthodes utilise pour les stats du joueur et des ennemis)