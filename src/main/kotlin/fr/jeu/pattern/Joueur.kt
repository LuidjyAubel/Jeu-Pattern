package fr.jeu.pattern

class Joueur(unId : String,unNom :String, unPV : Double,
             unPA : Double, uneVIT : Double, uneDEF : Double,unXP : Double, uneComp : MutableList<Competence>) {
    private var id: String = unId
    private var nom : String = unNom // le nom du joueur
    private var PV: Double = unPV //point de vie
    private var PA: Double = unPA //Point d'attaque
    private var VIT: Double = uneVIT    // vitesse de l'ennemi
    private var DEF: Double = uneDEF   // Defense de l'ennemi
    private var XP : Double = unXP // l'expérience du joueur
    private var Competence : MutableList<Competence> = uneComp // liste des compétence de l'utilisateur

    fun getId(): String {
        return id
    }
    fun getNom() : String{
        return nom
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
    fun getXP() : Double{
        return XP
    }
    fun getCompetence(): MutableList<Competence>{
        return Competence
    }
    fun setCompetence(x : MutableList<Competence>){
        Competence = x
    }
    fun setUneCompetence(x : Competence){
        Competence.add(x)
    }
    fun setId(x: String) {
        id = x
    }
    fun setNom(x : String){
        nom = x
    }
    fun setPV(x: Double) {
        PV = x
    }
    fun setPA(x: Double) {
        PA = x
    }
    fun setVIT(x: Double) {
        VIT = x
    }
    fun setDEF(x: Double) {
        DEF = x
    }
    fun setXP(x : Double){
        XP = x
    }
    override fun toString(): String {
        return "Nom : "+nom+" PV : "+ PV+" XP : "+XP
    }
}