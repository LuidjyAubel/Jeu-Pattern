package fr.jeu.pattern

abstract class Ennemy{

    protected lateinit var id : String
    protected abstract var PV : Double //point de vie
    protected abstract var PA : Double//Point d'attaque
    protected abstract var VIT :Double  // vitesse de l'ennemi
    protected abstract var DEF : Double  // Defense de l'ennemi
    protected abstract var Boss : Boolean // est un boss ?

    open fun getId(): String {
        return id
    }
    open fun getPV(): Double {
        return PV
    }
    open fun getPA(): Double {
        return PA
    }
    open fun getVIT(): Double {
        return VIT
    }
    open fun getDEF(): Double {
        return DEF
    }
    open fun getBoss(): Boolean{
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
