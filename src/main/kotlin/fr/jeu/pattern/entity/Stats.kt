package fr.jeu.pattern.entity

interface stats {
    /**
     * Le niveau actuel
     * @return lvl
     */
    fun addLvl(x:Int)
    fun getLvl(): Int
    /**
     * Degat min lorsque qu'un coup est infligé
     * @return degatMin
     */
    fun setDegatMin(x:Int)
    fun getDegatMin(): Int

    /**
     * Degat max lorsque qu'un coup est infligé
     * @return degatMax
     */
    fun setDegatMax(x:Int)
    fun getDegatMax(): Int

    /**
     * Chance de faire des dégats crittique lorsque qu'un coup est infligé
     * si coup crittique, on prend toujours les dégats max
     * @return crittique
     */
    fun setCrittique(x:Double)
    fun getCrittique(): Double

    /**
     * Multiplicateur crittique
     * @return degatCrittique
     */
    fun setDegatCrittique(x:Double)
    fun getDegatCrittique(): Double

    /**
     * Chance d'esquiver un coup lorsque qu'un coup est reçu
     * @return dodge
     */
    fun setDodge(x:Double)
    fun getDodge(): Double

    /**
     * Nombre de dégats réduit lorsque qu'un coup est reçu
     * @return def
     */
    fun setDef(x:Int)
    fun getDef(): Int

    /**
     * Nombre de pv actuelle
     * @return pv
     */
    fun setPv(x:Double)
    fun getPv(): Double

    /**
     * Nombre de pv max
     * @return pvMax
     */
    fun setPvMax(x:Int)
    fun getPvMax(): Int

    /**
     * Nombre d'utilisation de defense d'affilé
     * @return nbTourDef
     */
    fun setNbTourDef(x:Int)
    fun getNbTourDef(): Int

    /**
     * Limite d'utilisation de defense d'affilé
     * @return limiteTourDef
     */
    fun setLimiteTourDef(x:Int)
    fun getLimiteTourDef(): Int

    /**
     * Balle actuelle
     * @return nbBalle
     */
    fun setNbBalle(x:Int)
    fun getNbBalle(): Int

    /**
     * Taille du chargeur
     * @return nbBalleMax
     */
    fun setNbBalleMax(x:Int)
    fun getNbBalleMax(): Int

    /**
     * Balle rechargé en 1 tour
     * @return nbBalleRecharge
     */
    fun setNbBalleRecharge(x:Int)
    fun getNbBalleRecharge(): Int

    /**
     * Affiche les stats
     * @return stats
     */
    fun getStatsCombat()
    /**
     * Affiche toutes les stats
     */
    fun getStats()
}