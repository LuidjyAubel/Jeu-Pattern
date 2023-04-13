package fr.jeu.pattern

class etatNormal(ennemy: Ennemy) : etatEnnemy{
    private var en : Ennemy = ennemy
    override fun getPvMax() {
        en.getPvMax()
    }

    override fun getDef() {
        en.getDef()
    }

    override fun getDegatMin() {
        en.getDegatMin()
    }
}