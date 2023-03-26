package fr.jeu.pattern
abstract class ennemyDecorator(private val ennemy : Ennemy) : Ennemy() {
    override fun getPA(): Double {
        return ennemy.getPA()
    }
    override fun getVIT(): Double {
        return ennemy.getVIT()
    }
    override fun getDEF(): Double {
        return ennemy.getDEF()
    }
    override fun getBoss(): Boolean{
        return ennemy.getBoss()
    }
}