package fr.jeu.pattern

class Boss( ennemy: Ennemy) : ennemyDecorator(ennemy) {
    override var PV : Double = 100.00 //point de vie
    override  var PA : Double = 10.00 //Point d'attaque
    override var VIT : Double =  5.00  // vitesse de l'ennemi
    override var DEF : Double = 10.00 // Defense de l'ennemi
    override var Boss : Boolean = true // est un boss ?

}