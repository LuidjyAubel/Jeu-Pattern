package fr.jeu.pattern

class etatDeBoss(ennemy: Ennemy) : etatEnnemy{
    private var en : Ennemy = ennemy
    override fun getPvMax() {
        en.getPvMax()*2
    }

    override fun getDef() {
        en.getDef()*2
    }

    override fun getDegatMin() {
        en.getDegatMin()*2
    }
}