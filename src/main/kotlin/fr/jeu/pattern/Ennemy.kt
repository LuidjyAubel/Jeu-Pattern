package fr.jeu.pattern

class Ennemy(unId : String, unPV : Double,
          unPA : Double, uneVIT : Double, uneDEF : Double, boolBoss : Boolean){

    private var id : String = unId
    private var PV : Double = unPV //point de vie
    private var PA : Double = unPA //Point d'attaque
    private var VIT :Double = uneVIT    // vitesse de l'ennemi
    private var DEF : Double = uneDEF   // Defense de l'ennemi
    private var Boss : Boolean = boolBoss // est un boss ?

    fun getId(): String {
        return id
    }
    fun getPV(): Double {
        return PV
    }
    fun getPA(): Double {
        return PA
    }
    fun getVIT(): Double {
        return VIT
    }
    fun getDEF(): Double {
        return DEF
    }
    fun getBoss(): Boolean{
        return Boss
    }
    fun setId(x : String) {
        id = x
    }
    fun setPV(x : Double) {
        PV = x
    }
    fun setPA(x : Double) {
        PA = x
    }
    fun setVIT(x : Double) {
        VIT = x
    }
    fun setDEF(x : Double){
        DEF = x
    }
    fun setBoss(x : Boolean){
        Boss = x
    }
}
