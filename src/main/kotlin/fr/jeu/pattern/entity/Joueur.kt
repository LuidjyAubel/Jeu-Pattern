package fr.jeu.pattern.entity

class Joueur() : stats {
    /**
     * Stats par défaut joueur
     */
    private var lvl : Int = 0
    private var degatMin : Int = 1
    private var degatMax : Int = 3
    private var crittique : Double = 0.01
    private var degatCrittique : Double = 1.5
    private var dodge : Double = 0.01
    private var def : Int = 1
    private var pv : Double = 10.0
    private var pvMax : Int = 10
    private var nbTourDef : Int = 0
    private var limiteTourDef : Int = 1
    private var nbBalle : Int = 0
    private var nbBalleMax : Int = 200
    private var nbBalleRecharge : Int = 1

    override fun getLvl(): Int {
       return lvl
    }

    override fun addLvl(x:Int){
        lvl += x
    }

    fun delLvl(x:Int){
        lvl -= x
    }

    override fun setDegatMin(x: Int) {
        degatMin = x
    }

    override fun getDegatMin(): Int {
        return degatMin
    }

    override fun setDegatMax(x: Int) {
        degatMax = x
    }

    override fun getDegatMax(): Int {
        return degatMax
    }

    override fun setCrittique(x: Double) {
        crittique = x
    }

    override fun getCrittique(): Double {
        return crittique
    }

    override fun setDegatCrittique(x: Double) {
       degatCrittique = x
    }

    override fun getDegatCrittique(): Double {
        return degatCrittique
    }

    override fun setDodge(x: Double) {
        dodge = x
    }

    override fun getDodge(): Double {
        return dodge
    }

    override fun setDef(x: Int) {
        def = x
    }

    override fun getDef(): Int {
        return def
    }

    override fun setPv(x: Double) {
        pv = x
    }

    override fun getPv(): Double {
        return pv
    }

    override fun setPvMax(x: Int) {
        pvMax = x
    }

    override fun getPvMax(): Int {
        return pvMax
    }

    override fun setNbTourDef(x: Int) {
       nbTourDef = x
    }

    override fun getNbTourDef(): Int {
        return nbTourDef
    }

    override fun setLimiteTourDef(x: Int) {
        limiteTourDef =x
    }

    override fun getLimiteTourDef(): Int {
        return limiteTourDef
    }

    override fun setNbBalle(x: Int) {
        nbBalle = x
    }

    override fun getNbBalle(): Int {
        return nbBalle
    }

    override fun setNbBalleMax(x: Int) {
        nbBalleMax = x
    }

    override fun getNbBalleMax(): Int {
        return nbBalleMax
    }

    override fun setNbBalleRecharge(x: Int) {
        nbBalleRecharge = x
    }

    override fun getNbBalleRecharge(): Int {
        return nbBalleRecharge
    }

    override fun getStatsCombat() {
        System.out.println("\nJoueur")
        System.out.println("PV : "+pv+" / "+pvMax)
        System.out.println("Balle "+nbBalle+" / "+nbBalleMax)
        System.out.println("Limite tour de def "+nbTourDef+" / "+limiteTourDef+"\n")
    }

    override fun getStats() {
        System.out.println("\nJoueur")
        System.out.println("Points de compétences: "+lvl)
        System.out.println("PV : "+pv+" / "+pvMax)
        System.out.println("DEF: "+def)
        System.out.println("Dégats min: "+degatMin)
        System.out.println("Dégats max: "+(degatMin+degatMax))
        System.out.println("Chance critique: "+crittique)
        System.out.println("Multiplicateur critique: "+degatCrittique)
        System.out.println("Chance d'esquive: "+dodge)
        System.out.println("Nombre de balle: "+nbBalleMax)
        System.out.println("Balle rechargé par tour: "+nbBalleRecharge)
        System.out.println("Limite tour de def "+limiteTourDef+"\n")
    }
}