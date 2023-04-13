package fr.jeu.pattern

open class Ennemy() : stats{
    /**
     * Stats par défaut ennemi
     */
    private var lvl : Int = 0
    private var degatMin : Int = 1
    private var degatMax : Int = 0
    private var crittique : Double = 0.01
    private var degatCrittique : Double = 1.25
    private var dodge : Double = 0.01
    private var def : Int = 0
    private var pv : Double = 3.0
    private var pvMax : Int = 3
    private var nbTourDef : Int = 0
    private var limiteTourDef : Int = 1
    private var nbBalle : Int = 0
    private var nbBalleMax : Int = 2
    private var nbBalleRecharge : Int = 1

    private var etatEnNormal = etatNormal(this);
    private var etatEnBoss = etatDeBoss(this);
    private var etat : etatEnnemy = etatEnNormal;

    fun setLevelBase(){
        lvl = 0
        degatMin = 1
        degatMax = 0
        crittique = 0.01
        degatCrittique = 1.25
        dodge = 0.01
        def = 0
        pv = 3.0
        pvMax = 3
        nbTourDef = 0
        limiteTourDef = 1
        nbBalle = 0
        nbBalleMax = 2
        nbBalleRecharge = 1
    }

    fun lvlUp(){
        addLvl(1)
        if (lvl % 5 == 0){
            when ((0..2).random()) {
                0 ->{
                    limiteTourDef++
                    System.out.println("L'ennemi à plus de tours de défense")
                }
                1 ->{
                    nbBalleMax++
                    System.out.println("L'ennemi à un plus grand chargeur")
                }
                2 ->{
                    nbBalleRecharge++
                    System.out.println("L'ennemi recharge plus de balle par tour")
                }
            }
        } else {
            when ((0..2).random()) {
                0 -> {
                    degatMin++
                    degatMax += 3
                    System.out.println("L'ennemi inflige plus de dégats")
                }

                1 -> {
                    pvMax += 3
                    def++
                    System.out.println("L'ennemi à plus de vie et de défense")
                }

                2 -> {
                    crittique += 0.01
                    dodge += 0.01
                    System.out.println("L'ennemi à plus de chance d'esquive et de chance de crittique")
                }
            }
        }
        degatCrittique += 0.01
        pv = pvMax.toDouble()
    }

    override fun getLvl(): Int {
        return lvl
    }

    override fun addLvl(x:Int){
        lvl += x
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
        System.out.println("\nEnnemy")
        System.out.println("PV : "+pv+" / "+pvMax)
        System.out.println("Balle "+nbBalle+" / "+nbBalleMax)
        System.out.println("Limite tour de def "+nbTourDef+" / "+limiteTourDef+"\n")
    }
    // changement d'état de l'ennemi
    fun etatNormal(){
        etat.Normal();
    }
    fun etatBoss(ennemy: Ennemy) {
        etat.Boss();
    }
    fun changeEtatBoss(){
        etat = etatEnNormal;
    }
    fun changeEtatNormal(){
        etat = etatEnBoss;
    }
    override fun getStats() {
        System.out.println("\nEnnemi")
        System.out.println("LVL: "+lvl)
        System.out.println("PV max: "+pvMax)
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