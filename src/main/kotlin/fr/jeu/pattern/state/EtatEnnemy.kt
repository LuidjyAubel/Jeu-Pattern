package fr.jeu.pattern.state

// patern state
interface etatEnnemy {
    /**
     * Revois les stats en simplifié
     */
    fun getStatsCombat()
    /**
     * Revois si l'ennemi est un boss
     */
    fun getBoolBoss(): Boolean
}